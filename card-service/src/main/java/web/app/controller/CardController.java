package web.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import web.app.dto.CardRequest;
import web.app.service.CardService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/add")
    public void addCard(@RequestBody CardRequest card) {
        log.info("Add card request for card number with {}", card.getCardNumber());
        cardService.addCard(card);
    }

    @GetMapping("/{userId}")
    public List<CardRequest> getCardsForUser(@PathVariable Long userId) {
        log.info(" Get card list for user request id with {}", userId);
        return cardService.getCardsForUser(userId);
    }

    @PutMapping("/{cardNumber}/deduct")
    public void deductAmountFromCardBalance(@PathVariable String cardNumber, @RequestParam double amount) {
        log.info("Deduction request from {} number card with amount {}", cardNumber, amount);
        cardService.deductAmountFromCardBalance(cardNumber, amount);
    }

}
