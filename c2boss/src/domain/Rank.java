package domain;

public enum Rank {
    Three("3", 3),
    Four("4", 4),
    Five("5", 5),
    Six("6", 6),
    Seven("7", 7),
    Eight("8", 8),
    Nine("9", 9),
    Ten("10", 10),
    Jack("J", 11),
    Queen("Q", 12),
    King("K", 13),
    Ace("A", 14),
    Two("2", 15);

    private String symbol;
    private int weight;

    Rank(String symbol, int weight) {
        this.symbol = symbol;
        this.weight = weight;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isSame(Rank target) {
        return this.getWeight() == target.getWeight();
    }
    public int diff(Rank target) {
        return this.getWeight() - target.getWeight();
    }
}
