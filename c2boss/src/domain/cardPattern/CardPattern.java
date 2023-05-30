package domain.cardPattern;

import domain.Card;
import domain.player.Player;

import java.util.List;

public abstract class CardPattern {
    protected int count;
    protected List<Card> cards;
    private Player owner;

    public CardPattern(List<Card> cards, Player owner) {
        this.cards = cards;
        this.owner = owner;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isBiggerThan(CardPattern target) {
        return this.findMaxCard().compareTo(target.findMaxCard()) > 0;
    }

    protected abstract Card findMaxCard();


    public int getCount() {
        return 0;
    }

}

