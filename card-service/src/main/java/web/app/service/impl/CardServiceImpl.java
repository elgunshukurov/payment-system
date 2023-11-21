package web.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.app.domain.Card;
import web.app.dto.CardRequest;
import web.app.exception.ResourceAlreadyExistsException;
import web.app.mapper.CardMapper;
import web.app.repository.CardRepository;
import web.app.service.CardService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final EncryptionServiceImpl encryptionService;
    @Override
    public void addCard(CardRequest cardRequest){
        cardRepository.findByCardNumber(cardRequest.getCardNumber())
                .ifPresent(user -> {
                    throw new ResourceAlreadyExistsException(cardRequest.getCardNumber());
                });

        cardRepository.save(cardMapper.cardRequestToCard(cardRequest));
    }

    @Override
    public List<CardRequest> getCardsForUser(Long userId) {
        List<Card> cardList = cardRepository.findByUserId(userId);
        return cardMapper.cardListToCardRequestList(cardList);
    }

    @Override
    public void deductAmountFromCardBalance(String cardNumber, double amount) {
        String encrypted = encryptionService.encrypt(cardNumber);
        cardRepository.findByCardNumber(encrypted)
                .ifPresent(card -> {
                    double updatedBalance = card.getBalance() - amount;
                    card.setBalance(updatedBalance);
                    cardRepository.save(card);
                    log.info("Amount {} deducted from card {} successfully. Updated balance: {}", amount, cardNumber, updatedBalance);
                });
    }
}
