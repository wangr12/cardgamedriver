package edu.guilford;

/**
 * This class represents a hand of playing cards.
 * @author Rob Whitnell
 * @version 1.0
 */

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    
    /**
     * Constructor for objects of class Hand
     * Creates a new hand
     */
    public Hand() {
        hand = new ArrayList<Card>();
    }

    /**
     * Add a given card to the hand
     * @param card
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Remove a given card from the hand
     * @param card
     */
    public void removeCard(Card card) {
        hand.remove(card);
    }

    /**
     * Remove all cards from the hand
     */
    public void reset() {
        hand.clear();
    }

    /**
     * Get the size of the hand
     * @return the number of cards in the hand
     */
    public int size() {
        return hand.size();
    }

    /**
     * Get the card at a given index
     * @param index
     * @return the card at the given index
     */
    public Card getCard(int index) {
        return hand.get(index);
    }

    // Calculate the value of the hand
    /**
     * Get the total value of the hand
     * @return the sum of the values of the cards in the hand
     */
    public int getTotalValue() {
        int value = 0;
        int aces = 0;
        for (Card card : hand) {
            switch (card.getRank()) {
                case TWO:
                    value += 2;
                    break;
                case THREE:
                    value += 3;
                    break;
                case FOUR:
                    value += 4;
                    break;
                case FIVE:
                    value += 5;
                    break;
                case SIX:
                    value += 6;
                    break;
                case SEVEN:
                    value += 7;
                    break;
                case EIGHT:
                    value += 8;
                    break;
                case NINE:
                    value += 9;
                    break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    value += 10;
                    break;
                case ACE:
                    aces++;
                    break;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (value + 11 <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }
        return value;
    }

    // Override toString method
    /**
     * Get a string representation of the hand
     * @return a string representation of the hand
     */
    @Override
    public String toString() {
        String handString = "";
        for (Card card : hand) {
            handString += card.toString() + "\n";
        }
        return handString;
    }

    /**
     * Get the hand
     * @return the hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

}