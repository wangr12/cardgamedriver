package edu.guilford;

/**
 * This class represents a playing card.
 * @author Rob Whitnell
 * @version 1.0
 */

import java.util.Random;

public class Card implements Comparable<Card>{
    // enum for the suits
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    // enum for the ranks
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN,
        KING
    }

    // instance variables
    private Suit suit;
    private Rank rank;

    // constructor
    /**
     * Constructor for objects of class Card
     * @param suit the suit of the card
     * @param rank the rank of the card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Constructor for objects of class Card; generates a random card
     */
    public Card() {
        // random Card
        Random rand = new Random();
        int suit = rand.nextInt(Suit.values().length);
        int rank = rand.nextInt(Rank.values().length);
        this.suit = Suit.values()[suit];
        this.rank = Rank.values()[rank];
    }

    // getters
    /**
     * Get the suit of the card
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Get the rank of the card
     * @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    // toString
    /**
     * Get a string representation of the card
     * @return a string representation of the card
     */
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    /**
     * Compare this card to another card
     * @param otherCard the other card to compare to
     * @return 1 if this card is greater, -1 if this card is less, 0 if they are equal
     */
    public int compareTo(Card otherCard) {
        // TODO Auto-generated method stub
        if (this.rank.ordinal() > otherCard.rank.ordinal()) {
            return 1;
        }
        else if (this.rank.ordinal() < otherCard.rank.ordinal()) {
            return -1;
        }
        else {
            if (this.suit.ordinal() > otherCard.suit.ordinal()) {
                return 1;
            }
            else if (this.suit.ordinal() < otherCard.suit.ordinal()) {
                return -1;
            }
        }

        return 0;
    }

    
}
