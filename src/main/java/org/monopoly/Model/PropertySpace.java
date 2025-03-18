package org.monopoly.Model;

/**
 * Represents the Property Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class PropertySpace extends GameTile {
    private int price;
    private int rent;
    private String colorGroup;

    /**
     * Constructor to initialize a PropertySpace.
     * @param name Name of a PropertySpace.
     * @param actions Actions for a PropertySpace.
     * @param price Price for a PropertySpace.
     * @param rent Rent for a PropertySpace.
     * @param colorGroup Color Group for a PropertySpace.
     *
     * Developed by: shifmans
     */
    public PropertySpace(String name, String actions, int price, int rent, String colorGroup) {
        super(name, actions);
        this.price = price;
        this.rent = rent;
        this.colorGroup = colorGroup;
    }

    /**
     * Shows the actions that occur after a player lands on element space.
     * @return Displays the actions for landing on element space.
     *
     * Developed by: shifmans
     */
    @Override
    public String landOn() {
        actions += displayPropertyInfo();
        return actions;
    }

    /**
     * Player is shown information about Property after landing on element space.
     * @return Information on Property Space.
     *
     * Developed by: shifmans
     */
    private String displayPropertyInfo() {
        return "Property Name: Boardwalk\n" +
                "Color Set: Dark Blue\n" +
                "Purchase Price: $400\n" +
                "Rent (without houses/hotels): $50\n" +
                "Rent with 1 House: $200\n" +
                "Rent with 2 Houses: $600\n" +
                "Rent with 3 Houses: $1,400\n" +
                "Rent with 4 Houses: $1,800\n" +
                "Rent with Hotel: $2,000\n" +
                "Mortgage Value: $200\n" +
                "Houses: Can build 4 houses\n" +
                "Hotel: Can build 1 hotel";
    }
}
