package org.monopoly.Model;

import org.monopoly.Exceptions.HouseCannotBeBuiltException;
import org.monopoly.Exceptions.HotelCannotBeBuiltException;
import org.monopoly.Exceptions.InsufficientFundsException;
import org.monopoly.Exceptions.NoSuchPropertyException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class representing a player in the Monopoly game.
 * More functionality will be added
 * @author walshj05, crevelings
 */
public class HumanPlayer extends Player {
    private String name;
    private int position;
    private int balance;
    private boolean inJail;
    private Token token;
    private int numHouses;
    private int numHotels;
    private ArrayList<String> propertiesOwned;
    private ArrayList<String> propertiesMortgaged;
    private HashMap<String, Integer> monopolies;
    private ArrayList<String> cards;
// todo add functionality for the player to add a house or hotel to a property. must have a monopoly on the property to do so

    public HumanPlayer(String name, Token token) {
        this.name = name;
        this.token = token;
        this.balance = 1500; // Starting balance
        this.inJail = false;
        token.setOwner(this);
        this.position = 0;
        this.numHouses = 0;
        this.numHotels = 0;
        this.propertiesOwned = new ArrayList<>();
        this.propertiesMortgaged = new ArrayList<>();
        this.monopolies = new HashMap<>();
        this.cards = new ArrayList<>();
    }

    /**
     * Getters and Setters
     */
    public String getName() {
        return name;
    }

    public Token getToken() {
        return token;
    }

    public int getPosition() {
        return position;
    }

    public int getBalance() {
        return balance;
    }

    public int getNumHotels() {
        return numHotels;
    }

