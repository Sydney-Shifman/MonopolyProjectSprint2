package org.monopoly.Model;

/**
 * Represents the Community Chest Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class CommunityChestSpace extends GameTile {

    /**
     * Constructor to initialize a CommunityChestSpace.
     *
     * Developed by: shifmans
     */
    public CommunityChestSpace() {
        super("Community Chest Space", "");
    }

    /**
     * Shows the actions that occur after a player lands on element space.
     * @return Displays the actions for landing on element space.
     *
     * Developed by: shifmans
     */
    @Override
    public String landOn() {
        actions += drawCard();
        return actions;
    }

    /**
     * Player draws a card from Chance Card Deck after landing on element space.
     * @return Instructions for drawing a card.
     *
     * Developed by: shifmans
     */
    private String drawCard() {
        return "Draw a card from the deck";
    }
}
