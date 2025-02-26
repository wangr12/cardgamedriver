package edu.guilford;

/**
 * The driver runs NGAMES of Blackjack, outputting how many dealer wins, player wins, and pushes there are.
 * Then, it runs a game of Lamarckian Poker, outputting the initial and final hands.
 * @author Rob Whitnell
 * @version 1.0
 */

public class CardGameDriver {
    public static void main(String[] args) {
        final int NGAMES = 10000;
        int dealerWins = 0;
        int playerWins = 0;
        Blackjack game = new Blackjack();
        game.deal();
        // System.out.println(game);
        int iGame = 0;
        while (iGame < NGAMES) {
            game.deal();
            if (game.getPlayerHand().getTotalValue() == 21) {
                playerWins++;
            } else if (game.getDealerHand().getTotalValue() == 21) {
                dealerWins++;
            } else {
                boolean playerResult = game.playerTurn();
                boolean dealerResult = game.dealerTurn();
                if (!playerResult) {
                    dealerWins++;
                } else if (!dealerResult) {
                    playerWins++;
                } else if (game.getPlayerHand().getTotalValue() < game.getDealerHand().getTotalValue()) {
                    dealerWins++;
                } else if (game.getPlayerHand().getTotalValue() > game.getDealerHand().getTotalValue()) {
                    playerWins++;
                }
            }
            if (game.getDeck().getDeck().size() < 10) {
                // game.reset(true);
                game = new Blackjack();
            }

            iGame++;
        }
        System.out.println("Dealer wins: " + dealerWins);
        System.out.println("Player wins: " + playerWins);
        System.out.println("Pushes: " + (NGAMES - dealerWins - playerWins));

        LamarckianPoker lmpGame = new LamarckianPoker();
        lmpGame.deal();
        System.out.println("\nInitial Lamarckian hands\n" + lmpGame);

        boolean gameDone = false;
        while (!gameDone) {
        //    System.out.println(lmpGame);
            gameDone = !lmpGame.turn();
        }
  
        System.out.println("Final Lamarckian hands\n" + lmpGame);   

    }
}