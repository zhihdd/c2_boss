import domain.*;
import domain.cardPatternHandler.*;
import domain.player.AIPlayer;
import domain.player.HumanPlayer;
import domain.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    private String test;

    public static void main(String[] args) {
        CardPatternHandler handler = new SingleHandler(new PairHandler(new StraightHandler(new FullHouseHandler(null))));
        List<Card> cards = createCards();
        Deck deck = new Deck(cards);
        List<Player> players = createPlayers();
        Big2 big2 = new Big2(deck, players, handler);
        big2.start();
    }

    private static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(0, new HandCards()));
        IntStream.range(1, 3).forEach(i -> players.add(new AIPlayer(i, new HandCards())));
        return players;
    }

    private static List<Card> createCards() {
        List<Card> cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {

            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        return cards;
    }

}