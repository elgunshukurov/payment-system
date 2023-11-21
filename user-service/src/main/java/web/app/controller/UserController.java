package web.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import web.app.domain.User;
import web.app.dto.request.CardRequest;
import web.app.dto.request.PaymentRequest;
import web.app.dto.request.ProductRequest;
import web.app.dto.request.TransactionRequest;
import web.app.dto.users.UserDto;
import web.app.repository.UserRepository;
import web.app.security.auth.services.JwtService;
import web.app.service.*;
import web.app.dto.auth.AccessTokenDto;
import web.app.dto.auth.LoginDto;
import web.app.dto.auth.SignUpDto;
import org.springframework.web.bind.annotation.*;
import web.app.util.exception.UserNotFoundException;

import javax.validation.Valid;
import java.time.Duration;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private static final Duration ONE_DAY = Duration.ofDays(1);
    private static final Duration ONE_WEEK = Duration.ofDays(7);

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtService jwtService;
    private final UserService userService;
    private final CardServiceClient cardServiceClient;
    private final ProductServiceClient productServiceClient;
    private final TransactionServiceClient transactionServiceClient;

    @GetMapping
    public String test(){
        return "Test method";
    }

    @SneakyThrows
    @PostMapping("/sign-in")
    public ResponseEntity<AccessTokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {
        log.info("Login request by user {}", loginDto.getEmail());
        userRepository.findByUsername(loginDto.getEmail())
                .orElseThrow(UserNotFoundException::new);

        log.info("Authenticating user {}", loginDto.getEmail());
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getEmail(),
                loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Duration duration = getDuration(loginDto.getRememberMe());
        String jwt = jwtService.issueToken(authentication, duration);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
        return new ResponseEntity<>(new AccessTokenDto(jwt), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody @Validated SignUpDto dto) {
        log.info("Sign up request with email {}", dto.getEmail());
        userService.signUp(dto);
        return ResponseEntity.ok().build();
    }

    private Duration getDuration(Boolean rememberMe) {
        return ((rememberMe != null) && rememberMe) ? ONE_WEEK : ONE_DAY;
    }

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductRequest>> getAllProducts() {
        return productServiceClient.getAllProducts();
    }

    @PostMapping("/card/add")
    public void addCard(@RequestBody CardRequest card) {
        Long userId = card.getUserId();
        log.info("Credit card cache wiped for user {}.", userId);

        if(userRepository.findById(userId).isEmpty()){
            throw new IllegalArgumentException("User Id Not Found " + userId);
        }

        cardServiceClient.addCard(card);

        log.info("User with id {} added a new card with number {}.", userId,card.getCardNumber());
    }

    @GetMapping("/card/{userId}/cards")
    public List<CardRequest> getUserCards(@PathVariable String userId) {
        log.info("List of Cards returned by userId {}", userId);
        return cardServiceClient.getCardsForUser(userId);
    }

    @PostMapping("/{userId}/payments")
    public String makePayment(@PathVariable String userId, @RequestBody PaymentRequest paymentRequest) {
        List<CardRequest> userCards = cardServiceClient.getCardsForUser(userId);

        for (CardRequest card : userCards) {
            if (card.getBalance() >= paymentRequest.getAmount()) {
                if (productServiceClient.isProductInStock(paymentRequest.getProductId())) {
                    cardServiceClient.deductAmountFromCardBalance(card.getCardNumber(), paymentRequest.getAmount());

                    productServiceClient.updateProductInventory(paymentRequest.getProductId());

                    TransactionRequest transaction = new TransactionRequest();
                    transaction.setUserId(userId);
                    transaction.setDescription("Payment for product ID: " + paymentRequest.getProductId());
                    transaction.setAmount(paymentRequest.getAmount());

                    transactionServiceClient.addTransaction(transaction);

                    return "Payment successful!";
                } else {
                    return "Product out of stock!";
                }
            }
        }
        return "Payment failed. No active card with sufficient balance found.";
    }

    @GetMapping("/{userId}/transactions")
    public List<TransactionRequest> getUserTransactions(@PathVariable String userId) {
        return transactionServiceClient.getTransactionsForUser(userId);
    }

    @GetMapping("all")
    public List<UserDto> getUserList(){
        return userService.getUserList();
    }

}
