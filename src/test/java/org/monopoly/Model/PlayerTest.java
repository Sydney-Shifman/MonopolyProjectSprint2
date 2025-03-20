package org.monopoly.Model;

import org.junit.jupiter.api.Test;
import org.monopoly.Exceptions.InsufficientFundsException;
import org.monopoly.Exceptions.NoSuchPropertyException;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        assertEquals("John Doe", player.getName());
        assertEquals(1500, player.getBalance());
        assertEquals(0, player.getPosition());
    }

    @Test
    public void testPlayerBalance() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.addToBalance(2000);
        assertEquals(3500, player.getBalance());
    }

    @Test
    public void testPlayerName() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        assertEquals("John Doe", player.getName());
    }

    @Test
    public void testPlayerSetPosition() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.setPosition(5);
        assertEquals(5, player.getPosition());
    }

    @Test
    public void testGetNumHouses() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        assertEquals(0, player.getNumHouses());
    }

    @Test
    public void testGetNumHotels() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        assertEquals(0, player.getNumHotels());
    }

    @Test
    void playerMoveWorksWhenNotInJail() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.move(5);
        assertEquals(5, player.getPosition());
    }

    @Test
    void playerDoesNotMoveWhenInJail() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.goToJail(); // new pos in jail (10)
        assertEquals(10, player.getPosition());
        player.move(5);
        assertEquals(10, player.getPosition());
    }

    @Test
    void playerCanGetOutOfJail() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.goToJail(); // new pos in jail (10)
        assertEquals(10, player.getPosition());
        player.releaseFromJail();
        assertFalse(player.isInJail());
        player.move(5);
        assertEquals(15, player.getPosition());
    }

    @Test
    void playerHasAGameToken () {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        assertNotNull(player.getToken());
    }

    @Test
    void playerCanPurchaseProperty() throws InsufficientFundsException {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.purchaseProperty("Park Place", 350);
        assertTrue(player.hasProperty("Park Place"));
        assertEquals(1150, player.getBalance());
    }

    @Test
    void playerCannotPurchasePropertyIfInsufficientFunds() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.subtractFromBalance(1400); // Set balance to 100
        try {
            player.purchaseProperty("Park Place", 350);
        } catch (InsufficientFundsException e) {
            assertEquals("Insufficient funds to purchase Park Place", e.getMessage());
        }
        assertFalse(player.hasProperty("Park Place"));
    }

    @Test
    void playerTaxedForMoreThanTheyCanAffordGoesBankrupt(){
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.subtractFromBalance(1400); // Set balance to 100
        player.subtractFromBalance(2000); // Taxed 2000
        assertTrue(player.isBankrupt());
    }

    @Test
    void playerCanAddAndRemoveCardsFromTheirHand(){
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.addCard("Get Out of Jail Free");
        assertTrue(player.hasCard("Get Out of Jail Free"));
        player.removeCard("Get Out of Jail Free");
        assertFalse(player.hasCard("Get Out of Jail Free"));
    }

    @Test
    void playerToStringMethodWorks(){
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        assertEquals("John Doe (Token: John Doe)", player.toString());
    }

    @Test
    void testPlayerHasAMonopoly() throws InsufficientFundsException {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.purchaseProperty("Boardwalk", 400);
        player.purchaseProperty("Park Place", 350);

        assertTrue(player.hasMonopoly("darkBlue"));
    }

    @Test
    void playerCanHaveMultipleMonoPolies() throws InsufficientFundsException {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.purchaseProperty("Boardwalk", 400);
        player.purchaseProperty("Park Place", 350);
        player.purchaseProperty("Mediterranean Avenue", 200);
        player.purchaseProperty("Baltic Avenue", 200);

        assertTrue(player.hasMonopoly("darkBlue"));
        assertTrue(player.hasMonopoly("brown"));
    }

    @Test
    void testPlayerCanSellProperty() throws InsufficientFundsException, NoSuchPropertyException {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.purchaseProperty("Park Place", 350);
        player.sellProperty("Park Place", 350);
        assertFalse(player.hasProperty("Park Place"));
        assertEquals(1500, player.getBalance());
    }

    @Test
    void mortgagePropertyWorks() throws InsufficientFundsException, NoSuchPropertyException {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.purchaseProperty("Park Place", 350);
        player.mortgageProperty("Park Place", 175);
        assertFalse(player.hasProperty("Park Place"));
        assertEquals(1325, player.getBalance());
    }

}
