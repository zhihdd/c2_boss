package domain;

public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card target) {
        return (this.rank.getWeight() + this.suit.getWeight()) - (target.rank.getWeight() + target.suit.getWeight());
    }
}
