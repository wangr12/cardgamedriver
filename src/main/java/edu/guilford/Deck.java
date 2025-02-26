package edu.guilford;

/**
 * This class represents a deck of playing cards.
 * @author Rob Whitnell
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private Random rand = new Random();

// moved build() method into constructor
    /**
     * Constructor for objects of class Deck; generates a standard deck of cards
     */
    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    // overloaded constructor
    /**
     * Constructor for objects of class Deck using a given deck
     * @param deck the deck to copy
     */
    public Deck(Deck deck) {
        this.deck = deck.getDeck();
    }

    /**
     * Get the deck
     * @return the deck as an ArrayList
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Clear the deck
     */
    public void clear() {
        deck.clear();
    }

/*
    public void build() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }
*/

    /**
     * Shuffle the deck
     */
    public void shuffle() {
        // replaced with Collections.shuffle() for simplicity
        Collections.shuffle(deck);
        /*
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        while (deck.size() > 0) {
            int loc = rand.nextInt(deck.size());
            tempDeck.add(deck.get(loc));
            deck.remove(loc);
        }
        deck = tempDeck;
        */
    }

    /*
    // method is never used
    public Card pick(int i) {
        Card picked = deck.remove(i);
        return picked;
    }
    */

    /**
     * Deal a card from the deck
     * @return the dealt card
     */
    public Card deal() {
        return deck.remove(0);
    }

    // deleted method to reduce redundancy
    /*
    public int size() {
        return deck.size();
    }
    */

    /**
     * Get a string representation of the deck
     * @return a string representation of the deck
     */
    public String toString() {
        String deckString = "";
        for (Card card : deck) {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }
}