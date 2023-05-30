package domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck {
    private List<Card> cards;


    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Card draw() {
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.size() == 0;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}
