package domain.cardPatternHandler;

import domain.Card;
import domain.cardPattern.CardPattern;
import domain.cardPattern.Pair;
import domain.player.Player;

import java.util.List;

public class PairHandler extends CardPatternHandler {

    public PairHandler(CardPatternHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean isValidCardPatternOfCandidateCards(List<Card> targetCards) {
        return Pair.isValid(targetCards);
    }

    @Override
    protected CardPattern createCardPattern(List<Card> targetCards, Player owner) {
        return new Pair(targetCards, owner);
    }

    @Override
    protected boolean isBiggerThanTopPlay(Request request) {
        return new Pair(request.getTargetCards(), request.player).isBiggerThan(request.topPlay);
    }


    @Override
    protected boolean matchCardPattern(Request request) {
        return request.topPlay instanceof Pair;
    }
}
