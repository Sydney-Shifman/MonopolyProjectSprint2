package org.monopoly.Model;

import java.util.ArrayList;

/**
 * @author walshj05
 * This class is responsible for creating a deck of Community Chest cards
 * and has methods for drawing a card from the deck.
 */
public class CommunityChestDeck extends CardDeck {
    /**
     * Creates a deck of Community Chest cards
     * Shuffles the draw deck
     */
    public CommunityChestDeck() {
        super(CommunityChestDeck.initializeCards());
    }

    /**
     * Initializes the Community Chest deck with the cards
     * @return ArrayList of Community Chest cards
     */
    private static ArrayList<String> initializeCards(){
        ArrayList<String> communityChestCards = new ArrayList<>();
        communityChestCards.add("Advance to Go (Collect $200)");
        communityChestCards.add("Bank error in your favor. Collect $200");
        communityChestCards.add("Doctor’s fee. Pay $50");
        communityChestCards.add("From sale of stock you get $50");
        communityChestCards.add("Get Out of Jail Free");
        communityChestCards.add("Go to Jail. Go directly to jail, do not pass Go, do not collect $200");
        communityChestCards.add("Holiday fund matures. Receive $100");
        communityChestCards.add("Income tax refund. Collect $20");
        communityChestCards.add("It is your birthday. Collect $10 from every player");
        communityChestCards.add("Life insurance matures. Collect $100");
        communityChestCards.add("Pay hospital fees of $100");
        communityChestCards.add("Pay school fees of $50");
        communityChestCards.add("Receive $25 consultancy fee");
        communityChestCards.add("You are assessed for street repair. $40 per house. $115 per hotel");
        communityChestCards.add("You have won second prize in a beauty contest. Collect $10");
        communityChestCards.add("You inherit $100");
        return communityChestCards;
    }

    /**
     * Draws a card from the top of the deck
     * - If the draw pile is empty, reshuffles the discard pile into the draw pile
     * - If both piles are empty, returns a message that there are no cards left
     * @return String of the card drawn
     */
    @Override
    public String drawCard() {
        if (drawPile.isEmpty() && discardPile.isEmpty()) {
            return "No cards left in deck";
        } else if (drawPile.isEmpty()) {
            reshuffleDrawPile();
        }
        String card = drawPile.removeLast();
        unavailableCards.add(card);
        return card;
    }

    /**
     * Returns the discard pile to the discard pile
     */
    public void returnCardToDeck(String card) {
        if (unavailableCards.contains(card)) {
            unavailableCards.remove(card);
            discardPile.add(card);
        }
    }
}
