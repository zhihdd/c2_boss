package domain.cardPattern;

import domain.Card;
import domain.Rank;
import domain.player.Player;

import java.util.List;

public class Straight extends CardPattern {

    public Straight(List<Card> cards, Player owner) {
        super(cards, owner);
    }

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5) return false;
        cards.sort(null);

        for (int i = 1; i < cards.size(); i++) {
            Rank rankOfPreviousCard = cards.get(i - 1).getRank();
            Rank rankOfCurrentCard = cards.get(i).getRank();
            if (rankOfCurrentCard.diff(rankOfPreviousCard) != 1) return false;
        }

        return true;
    }

    @Override
    protected Card findMaxCard() {
        Card maxCard = this.cards.get(0);
        for (Card card : this.cards) {
            maxCard = card.compareTo(maxCard) > 0 ? maxCard : card;
        }
        return maxCard;
    }

}
