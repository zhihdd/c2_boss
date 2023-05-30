package domain.player;

import domain.Card;
import domain.HandCards;
import domain.cardPattern.CardPattern;
import domain.cardPatternHandler.CardPatternHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(int order, HandCards hand) {
        super(order, hand);
    }

    @Override
    public void nameSelf() {
        final Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
    }

    @Override
    public List<Integer> play(CardPattern topPlayer) {
        Scanner scanner = new Scanner(System.in);
        String[] selectedCardIndexString = scanner.nextLine().split(",");
        return Arrays.stream(selectedCardIndexString).map(Integer::parseInt).toList();
    }
}
