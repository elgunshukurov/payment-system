package web.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import web.app.dto.request.CardRequest;

import java.util.List;

@FeignClient(name = "card-service", url = "http://localhost:8083")
public interface CardServiceClient {

    @PostMapping("/api/cards/add")
    void addCard(@RequestBody CardRequest card);

    @GetMapping("/api/cards/{userId}")
    List<CardRequest> getCardsForUser(@PathVariable String userId);

    @PutMapping("/api/cards/{cardNumber}/deduct")
    void deductAmountFromCardBalance(@PathVariable String cardNumber, @RequestParam double amount);
}
