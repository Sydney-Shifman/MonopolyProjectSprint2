package org.monopoly.Model.GameTiles;

import org.monopoly.Model.Cards.ColorGroup;
import org.monopoly.Model.Players.HumanPlayer;
import org.monopoly.Model.Players.Player;

import java.util.ArrayList;

/**
 * Represents the Property Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class PropertySpace extends GameTile {
    private int price;
    private int basicRent; //Eventually will be replaced by rentPrices, causing refactoring.
    private ArrayList<Integer> rentPrices;
    private String colorGroupString; //Eventually will be replaced by colorGroup, causing refactoring.
    private ColorGroup colorGroup;
    private int housePrice;
    private int hotelPrice;
    private int mortgageValue;
    private boolean isMortgaged;
    private String owner;

    /**
     * Constructor to initialize a PropertySpace with basic information.
     * @param name Name of a PropertySpace.
     * @param actions Actions for a PropertySpace.
     * @param price Price for a PropertySpace.
     * @param basicRent Rent for a PropertySpace.
     * @param colorGroupString Color Group for a PropertySpace.
     *
     * Developed by: shifmans
     */
    public PropertySpace(String name, String actions, int price, int basicRent, String colorGroupString) {
        super(name, actions);
        this.price = price;
        this.basicRent = basicRent;
        this.colorGroupString = colorGroupString;
    }

    /**
     * Constructor to initialize a PropertySpace with all information.
     * @param name Name of a PropertySpace.
     * @param actions Actions for a PropertySpace.
     * @param price Price for a PropertySpace.
     * @param colorGroup Color Group for a PropertySpace.
     * @param housePrice House Price for a PropertySpace.
     * @param hotelPrice Hotel Price for a PropertySpace.
     * @param mortgageValue Mortgage Value for a PropertySpace.
     *
     * Developed by: shifmans
     */
    public PropertySpace(String name, String actions, int price, ArrayList<Integer> rentPrices, ColorGroup colorGroup, int housePrice, int hotelPrice, int mortgageValue) {
        super(name, actions);
        this.price = price;
        this.rentPrices = rentPrices;
        this.colorGroup = colorGroup;
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;
        this.mortgageValue = mortgageValue;
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

    /**
     * Gets the price of a PropertySpace.
     * @return The price of a PropertySpace.
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
     * Gets the color group of a PropertySpace.
     * @return The color group of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public ColorGroup getColorGroup() {
        return colorGroup;
    }

    /**
     * Gets the house price of a PropertySpace.
     * @return The house price of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public int getHousePrice() {
        return housePrice;
    }

    /**
     * Gets the hotel price of a PropertySpace.
     * @return The hotel price of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public int getHotelPrice() {
        return hotelPrice;
    }

    /**
     * Gets the mortgage value of a PropertySpace.
     * @return The mortgage value of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public int getMortgageValue() {
        return mortgageValue;
    }

    /**
     * Gets the mortgaged status of a PropertySpace.
     * @return The mortgaged status of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public boolean isMortgaged() {
        return isMortgaged;
    }

    /**
     * Sets the mortgaged status of a PropertySpace.
     * @param isMortgaged The mortgaged status of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public void setMortgagedStatus(boolean isMortgaged) {
        this.isMortgaged = isMortgaged;
    }

    /**
     * Gets the owner of a PropertySpace.
     * @return The owner of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of a PropertySpace.
     * @param owner The owner of a PropertySpace.
     *
     * Developed by: shifmans
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void executeStrategy(HumanPlayer player) {
    }
}
