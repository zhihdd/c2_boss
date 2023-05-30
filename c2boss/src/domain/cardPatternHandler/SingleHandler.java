package domain.cardPatternHandler;

import domain.Card;
import domain.cardPattern.CardPattern;
import domain.cardPattern.Single;
import domain.player.Player;

import java.util.List;

public class SingleHandler extends CardPatternHandler {

    public SingleHandler(CardPatternHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected CardPattern createCardPattern(List<Card> targetCards, Player owner) {
        return new Single(targetCards, owner);
    }

    @Override
    protected boolean isValidCardPatternOfCandidateCards(List<Card> targetCards) {
        return false;
    }

    @Override
    protected boolean isBiggerThanTopPlay(Request request) {
        return new Single(request.getTargetCards(), request.player).isBiggerThan(request.topPlay);
    }

    @Override
    protected boolean matchCardPattern(Request request) {
        return request.topPlay instanceof Single;
    }


}