    public int getNumHouses() {
        return numHouses;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    /**
     * Moves player a certain number of spaces
     * Also checks if they are in jail or not
     * @param spaces num spaces moved
     */
    public void move(int spaces) {
        if (!inJail) {
            position += spaces; // Move the player
            System.out.println(name + " moved " + spaces + " spaces to position " + position);
        } else {
            System.out.println(name + " is in jail and cannot move.");
        }
    }

    /**
     * Puts player in jail
     */
    public void goToJail() {
        inJail = true;
        position = 10; // Assuming position 10 is Jail
        System.out.println(name + " has been sent to jail!");
    }

    /**
     * Checks to see if the player is in jail
     * @return boolean
     */
    public boolean isInJail() {
        return inJail;
    }

    /**
     * Releases player from jail
     */
    public void releaseFromJail() {
        inJail = false;
        System.out.println(name + " has been released from jail!");
    }

    /**
     * A method for a player to take a turn in the game
     * @param dice Dice object
     */
    public void takeTurn (Dice dice) {
        // todo implement player turn

//        if (inJail) {
//            System.out.println(name + " is in jail and cannot roll.");
//        }
//
//        int[] rollResult = dice.roll();
//        int die1 = rollResult[0];
//        int die2 = rollResult[1];
//        int total = die1 + die2;
//
//        System.out.println(name + " rolled a " + die1 + " and a " + die2 + " (Total: " + total + ")");
//
//        move(total);
//
//        if (dice.isDouble()) {
//            Dice.incrementNumDoubles();
//            System.out.println(name + " rolled doubles!");
//            if (Dice.getNumDoubles() == 3) {
//                goToJail();
//                System.out.println(name + " has been sent to jail for 3 consecutive doubles.");
//            } else {
//                System.out.println(name + " gets to roll again!");
//                takeTurn(dice);
//            }
//        } else {
//            Dice.resetNumDoubles();
//        }
    }

    /**
     * Player buys a property
     * @param property String
     * @throws InsufficientFundsException exception
     */
    public void purchaseProperty(String property, int price) throws InsufficientFundsException {
        if (balance >= price) {
            propertiesOwned.add(property);
            balance -= price;
            checkForMonopoly();
        } else {
            throw new InsufficientFundsException("Insufficient funds to purchase " + property);
        }
    }

    /**
     * Player sells a property
     * @param property String
     * @throws NoSuchPropertyException exception
     */
    public void mortgageProperty(String property, int mortgageCost) throws NoSuchPropertyException {
        if (propertiesOwned.contains(property)) {
            propertiesOwned.remove(property);
            propertiesMortgaged.add(property);
            balance += mortgageCost;
        } else {
            throw new NoSuchPropertyException("You do not own " + property);
        }
    }

    /**
     * Player sells a property
     * @param property String
     * @throws NoSuchPropertyException exception
     */
    public void sellProperty(String property, int propertyCost) throws NoSuchPropertyException {
        if (propertiesOwned.contains(property)) {
            propertiesOwned.remove(property);
            balance += propertyCost;
            checkForMonopoly();
        } else {
            throw new NoSuchPropertyException("You do not own " + property);
        }
    }

    /**
     * Checks if the player has a monopoly
     * @return boolean
     */
    public boolean hasMonopoly(String colorGroup) {
        return monopolies.containsKey(colorGroup);
    }

    /**
     * Adds a house to a property
     * @param property String
     * @throws HouseCannotBeBuiltException exception
     */
    public void addHouse(String property, String colorGroup) throws HouseCannotBeBuiltException {
    }

    /**
     * Adds a hotel to a property
     * @param property String
     * @throws HotelCannotBeBuiltException exception
     */
    public void addHotel(String property) throws HotelCannotBeBuiltException {
    }

    /**
     * Adds a certain amount to the player's balance
     * @param amount int
     */
    public void addToBalance(int amount) {
        this.balance += amount;
    }

    /**
     * Subtracts a certain amount from the player's balance
     * @param amount int
     */
    public void subtractFromBalance(int amount) {
        if (this.balance - amount < 0) {
            this.balance = 0;
            return;
        }
        this.balance -= amount;
    }

    /**
     * Checks if the player has a certain property
     * @param property String
     * @return boolean
     */
    public boolean hasProperty(String property) {
        return propertiesOwned.contains(property);
    }

    /**
     * Adds a community chest card to the player's hand
     * @param card String
     */
    public void addCard(String card) {
        cards.add(card);
    }

    /**
     * Removes a community chest card from the player's hand
     * @param card String
     */
    public void removeCard(String card) {
        cards.remove(card);
    }

    /**
     * Checks if the player has a certain community chest card
     * @param card String
     * @return boolean
     */
    public boolean hasCard(String card) {
        return cards.contains(card);
    }

    /**
     * Checks if the player is bankrupt
     * @return boolean
     */
    public boolean isBankrupt() {
        return balance == 0;
    }

    @Override
    public String toString() {
        return name + " (Token: " + token.getName() + ")";
    }

    /**
     * Checks if the player has a monopoly,
     */
    private void checkForMonopoly() {
        ArrayList<String> currMonopolies = new ArrayList<>();
        if (propertiesOwned.contains("Mediterranean Avenue") && propertiesOwned.contains("Baltic Avenue")) {
            currMonopolies.add("brown");
        }
        if (propertiesOwned.contains("Oriental Avenue") && propertiesOwned.contains("Vermont Avenue") && propertiesOwned.contains("Connecticut Avenue")) {
            currMonopolies.add("lightBlue");
        }
        if (propertiesOwned.contains("St. Charles Place") && propertiesOwned.contains("States Avenue") && propertiesOwned.contains("Virginia Avenue")) {
            currMonopolies.add("pink");
        }
        if (propertiesOwned.contains("St. James Place") && propertiesOwned.contains("Tennessee Avenue") && propertiesOwned.contains("New York Avenue")) {
            currMonopolies.add("orange");
        }
        if (propertiesOwned.contains("Kentucky Avenue") && propertiesOwned.contains("Indiana Avenue") && propertiesOwned.contains("Illinois Avenue")) {
            currMonopolies.add("red");
        }
        if (propertiesOwned.contains("Atlantic Avenue") && propertiesOwned.contains("Ventnor Avenue") && propertiesOwned.contains("Marvin Gardens")) {
            currMonopolies.add("yellow");
        }
        if (propertiesOwned.contains("Pacific Avenue") && propertiesOwned.contains("North Carolina Avenue") && propertiesOwned.contains("Pennsylvania Avenue")) {
            currMonopolies.add("green");
        }
        if (propertiesOwned.contains("Park Place") && propertiesOwned.contains("Boardwalk")) {
            currMonopolies.add("darkBlue");
        }
        updateMonopolies(currMonopolies);
    }

    private void updateMonopolies(ArrayList<String> monopolies) {
        for (String monopoly : monopolies) {
            if (!this.monopolies.containsKey(monopoly)) {
                this.monopolies.put(monopoly, 0);
            }
        }
    }
}
