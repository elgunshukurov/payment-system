package web.app.mapper;

import org.mapstruct.Mapper;
import web.app.domain.Card;
import web.app.dto.CardRequest;

import java.util.List;

//@Mapper
public interface CardMapper {

    Card cardRequestToCard(CardRequest cardRequest);
    CardRequest cardToCardRequest(Card card);

    List<CardRequest> cardListToCardRequestList(List<Card> cardList);

}
