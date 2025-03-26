package org.monopoly.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.monopoly.Model.Cards.TitleDeedDeck;
import org.monopoly.Model.Players.HumanPlayer;
import org.monopoly.Model.Players.Token;

public class BankerTests {

    @Test
    public void testBankerConstructor() {
        Banker banker = new Banker();
        TitleDeedDeck deck = banker.getDeck();

        assertEquals(28, deck.getSize());
        assertEquals(32, banker.getHouses());
        assertEquals(32, banker.getHotels());
        assertEquals(Double.POSITIVE_INFINITY, banker.getBalance());

        // Check that the deck contains the correct properties
        assertTrue(deck.getTitleDeeds().getProperties().containsKey("Boardwalk"));
    }

    @Test
    public void testSellProperty() {
        Banker banker = new Banker();
        TitleDeedDeck deck = banker.getDeck();
        int deckSize = deck.getSize();

        banker.sellProperty("Boardwalk");
        assertEquals(deckSize - 1, deck.getSize());
    }

    @Test
    public void testSellHouse() {
        Banker banker = new Banker();
        int houses = banker.getHouses();

        banker.sellHouse("Boardwalk");
        assertEquals(houses - 1, banker.getHouses());
    }

    @Test
    public void testBuyHouses() {
        Banker banker = new Banker();
        int houses = banker.getHouses();

        banker.buyHouses("Boardwalk");
        assertEquals(houses + 1, banker.getHouses());
    }

    @Test
    public void testSellHotel() {
        Banker banker = new Banker();
        int hotels = banker.getHotels();

        banker.sellHotel("Boardwalk");
        assertEquals(hotels - 1, banker.getHotels());
    }

    @Test
    public void testBuyHotels() {
        Banker banker = new Banker();
        int hotels = banker.getHotels();

        banker.buyHotels("Boardwalk");
        assertEquals(hotels + 1, banker.getHotels());
    }

    /**
    @Test
    public void testAuctionProperty() {
        Banker banker = new Banker();
        ArrayList<String> players = new ArrayList<>();
        players.add("Jim");
        players.add("Pat");
        players.add("Tom");
        players.add("Nia");

        banker.auctionProperty("Boardwalk", players);
    }
    */

//    @Test
//    public void testMortgageProperty() {
//        Banker banker = new Banker();
//        TitleDeedDeck deck = banker.getDeck();
//
//        assertFalse(deck.getTitleDeeds().getProperty("Boardwalk").isMortgaged());
//
//        banker.mortgageProperty("Boardwalk");
//        assertTrue(deck.getTitleDeeds().getProperty("Boardwalk").isMortgaged());
//    }

    @Test
    public void testPayGoSpace() {
        Banker banker = new Banker();
        HumanPlayer humanPlayer = new HumanPlayer("Bob", new Token("Thimble", "Thimble.png"));

        assertEquals(1500, humanPlayer.getBalance());
        assertEquals(Double.POSITIVE_INFINITY, banker.getBalance());

        banker.payGoSpace(humanPlayer);
        assertEquals(1700, humanPlayer.getBalance());
        assertEquals(Double.POSITIVE_INFINITY, banker.getBalance());
    }

    @Test
    public void testReceiveMoney() {
        Banker banker = new Banker();
        HumanPlayer humanPlayer = new HumanPlayer("Bob", new Token("Thimble", "Thimble.png"));

        assertEquals(1500, humanPlayer.getBalance());
        assertEquals(Double.POSITIVE_INFINITY, banker.getBalance());

        banker.receiveMoney(humanPlayer, 200);
        assertEquals(1300, humanPlayer.getBalance());
        assertEquals(Double.POSITIVE_INFINITY, banker.getBalance());
    }
}
