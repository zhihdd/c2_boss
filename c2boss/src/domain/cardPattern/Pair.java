package domain.cardPattern;

import domain.Card;
import domain.Rank;
import domain.player.Player;

import java.util.List;

public class Pair extends CardPattern {
    protected int count = 2;

    public Pair(List<Card> cards, Player owner) {
        super(cards, owner);
    }


    public static boolean isValid(List<Card> cards) {
        Rank rankOfFirstCard = cards.get(0).getRank();
        Rank rankOfSecondCard = cards.get(1).getRank();
        return cards.size() == 2 && rankOfFirstCard.isSame(rankOfSecondCard);
    }

    public Card findMaxCard() {
        this.cards.sort(null);
        return this.cards.get(1);
    }
}
