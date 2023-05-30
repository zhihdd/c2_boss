package domain.cardPattern;

import domain.Card;
import domain.player.Player;

import java.util.List;

public class Single extends CardPattern {

    public Single(List<Card> cards, Player owner) {
        super(cards, owner);
    }



    public static boolean isValid(List<Card> cards) {
        return cards.size() == 1;
    }

    public Card findMaxCard() {
        return this.cards.get(0);
    }

}

