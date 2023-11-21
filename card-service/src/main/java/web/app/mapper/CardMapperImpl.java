package web.app.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import web.app.domain.Card;
import web.app.dto.CardRequest;
import web.app.service.EncryptionService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardMapperImpl implements CardMapper{
    private final EncryptionService encryptionService;
    @Override
    public Card cardRequestToCard(CardRequest cardRequest) {
        String encryptedCardNumber = encryptionService.encrypt(cardRequest.getCardNumber());
        String encryptedCVV = encryptionService.encrypt(String.valueOf(cardRequest.getCvv()));

        Card card = new Card();
        card.setExpirationDate(cardRequest.getExpirationDate());
        card.setCardNumber(encryptedCardNumber);
        card.setEncryptedCVV(encryptedCVV);
        card.setBalance(cardRequest.getBalance());
        card.setUserId(cardRequest.getUserId());

        return card;
    }

    @Override
    public CardRequest cardToCardRequest(Card card) {
        String decryptedCardNumber = encryptionService.decrypt(card.getCardNumber());
        String decrypt = encryptionService.decrypt(card.getEncryptedCVV());

        CardRequest cardRequest = new CardRequest();

        cardRequest.setExpirationDate(card.getExpirationDate());
        cardRequest.setCardNumber(decryptedCardNumber);
        cardRequest.setCvv(Integer.parseInt(decrypt));
        cardRequest.setBalance(card.getBalance());
        cardRequest.setUserId(card.getUserId());

        return cardRequest;
    }

    @Override
    public List<CardRequest> cardListToCardRequestList(List<Card> cardList) {
        return cardList.stream().map(this::cardToCardRequest).collect(Collectors.toList());
    }
}
