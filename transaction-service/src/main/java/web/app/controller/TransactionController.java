package web.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.app.dto.TransactionRequest;
import web.app.mapper.TransactionMapper;
import web.app.service.TransactionService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public String test(){
        return "Test method";
    }

    @PostMapping("/add")
    public ResponseEntity<TransactionRequest> addTransaction(@RequestBody TransactionRequest transaction) {
        TransactionRequest addedTransaction = transactionService.addTransaction(transaction);
        return ResponseEntity.ok(addedTransaction);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TransactionRequest>> getTransactionsForUser(@PathVariable String userId) {
        List<TransactionRequest> transactionHistory = transactionService.viewTransactionHistory(userId);
        return ResponseEntity.ok(transactionHistory);
    }

}
