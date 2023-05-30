package domain.player;

import domain.Card;
import domain.HandCards;
import domain.cardPattern.CardPattern;
import domain.cardPatternHandler.CardPatternHandler;

import java.util.List;

public abstract class Player {
    protected int order;
    protected String name;
    protected HandCards hand;


    public Player(int order, HandCards hand) {
        this.order = order;
        this.hand = hand;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public void deal(Card card) {

        hand.addCard(card);

    }


    public abstract void nameSelf();

    public abstract List<Integer> play(CardPattern topPlay);

    public List<Card> getCards(List<Integer> selectedCardsIndex) {
        return selectedCardsIndex.stream().map(index -> this.hand.getCard(index)).toList();
    }

    public List<Card> extractCards(List<Integer> selectedCardsIndex) {
        return selectedCardsIndex.stream().map(index -> this.hand.removeCard(index)).toList();
    }

    public boolean isHandEmpty() {
        return this.hand.isEmpty();
    }

    public HandCards getHand() {
        return hand;
    }
}
