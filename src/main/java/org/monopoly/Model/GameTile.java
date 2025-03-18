package org.monopoly.Model;

import java.util.ArrayList;

/**
 * Represents the Tiles on the Game Board.
 *
 * @author shifmans
 */
public abstract class GameTile {
    protected String name;
    protected String actions;
    protected ArrayList<String> tokens;
    protected final int MAX_CAPACITY = 9;

    /**
     * Constructor to initialize a GameTile.
     * @param name Name of a GameTile.
     * @param actions Actions that occur when a player lands on a GameTile.
     *
     * Developed by: shifmans
     */
    public GameTile(String name, String actions) {
        this.name = name;
        this.actions = actions;
        this.tokens = new ArrayList<>();
    }

    /**
     * Gets the name of the element space.
     * @return Name identification for element space.
     *
     * Developed by: shifmans
     */
    public String getName() {
        return name;
    }

    /**
     * Shows the actions that occur after a player lands on element space.
     * @return Displays the actions for landing on element space.
     *
     * Developed by: shifmans
     */
    public String landOn() {
        return actions;
    }

    /**
     * Gets the collection of Tokens that occupy the element space.
     * @return Collection of Tokens currently on element space.
     *
     * Developed by: shifmans
     */
    public ArrayList<String> getTokens() {
        return tokens;
    }

    /**
     * Adds given Token into collection of Tokens that occupy the element space.
     * @param token Token of player that is on element space.
     *
     * Developed by: shifmans
     */
    public void addToken(String token) {
        if (!hasReachedCapacity()) {
            tokens.add(token);
        }
    }

    /**
     * Checks to see if the collection of Tokens on an element space has reached its capacity.
     * @return Whether the collection of Tokens equals the MAX_CAPACITY.
     *
     * Developed by: shifmans
     */
    public boolean hasReachedCapacity() {
        return tokens.size() == MAX_CAPACITY;
    }

    /**
     * Removes given Token from collection of Tokens that occupy the element space.
     * @param token Token of player that is on element space.
     *
     * Developed by: shifmans
     */
    public void removeToken(String token) {
        tokens.remove(token);
    }
}
