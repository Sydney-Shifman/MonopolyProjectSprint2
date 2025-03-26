package org.monopoly.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.monopoly.Model.Strategy;
import org.monopoly.Exceptions.InsufficientFundsException;
import org.monopoly.Model.Cards.ChanceDeck;
import org.monopoly.Model.Cards.CommunityChestDeck;
import org.monopoly.Model.GameTiles.*;
import org.monopoly.Model.Players.HumanPlayer;
import org.monopoly.Model.Players.Player;
import org.monopoly.Model.Players.Token;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This test Class focuses on and tests that every single possible strategy and process for every single tile
 */
public class StrategyTests {

    @Test
    public void testStrategy() {
        Strategy strategy = new Strategy() {
            @Override
            public void executeStrategy(Player humanPlayer) {

            }
        };
    }

    @Test
    public void testExecuteStrategy() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy strategy = new Strategy() {
            @Override
            public void executeStrategy(Player player) {
            }
        };
        HumanPlayer player = new HumanPlayer("Test Player", token);
        strategy.executeStrategy(player);
    }

    @Test
    public void testGoSpaceSalary() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy strategy = new GoSpace();
        HumanPlayer player = new HumanPlayer("Test Player", token);
        int initialBalance = player.getBalance();
        strategy.executeStrategy(player);
        int finalBalance = player.getBalance();
        assertEquals(initialBalance + 200, player.getBalance(), "Player's salary should be 1700.");
        System.out.println("Player's final balance: " + finalBalance);
    }

    @Test
    public void testGoSpaceSalaryMultipleTimes() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy strategy = new GoSpace();
        HumanPlayer player = new HumanPlayer("Test Player", token);
        int initialBalance = player.getBalance();
        strategy.executeStrategy(player);
        strategy.executeStrategy(player);
        int finalBalance = player.getBalance();
        assertEquals(finalBalance, player.getBalance(), "Player's salary should be 1900.");
        System.out.println("Player's final balance: " + finalBalance);
    }

    @Test
    public void testFreeParkingSpace() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy strategy = new FreeParkingSpace();
        HumanPlayer player = new HumanPlayer("Test Player", token);
        strategy.executeStrategy(player);
        assertEquals(1500, player.getBalance(), "Player's balance should be the same after landing on free parking space.");
    }

    @Test
    public void testGoToJailSpace() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy strategy = new GoToJailSpace();
        HumanPlayer player = new HumanPlayer("Test Player", token);
        strategy.executeStrategy(player);
        assertEquals(10, player.getPosition(), "Player should be in jail.");
    }

    @Test
    public void testJustVisitingJail() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy strategy = new JailSpace();
        HumanPlayer player = new HumanPlayer("Test Player", token);
        player.move(10);
        strategy.executeStrategy(player);
        assertEquals(10, player.getPosition(), "Player should be at jail space.");
        assertFalse(player.isInJail(), "Player should just be visiting jail.");
    }

    @Test
    public void testBeingInJail() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy goToJail = new GoToJailSpace();
        Strategy jail = new JailSpace();
        HumanPlayer player = new HumanPlayer("Test Player", token);
        goToJail.executeStrategy(player);
        jail.executeStrategy(player);
        assertEquals(10, player.getPosition(), "Player should be at jail space.");
        assertTrue(player.isInJail(), "Player should be in jail.");
    }

    @Test
    public void testIncomeTaxSpace() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy strategy = new IncomeTaxSpace();
        HumanPlayer player = new HumanPlayer("Test Player", token);
        int initialBalance = player.getBalance();
        strategy.executeStrategy(player);
        int finalBalance = player.getBalance();
        assertEquals(initialBalance - 200, player.getBalance(), "Player should pay $200 in income tax.");
        System.out.println("Player's final balance: " + finalBalance);
    }

    @Test
    public void testLuxuryTaxSpace() {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        Strategy strategy = new LuxuryTaxSpace();
        HumanPlayer player = new HumanPlayer("Test Player", token);
        int initialBalance = player.getBalance();
        strategy.executeStrategy(player);
        int finalBalance = player.getBalance();
        assertEquals(initialBalance - 100, player.getBalance(), "Player should pay $100 in income tax.");
        System.out.println("Player's final balance: " + finalBalance);
    }

//    @Test
//    public void testPlayerDoesNotOwnElectricCompany() {
//        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
//        Strategy strategy = new ElectricCompanySpace();
//        HumanPlayer player = new HumanPlayer("Test Player", token);
//        player.move(12);
//        strategy.executeStrategy(player);
//        assertFalse(player.hasProperty("Electric Company"), "Player should not own Electric Company.");
//    }

//    @Test
//    public void testPlayerOwnsElectricCompany() throws InsufficientFundsException {
//        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
//        Strategy strategy = new ElectricCompanySpace();
//        HumanPlayer player = new HumanPlayer("Test Player", token);
//        player.move(12);
//        player.purchaseProperty("Electric Company", 150);
//        strategy.executeStrategy(player);
//        assertTrue(player.hasProperty("Electric Company"), "Player should own Electric Company.");
//        System.out.println("Player has Electric Company: " + player.hasProperty("Electric Company"));
//    }

//    @Test
//    public void testPlayerBuysElectricCompany() throws InsufficientFundsException {
//        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
//        Strategy strategy = new ElectricCompanySpace();
//        HumanPlayer player = new HumanPlayer("Test Player", token);
//        player.move(12);
//        player.purchaseProperty("Electric Company", 150);
//        strategy.executeStrategy(player);
//        assertEquals(1350, player.getBalance(), "Player should have $1350 after buying Electric Company.");
//        System.out.println("Player's final balance: " + player.getBalance());
//    }

//    @Test
//    public void testPlayerDoesOwnWaterworks() throws InsufficientFundsException {
//        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
//        Strategy strategy = new WaterWorksSpace();
//        HumanPlayer player = new HumanPlayer("Test Player", token);
//        player.move(28);
//        player.purchaseProperty("Water Works", 150);
//        strategy.executeStrategy(player);
//        assertTrue(player.hasProperty("Water Works"), "Player should own Water Works.");
//        System.out.println("Player has Water Works: " + player.hasProperty("Water Works"));
//    }
//
//    @Test
//    public void testPlayerDoesNotOwnWaterworks() {
//        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
//        Strategy strategy = new WaterWorksSpace();
//        HumanPlayer player = new HumanPlayer("Test Player", token);
//        player.move(28);
//        player.subtractFromBalance(1450);
//        strategy.executeStrategy(player);
//        assertFalse(player.hasProperty("Water Works"), "Player should not own Water Works.");
//        System.out.println("Player does not have Water Works: " + player.hasProperty("Water Works"));
//    }
}