package domain;

import java.util.List;
import java.util.stream.IntStream;

public class HandCards {
    private List<Card> cards;
    private int limit = 13;

    public void addCard(Card card) {
        this.cards.add(card);
        this.cards.sort(null);
    }

    public Card getCard(int index) {
        return this.cards.get(index);
    }

    public boolean isEmpty() {
        return this.cards.size() == 0;
    }

    public List<Integer> getAllCardIndex() {
        return IntStream.range(0, this.cards.size()).boxed().toList();
    }

    public boolean isContainClubThree() {
        return cards.contains(new Card(Rank.Three, Suit.Club));
    }

    public Card removeCard(int index) {
        return this.cards.remove(index);
    }
}
