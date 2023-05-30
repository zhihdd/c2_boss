package domain.cardPatternHandler;

import domain.Card;
import domain.cardPattern.CardPattern;
import domain.cardPattern.FullHouse;
import domain.player.Player;

import java.util.List;

public class FullHouseHandler extends CardPatternHandler {
    public FullHouseHandler(CardPatternHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected CardPattern createCardPattern(List<Card> targetCards, Player owner) {
        return new FullHouse(targetCards, owner);
    }

    @Override
    protected boolean isValidCardPatternOfCandidateCards(List<Card> targetCards) {
        return FullHouse.isValid(targetCards);
    }

    @Override
    protected boolean isBiggerThanTopPlay(Request request) {
        return new FullHouse(request.getTargetCards(), request.player).isBiggerThan(request.topPlay);
    }


    @Override
    protected boolean matchCardPattern(Request request) {
        return request.topPlay instanceof FullHouse;
    }

}
