package domain.cardPattern;

import domain.Card;
import domain.Rank;
import domain.player.Player;

import java.util.*;
import java.util.stream.IntStream;

public class FullHouse extends CardPattern {

    public FullHouse(List<Card> cards, Player owner) {
        super(cards, owner);
    }

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5) return false;
        Map<Rank, Integer> map = new HashMap<Rank, Integer>();
        for (Card card : cards) {
            Rank rank = card.getRank();
            Integer count = map.get(rank) | 0;
            map.put(rank, count + 1);
        }
        return IntStream.of(2, 3).allMatch(target -> map.containsValue(target));
    }

    protected Card findMaxCard() {
        Map<Rank, List<Card>> map = new HashMap<Rank, List<Card>>();
        for (Card card : this.cards) {
            Rank rank = card.getRank();
            List<Card> list = map.get(rank);
            list.add(card);
            map.put(rank, list);
        }

        for (List<Card> candidates : map.values()) {
            if (candidates.size() == 3) {
                candidates.sort(Collections.reverseOrder());
                return candidates.get(0);
            }
        }
        return null;
    }
}
