package org.monopoly.Model.GameTiles;

/**
 * Represents the Go Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class GoSpace extends GameTile {

    /**
     * Constructor to initialize a GoSpace.
     *
     * Developed by: shifmans
     */
    public GoSpace() {
        super("Go Space", "");
    }

    /**
     * Shows the actions that occur after a player lands on element space.
     * @return Displays the actions for landing on element space.
     *
     * Developed by: shifmans
     */
    @Override
    public String landOn() {
        actions += collectMoney();
        return actions;
    }

    /**
     * Player collects $200 after landing on element space.
     * @return Instructions for collecting money.
     *
     * Developed by: shifmans
     */
    private String collectMoney() {
        return "Collect $200";
    }
}
