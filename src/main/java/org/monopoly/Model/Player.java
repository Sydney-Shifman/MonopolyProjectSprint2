package org.monopoly.Model;

/**
 * A class representing a player in the Monopoly game.
 * More functionality will be added
 */
public class Player {
    private String name;
    private int position;
    private boolean inJail;
    private Token token;

    public Player(String name, Token token) {
        this.name = name;
        this.token = token;
        this.inJail = false;
        token.setOwner(this);
    }

    public String getName() {
        return name;
    }

    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return name + " (Token: " + token.getName() + ")";
    }

    /**
     * Moves player a certain number of spaces
     * Also checks if they are in jail or not
     * @param spaces
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

    public boolean isInJail() {
        return inJail;
    }

    public int getPosition() {
        return position;
    }

    /**
     * A method for a player to take a turn in the game
     * @param dice
     */
    public void takeTurn (Dice dice) {
        if (inJail) {
            System.out.println(name + " is in jail and cannot roll.");
        }

        int[] rollResult = dice.roll();
        int die1 = rollResult[0];
        int die2 = rollResult[1];
        int total = die1 + die2;

        System.out.println(name + " rolled a " + die1 + " and a " + die2 + " (Total: " + total + ")");

        move(total);

        if (dice.isDouble()) {
            Dice.incrementNumDoubles();
            System.out.println(name + " rolled doubles!");
            if (Dice.getNumDoubles() == 3) {
                goToJail();
                System.out.println(name + " has been sent to jail for 3 consecutive doubles.");
            } else {
                System.out.println(name + " gets to roll again!");
                takeTurn(dice);
            }
        } else {
            Dice.resetNumDoubles();
        }
    }
}
