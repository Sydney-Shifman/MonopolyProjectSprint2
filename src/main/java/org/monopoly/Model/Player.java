package org.monopoly.Model;

import org.monopoly.Exceptions.HouseCannotBeBuiltException;
import org.monopoly.Exceptions.HotelCannotBeBuiltException;
import org.monopoly.Exceptions.InsufficientFundsException;
import org.monopoly.Exceptions.NoSuchPropertyException;

import java.util.ArrayList;

/**
 * A class representing a player in the Monopoly game.
 * More functionality will be added
 */
public class Player {
    private String name;
    private int position;
    private int balance;
    private boolean inJail;
    private Token token;
    private ArrayList<String> propertiesOwned;
    private ArrayList<String> propertiesMortgaged;
    private ArrayList<String> monopolies;
    private ArrayList<String> communityChestCards;

    public Player(String name, Token token) {
        this.name = name;
        this.token = token;
        this.balance = 1500; // Starting balance
        this.inJail = false;
        token.setOwner(this);
        this.position = 0;
        this.propertiesOwned = new ArrayList<>();
        this.propertiesMortgaged = new ArrayList<>();
        this.monopolies = new ArrayList<>();
        this.communityChestCards = new ArrayList<>();
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

    public Token getPlayerToken() {
        return token;
    }

    public void setPosition(int position) {}


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
     * A method for a player to take a turn in the game
     * @param dice Dice object
     */
    public void takeTurn (Dice dice) {
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
    public void purchaseProperty(String property) throws InsufficientFundsException {
    }

    /**
     * Player sells a property
     * @param property String
     * @throws NoSuchPropertyException exception
     */
    public void mortgageProperty(String property) throws NoSuchPropertyException {
    }

    /**
     * Player sells a property
     * @param property String
     * @throws NoSuchPropertyException exception
     */
    public void sellProperty(String property) throws NoSuchPropertyException {
    }

    /**
     * Checks if the player has a monopoly
     * @return boolean
     */
    public boolean hasMonopoly() {
        return false;
    }

    /**
     * Adds a house to a property
     * @param property String
     * @throws HouseCannotBeBuiltException exception
     */
    public void addHouse(String property) throws HouseCannotBeBuiltException {
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
    }

    /**
     * Subtracts a certain amount from the player's balance
     * @param amount int
     */
    public void subtractFromBalance(int amount) {
    }


    /**
     * Checks if the player has a certain property
     * @param property String
     * @return boolean
     */
    public boolean hasProperty(String property) {
        return propertiesOwned.contains(property);
    }

    public void addCommunityChestCard(String card) {
        communityChestCards.add(card);
    }

    // todo add a method for the player to use a community chest card
    @Override
    public String toString() {
        return name + " (Token: " + token.getName() + ")";
    }
}
