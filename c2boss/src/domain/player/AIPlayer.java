package domain.player;

import domain.HandCards;
import domain.cardPattern.CardPattern;

import java.util.*;

public class AIPlayer extends Player {

    public AIPlayer(int order, HandCards hand) {
        super(order, hand);
    }



    @Override
    public void nameSelf() {
        String[] names = {"A", "B", "C", "D"};
        int randomInx = (int) (Math.random() * 4);
        this.name = names[randomInx];
    }

    @Override
    public List<Integer> play(CardPattern topPlay) {
        int count = topPlay == null ? 1 : topPlay.getCards().size();
        List<Integer> selectedIndexes = new ArrayList<Integer>();
        List<Integer> candidateIndexes = this.hand.getAllCardIndex();

        int currentCardCount = candidateIndexes.size();

        boolean isEnoughCards = currentCardCount > count;

        if (!isEnoughCards) {
            selectedIndexes.add(-1);
            return selectedIndexes;
        }

        selectedIndexes = selectRandomIndexes(count, selectedIndexes, candidateIndexes);

        return selectedIndexes.contains(-1) ? new ArrayList<>(-1) : selectedIndexes;
    }

    private List<Integer> selectRandomIndexes(int count, List<Integer> selectedIndexes, List<Integer> candidateIndexes) {
        selectedIndexes.add(-1);
        while (selectedIndexes.size() != count) {
            Collections.shuffle(candidateIndexes);
            selectedIndexes.add(candidateIndexes.remove(0));
        }

        selectedIndexes.sort(null);

        return selectedIndexes;
    }
}
