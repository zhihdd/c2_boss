package domain;

public enum Suit {
    Spade("S", 400),
    Heart("H", 300),
    Diamond("D", 200),
    Club("C", 100);

    private String symbol;
    private int weight;

    Suit(String symbol, int weight) {
        this.symbol = symbol;
        this.weight = weight;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getWeight() {
        return weight;
    }
}
