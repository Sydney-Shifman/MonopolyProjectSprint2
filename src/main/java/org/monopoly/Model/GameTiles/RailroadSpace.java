package org.monopoly.Model.GameTiles;

import org.monopoly.Model.Players.Player;

/**
 * Represents the Railroad Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class RailroadSpace extends GameTile {

    /**
     * Constructor to initialize a RailroadSpace.
     *
     * Developed by: shifmans
     */
    public RailroadSpace() {
        super("Railroad Space", "");
    }

    /**
     * Shows the actions that occur after a player lands on element space.
     * @return Displays the actions for landing on element space.
     *
     * Developed by: shifmans
     */
    @Override
    public String landOn() {
        actions += displayRailroadInfo();
        return actions;
    }

    /**
     * Player is shown information about Railroad after landing on element space.
     * @return Information on Railroad Space.
     *
     * Developed by: shifmans
     */
    private String displayRailroadInfo() {
        return "Property Name: Reading Railroad\n" +
                "Color Set: None (Railroad)\n" +
                "Purchase Price: $200\n" +
                "Rent (without houses/hotels): $25\n" +
                "Rent with 1 Railroad Owned: $25\n" +
                "Rent with 2 Railroads Owned: $50\n" +
                "Rent with 3 Railroads Owned: $100\n" +
                "Rent with 4 Railroads Owned: $200\n" +
                "Mortgage Value: $100\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels";
    }

    @Override
    public void executeStrategy(Player player) {

    }
}
