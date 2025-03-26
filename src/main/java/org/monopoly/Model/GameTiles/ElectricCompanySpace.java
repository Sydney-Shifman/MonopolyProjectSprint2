package org.monopoly.Model.GameTiles;

import org.monopoly.Exceptions.InsufficientFundsException;
import org.monopoly.Model.Players.HumanPlayer;
import org.monopoly.Model.Players.Player;

/**
 * Represents the Electric Company Space element on the Game Board's Tiles.
 *
 * @author shifmans
 */
public class ElectricCompanySpace extends GameTile {

    /**
     * Constructor to initialize a ElectricCompanySpace.
     *
     * Developed by: shifmans
     */
    public ElectricCompanySpace() {
        super("Electric Company Space", "");
    }

    /**
     * Shows the actions that occur after a player lands on element space.
     * @return Displays the actions for landing on element space.
     *
     * Developed by: shifmans
     */
    @Override
    public String landOn() {
        actions += displayElectricCompanyInfo();
        return actions;
    }

    /**
     * Player is shown information about Electric Company after landing on element space.
     * @return Information on Electric Company Space.
     *
     * Developed by: shifmans
     */
    private String displayElectricCompanyInfo() {
        return "Property Name: Electric Company\n" +
                "Color Set: None (Utility)\n" +
                "Purchase Price: $150\n" +
                "Rent (without houses/hotels): Depends on dice roll\n" +
                "If you own 1 Utility: Rent is 4 times the amount rolled on the dice.\n" +
                "If you own 2 Utilities: Rent is 10 times the amount rolled on the dice.\n" +
                "Mortgage Value: $75\n" +
                "Houses: Cannot build houses or hotels\n" +
                "Hotel: Cannot build hotels";
    }

    @Override
    public void executeStrategy(HumanPlayer player) {
        if (!player.hasProperty("Electric Company")) {
            player.subtractFromBalance(150);
            player.addCard("Electric Company");
        } else {
            System.out.println(player.getName() + " already owns the Electric Company.");
        }
    }
}
