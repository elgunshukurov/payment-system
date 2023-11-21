package web.app.service;

import web.app.dto.CardRequest;

import java.util.List;

public interface CardService {
    void addCard(CardRequest card);

    List<CardRequest> getCardsForUser(Long userId);

    void deductAmountFromCardBalance(String cardNumber, double amount);
}
