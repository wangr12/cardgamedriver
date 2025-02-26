package edu.guilford;

/**
 * This class represents a game of Blackjack.
 * @author Rob Whitnell
 * @version 1.0
 */

public class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;

    // moved reset() method into contructor
    /**
     * Constructor for objects of class Blackjack
     */
    public Blackjack() {
        // reset(true);
        deck = new Deck();
        deck.shuffle();
    }

    // overloaded constructor
    /**
     * Constructor for objects of class Blackjack
     * @param deck the deck to use for the game
     */
    public Blackjack(Deck deck) {
        this.deck = deck;
        deck.shuffle();
    }
    
    /**
     * Get the player's hand
     * @return the player's hand
     */
    public Hand getPlayerHand() {
        return playerHand;
    }

    /**
     * Get the dealer's hand
     * @return the dealer's hand
     */
    public Hand getDealerHand() {
        return dealerHand;
    }

    /**
     * Get the deck
     * @return the deck
     */
    public Deck getDeck() {
        return deck;
    }

/*
    public void reset(boolean newDeck) {
        if (newDeck) {
            deck = new Deck();
            deck.shuffle();
        }
    }
*/
    /**
     * Instantiate a Hand for each the player and the dealer and deal 2 cards to each
     */
    public void deal() {
        playerHand = new Hand();
        dealerHand = new Hand();
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
    }

    /**
     * Player's turn
     * @return true if the player's total is less than or equal to 21, false otherwise
     */
    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.addCard(deck.deal());
        }
        return playerHand.getTotalValue() <= 21;

    }

    /**
     * Dealer's turn
     * @return true if the dealer's total is less than or equal to 21, false otherwise
     */
    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.addCard(deck.deal());
        }
        return dealerHand.getTotalValue() <= 21;
    }

    // Override toString
    /**
     * Returns a string representation of the game
     * @return a string representation of the game
     */
    public String toString() {
        String result = "Player's Hand:\n";
        for (int i = 0; i < playerHand.size(); i++) {
            result += playerHand.getCard(i) + "\n";
        }
        result += "Player's Total: " + playerHand.getTotalValue() + "\n\n";
        result += "Dealer's Hand:\n";
        for (int i = 0; i < dealerHand.size(); i++) {
            result += dealerHand.getCard(i) + "\n";
        }
        result += "Dealer's Total: " + dealerHand.getTotalValue() + "\n\n";
        return result;
    }

}