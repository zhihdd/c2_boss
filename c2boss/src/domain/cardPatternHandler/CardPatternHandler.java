package domain.cardPatternHandler;

import domain.Card;
import domain.cardPattern.CardPattern;
import domain.player.Player;

import java.util.List;

public abstract class CardPatternHandler {
    protected CardPatternHandler nextHandler = null;

    protected CardPatternHandler(CardPatternHandler nextHandler) {
        this.nextHandler = nextHandler;
    }


    public boolean validate(Request request) {
        if (this.matchValidating(request)) {
            return this.doValidation(request);
        } else if (this.nextHandler != null) {
            return this.nextHandler.validate(request);
        }
        return false;
    }

    private boolean matchValidating(Request request) {
        return request.topPlay == null || this.matchCardPattern(request);
    }

    public CardPattern create(Request request) {
        if (this.matchCreating(request)) {
            return doCreate(request);
        } else if (this.nextHandler != null) {
            return this.nextHandler.create(request);
        }
        return null;
    }

    private CardPattern doCreate(Request request) {
        List<Card> targetCards = request.extractTargetCards();
        return this.createCardPattern(targetCards, request.player);
    }

    private boolean matchCreating(Request request) {
        return this.matchCardPattern(request);
    }

    protected abstract CardPattern createCardPattern(List<Card> targetCards, Player owner);

    private boolean doValidation(Request request) {
        List<Card> targetCards = request.getTargetCards();
        if (isValidCardPatternOfCandidateCards(targetCards)) {
            if (request.topPlay == null || this.isBiggerThanTopPlay(request)) {
                return true;
            }
        }

        return false;
    }

    protected abstract boolean isValidCardPatternOfCandidateCards(List<Card> targetCards);

    protected abstract boolean isBiggerThanTopPlay(Request request);

    protected abstract boolean matchCardPattern(Request request);


    public static class Request {
        public CardPattern topPlay;
        public List<Integer> targetIndexes;
        public Player player;

        public Request(CardPattern topPlay, List<Integer> targetIndexes, Player player) {
            this.topPlay = topPlay;
            this.targetIndexes = targetIndexes;
            this.player = player;
        }


        public Player getPlayer() {
            return player;
        }

        public List<Card> getTargetCards() {
            return this.player.getCards(targetIndexes);
        }

        public List<Card> extractTargetCards() {
            return this.player.extractCards(targetIndexes);
        }
    }
}
