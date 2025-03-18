package org.monopoly.Model;

/**
 * Represents the Water Works Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class WaterWorksSpace extends GameTile {

    /**
     * Constructor to initialize a WaterWorksSpace.
     *
     * Developed by: shifmans
     */
    public WaterWorksSpace() {
        super("Water Works Space", "");
    }

    /**
     * Shows the actions that occur after a player lands on element space.
     * @return Displays the actions for landing on element space.
     *
     * Developed by: shifmans
     */
    @Override
    public String landOn() {
        actions += displayWaterWorksInfo();
        return actions;
    }

    /**
     * Player is shown information about Water Works after landing on element space.
     * @return Information on Water Works Space.
     *
     * Developed by: shifmans
     */
    private String displayWaterWorksInfo() {
        return "Property Name: Water Works\n" +
                "Color Set: None (Utility)\n" +
                "Purchase Price: $150\n" +
                "Rent (without houses/hotels): Depends on dice roll\n" +
                "If you own 1 Utility: Rent is 4 times the amount rolled on the dice.\n" +
                "If you own 2 Utilities: Rent is 10 times the amount rolled on the dice.\n" +
                "Mortgage Value: $75\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels";
    }
}
