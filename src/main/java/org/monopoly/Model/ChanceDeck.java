package org.monopoly.Model;

import java.util.ArrayList;

/**
 * @author walshj05
 * This class is responsible for creating a deck of chance cards, and retrieving each card's header.
 */
public class ChanceDeck extends CardDeck {
    /**
     * Creates a deck of chance cards
     */
    public ChanceDeck() {
        super(ChanceDeck.initializeCards());
    }

    /**
     * Initializes the chance cards
     * Later on this will be replaced by a more efficient initialization method
     * @return ArrayList of chance cards
     */
    private static ArrayList<String> initializeCards(){
        ArrayList<String> chanceCards = new ArrayList<>();
        chanceCards.add("Advance to Boardwalk.");
        chanceCards.add("Advance to Go (Collect $200).");
        chanceCards.add("Advance to Illinois Avenue. If you pass Go, collect $200.");
        chanceCards.add("Advance to St. Charles Place. If you pass Go, collect $200.");
        chanceCards.add("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled.");
        chanceCards.add("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.");
        chanceCards.add("Bank pays you dividend of $50.");
        chanceCards.add("Get Out of Jail Free.");
        chanceCards.add("Go Back 3 Spaces.");
        chanceCards.add("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200.");
        chanceCards.add("Make general repairs on all your property. For each house pay $25. For each hotel pay $100.");
        chanceCards.add("Speeding fine $15.");
        chanceCards.add("Take a trip to Reading Railroad. If you pass Go, collect $200.");
        chanceCards.add("You have been elected Chairman of the Board. Pay each player $50.");
        chanceCards.add("Your building loan matures. Collect $150");
        return chanceCards;
    }

    /**
     * Draws a card from the top of the deck, and places it in the discard pile
     * @return String header of the card drawn
     */
    @Override
    public String drawCard() {
        if (this.drawPile.isEmpty()){
            this.reshuffleDrawPile();
        }
        String card = this.drawPile.removeLast();
        this.discardPile.add(card);
        return card;
    }


    @Override
    public void executeStrategy(HumanPlayer humanPlayer) {
    }

    // todo add a method for the player to use a chance card
    public void executeStrategy(HumanPlayer humanPlayer, String card) {
    }
}
