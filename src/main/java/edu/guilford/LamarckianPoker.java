package edu.guilford;

/**
 * This class represents a game of Lamarckian Poker.
 * @author Rob Whitnell
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class LamarckianPoker {
    private Hand player1Hand;
    private Hand player2Hand;
    private Hand pool;
    // private Deck discard;
    // changed discard to a Hand type
    private Hand discard;
    private Deck deck;
    private Random rand = new Random();
    private int iTurn;

    /**
     * Constructor for objects of class LamarckianPoker
     */
    public LamarckianPoker() {
        reset(true);
    }

    /**
     * Get the player 1 hand
     * @return the player 1 hand
     */
    public Hand getPlayer1Hand() {
        return player1Hand;
    }

    /**
     * Get the player 2 hand
     * @return the player 2 hand
     */
    public Hand getPlayer2Hand() {
        return player2Hand;
    }

    /**
     * Get the pool
     * @return pool
     */
    public Hand getPool() {
        return pool;
    }

    /**
     * Reset the game, using a new deck and discard pile
     */
    public void reset(boolean newDeck) {
        if (newDeck) {
            deck = new Deck();
            discard = new Hand();
            discard.reset();
            deck.shuffle();
        }
        iTurn = 0;
    }

    /**
     * Create new Hand objects for both players and deal 4 cards to each player
     */
    public void deal() {
        player1Hand = new Hand();
        player2Hand = new Hand();
        for (int iCard = 0; iCard < 4; iCard++) {
            player1Hand.addCard(deck.deal());
            player2Hand.addCard(deck.deal());
        }
    }

    /**
     * Make the pool by dealing 4 cards from the deck
     */
    public void makePool() {
        pool = new Hand();
        for (int iCard = 0; iCard < 4; iCard++) {
            pool.addCard(deck.deal());
        }
        // System.out.println("Deck size: " + deck.size());
    }

    /**
     * Play a turn of Lamarckian Poker
     * @return true if the game is not over, false if the game is over
     */
    public boolean turn() {
        // modify conditional statement to check if player hands are not empty
        if ((player1Hand.size() < 7 || player2Hand.size() < 7) && (player1Hand.size() > 0 && player2Hand.size() > 0)) {
            makePool();
            // System.out.println("Turn " + iTurn + "\n" + pool);
            /*
            Card player1Card = player1Hand.getCard(rand.nextInt(player1Hand.size()));
            Card player2Card = player2Hand.getCard(rand.nextInt(player2Hand.size()));
            */

            // find best card for each player isntead of choosing a random card.
            Card player1Card = findBestCard(player1Hand, pool);
            Card player2Card = findBestCard(player2Hand, pool);

            Hand firstHand, secondHand;
            Card firstCard, secondCard;

            /*
            if (player1Card.getRank().ordinal() > player2Card.getRank().ordinal()) {
                firstHand = player1Hand;
                secondHand = player2Hand;
                firstCard = player1Card;
                secondCard = player2Card;
            } else if (player1Card.getRank().ordinal() < player2Card.getRank().ordinal()) {
                firstHand = player2Hand;
                secondHand = player1Hand;
                firstCard = player2Card;
                secondCard = player1Card;
            } else {
                if (player1Card.getSuit().ordinal() > player2Card.getSuit().ordinal()) {
                    firstHand = player1Hand;
                    secondHand = player2Hand;
                    firstCard = player1Card;
                    secondCard = player2Card;
                } else {
                    firstHand = player2Hand;
                    secondHand = player1Hand;
                    firstCard = player2Card;
                    secondCard = player1Card;
                }

            }
                */
            
            // use compareTo method instead of comparing ordinals
            if (player1Card.compareTo(player2Card) == 1) {
                firstHand = player1Hand;
                secondHand = player2Hand;
                firstCard = player1Card;
                secondCard = player2Card;
            }
            else {
                firstHand = player2Hand;
                secondHand = player1Hand;
                firstCard = player2Card;
                secondCard = player1Card;
            }
     
            /*
            ArrayList<Card> poolRemove = new ArrayList<Card>();

            for (Card poolCard : pool.getHand()) {
                if (firstCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        firstCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    firstHand.addCard(poolCard);
                    poolRemove.add(poolCard);
                }
            }
            // Remove cards from pool
            for (Card poolCard : poolRemove) {
                pool.removeCard(poolCard);
            }
            poolRemove.clear();
            // pool.addCard(firstCard);
            discard.addCard(firstCard);
            firstHand.removeCard(firstCard);
            for (Card poolCard : pool.getHand()) {
                if (secondCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        secondCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    secondHand.addCard(poolCard);
                    poolRemove.add(poolCard);
                }
            }
            for (Card poolCard : poolRemove) {
                pool.removeCard(poolCard);
            }
            // pool.addCard(secondCard);
            discard.addCard(secondCard);
            secondHand.removeCard(secondCard);
            */

            playerTurn(firstHand, firstCard, pool);
            playerTurn(secondHand, secondCard, pool);

            for (Card poolCard : pool.getHand()) {
                // discard.getDeck().add(poolCard);
                discard.addCard(poolCard);
            }
            pool.getHand().clear();
            // System.out.println("Discard\n" + discard.size());
            if (deck.getDeck().size() < 4) {
                // for (Card card : discard.getDeck()) {
                for (Card card : discard.getHand()) {
                    deck.getDeck().add(card);
                }
                //discard.clear();
                discard.reset();
                // System.out.println("Discard\n" + discard.size());
            }
            iTurn++;
            
            return true;
        } else {
            return false;
        }

    }

    // created playerTurn method to reduce redundancy
    /**
     * Execute a single player's turn
     * Given the sacrificed card, collect cards from the pool and add to player's hand
     * @param hand 
     * @param card
     * @param pool
     */
    private void playerTurn(Hand hand, Card card, Hand pool) {
        ArrayList<Card> poolRemove = new ArrayList<>();
        for (Card poolCard : pool.getHand()) {
            if (card.getRank().ordinal() == poolCard.getRank().ordinal() ||
                    card.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                hand.addCard(poolCard);
                poolRemove.add(poolCard);
            }
        }
        for (Card poolCard : poolRemove) {
            pool.removeCard(poolCard);
        }
        poolRemove.clear();
        // pool.addCard(card);
        // add sacrificial card to discard pile instead of pool
        discard.addCard(card);
        hand.removeCard(card);
    }

    /**
     * Given a hand and the pool, find the card that will return the player the most number of matching cards
     * @param hand
     * @param pool
     * @return the best card to play
     */
    private Card findBestCard(Hand hand, Hand pool) {
        Card bestCard = null;
        int maxMatches = -1;

        for (Card card : hand.getHand()) {
            int matches = 0;
            for (Card poolCard : pool.getHand()) {
                if (card.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        card.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    matches++;
                }
            }
            if (matches > maxMatches) {
                maxMatches = matches;
                bestCard = card;
            }
        }

        return bestCard;
    }
 

    /**
     * Get a string representation of the player hands and the pool
     * @return a string representation of the player hands and the pool
     */
    @Override
    public String toString() {
        return "\nPlayer 1: \n" + player1Hand + "\nPlayer 2: \n" + player2Hand + "\nPool: " + pool + "\n";
    }
}