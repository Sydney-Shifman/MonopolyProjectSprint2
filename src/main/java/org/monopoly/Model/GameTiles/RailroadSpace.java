package org.monopoly.Model.GameTiles;

import org.monopoly.Model.Cards.ColorGroup;

import java.util.ArrayList;

/**
 * Represents the Railroad Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class RailroadSpace extends GameTile {
    private int price;
    private ArrayList<Integer> rentPrices;
    private ColorGroup colorGroup;
    private int mortgageValue;
    private int unmortgageValue;
    private boolean isMortgaged;
    private String owner;

    /**
     * Constructor to initialize a RailroadSpace.
     *
     * Developed by: shifmans
     */
    public RailroadSpace() {
        super("Railroad Space", "");
    }

    /**
     * Constructor to initialize a RailroadSpace with the following parameters.
     * @param name Name for a RailroadSpace.
     * @param actions Actions for a RailroadSpace.
     * @param price Price for a RailroadSpace.
     * @param rentPrices Rent Price for a RailroadSpace.
     * @param colorGroup Color Group for a RailroadSpace.
     * @param mortgageValue Mortgage Value for a RailroadSpace.
     *
     * Developed by: shifmans
     */
    public RailroadSpace(String name, String actions, int price, ArrayList<Integer> rentPrices, ColorGroup colorGroup, int mortgageValue) {
        super(name, actions);
        this.price = price;
        this.rentPrices = rentPrices;
        this.colorGroup = colorGroup;
        this.mortgageValue = mortgageValue;
        this.unmortgageValue = mortgageValue + (int) (mortgageValue * 0.1); //Mortgage value plus 10% interest
        this.isMortgaged = false;
        this.owner = "";
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
        return "Property Name: " + getName() + "\n" +
                "Color Set: " + getColorGroup() + "\n" +
                "Purchase Price: " + getPrice() + "\n" +
                "Rent with 1 owned Railroad: " + getRentPrices().get(0) + "\n" +
                "Rent with 2 owned Railroad: " + getRentPrices().get(1) + "\n" +
                "Rent with 3 owned Railroad: " + getRentPrices().get(2) + "\n" +
                "Rent with 4 owned Railroad: " + getRentPrices().get(3) + "\n" +
                "Mortgage Value: " + getMortgageValue();
    }

    /**
     * Gets the price of a ElectricCompanySpace.
     * @return The price of a ElectricCompanySpace.
     *
     * Developed by: shifmans
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the rent prices of a PropertySpace.
     * @return The list of rent prices of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public ArrayList<Integer> getRentPrices() {
        return rentPrices;
    }

    /**
     * Gets the color group of a ElectricCompanySpace.
     * @return The color group of a ElectricCompanySpace.
     *
     * Developed by: shifmans
     */
    public ColorGroup getColorGroup() {
        return colorGroup;
    }

    /**
     * Gets the mortgage value of a ElectricCompanySpace.
     * @return The mortgage value of a ElectricCompanySpace.
     *
     * Developed by: shifmans
     */
    public int getMortgageValue() {
        return mortgageValue;
    }

    /**
     * Gets the unmortgage value of a ElectricCompanySpace.
     * @return The unmortgage value of a ElectricCompanySpace.
     */
    public int getUnmortgageValue() {
        return unmortgageValue;
    }

    /**
     * Gets the mortgaged status of a ElectricCompanySpace.
     * @return The mortgaged status of a ElectricCompanySpace.
     *
     * Developed by: shifmans
     */
    public boolean isMortgaged() {
        return isMortgaged;
    }

    /**
     * Sets the mortgaged status of a ElectricCompanySpace.
     * @param isMortgaged The mortgaged status of a ElectricCompanySpace.
     *
     * Developed by: shifmans
     */
    public void setMortgagedStatus(boolean isMortgaged) {
        this.isMortgaged = isMortgaged;
    }

    /**
     * Gets the owner of a ElectricCompanySpace.
     * @return The owner of a ElectricCompanySpace.
     *
     * Developed by: shifmans
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of a ElectricCompanySpace.
     * @param owner The owner of a ElectricCompanySpace.
     *
     * Developed by: shifmans
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
