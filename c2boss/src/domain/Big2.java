package domain;

import domain.cardPattern.CardPattern;
import domain.cardPatternHandler.CardPatternHandler;
import domain.player.Player;

import java.util.List;

public class Big2 {
    private Deck deck;
    private List<Player> players;
    private CardPattern topPlay;
    private Player winner;
    private CardPatternHandler cardPatternHandler;

    public Big2(Deck deck, List<Player> players, CardPatternHandler cardPatternHandler) {
        this.deck = deck;
        this.players = players;
        this.cardPatternHandler = cardPatternHandler;
    }


    public void start() {
        this.makePlayersNameSelf();
        this.makePlayerDealCard();
        int roundCount = 1;
        int currentRoundrPlayerIndex = this.findFirstPlayerIndex();

        while (true) {
            Round round = new Round(roundCount);
            round.play(currentRoundrPlayerIndex);
            this.winner = this.checkGameEnd();
            if (this.isGameEnd()) {
                break;
            }

            currentRoundrPlayerIndex = this.topPlay.getOwner().getOrder();
            this.topPlay = null;
            roundCount++;
        }
        this.disPlayWinner();
    }

    private int findFirstPlayerIndex() {
        for (Player player : players) {
            if (player.getHand().isContainClubThree()) {
                return player.getOrder();
            }
        }
        return -1;
    }

    private void disPlayWinner() {
        System.out.println("Winner is " + this.winner.getName());
    }

    private Player checkGameEnd() {
        for (Player player : players) {
            if (player.isHandEmpty()) {
                this.winner = player;
                return player;
            }
        }
        return null;
    }

    private void makePlayerDealCard() {
        this.deck.shuffle();
        while (!this.deck.isEmpty()) {
            players.forEach(player -> player.deal(deck.draw()));
        }
    }

    private void makePlayersNameSelf() {
        players.forEach(Player::nameSelf);
    }

    private boolean isGameEnd() {
        return this.winner != null;
    }

    private class Round {

        private int roundCount;


        public Round(int roundCount) {
            this.roundCount = roundCount;
        }

        public void play(int currentRoundPlayerIndex) {
            int countOfPass = 0;
            int order = currentRoundPlayerIndex / players.size();
            while (true) {
                Player player = players.get(order);
                List<Integer> selectedCardsIndex;
                while (true) {
                    selectedCardsIndex = player.play(topPlay);
                    if (roundCount == 0) {
                        if (!this.isPassFirstRoundRule(player, selectedCardsIndex)) {
                            continue;
                        }
                    }

                    if (this.isCallPass(selectedCardsIndex)) {
                        ++countOfPass;
                        break;
                    }

                    if (cardPatternHandler.validate(new CardPatternHandler.Request(topPlay, selectedCardsIndex, player))) {
                        countOfPass = 0;
                        topPlay = cardPatternHandler.create(new CardPatternHandler.Request(topPlay, selectedCardsIndex, player));
                        break;
                    }
                }

                order++;

                if (this.isRoundEnd(countOfPass, players)) {
                    break;
                }
            }
        }

        private boolean isPassFirstRoundRule(Player player, List<Integer> selectedCardsIndex) {
            List<Card> cards = player.getCards(selectedCardsIndex);
            return cards.contains(new Card(Rank.Three, Suit.Club)) && !selectedCardsIndex.contains(-1);
        }

        private boolean isRoundEnd(int countOfPass, List<Player> players) {
            return countOfPass == 3 || players.stream().anyMatch(Player::isHandEmpty);
        }

        private boolean isCallPass(List<Integer> selectedCardsIndex) {
            return selectedCardsIndex.stream().anyMatch(index -> index == -1);
        }

    }
}
