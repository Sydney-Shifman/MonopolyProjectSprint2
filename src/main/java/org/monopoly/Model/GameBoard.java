package org.monopoly.Model;

import org.monopoly.Model.Cards.ChanceDeck;
import org.monopoly.Model.Cards.CommunityChestDeck;
import org.monopoly.Model.GameTiles.*;
import org.monopoly.Model.Players.Player;

import java.util.*;


/**
 * @author crevelings
 * This class represents the gameboard for the game.
 *
 */
public class GameBoard {
    private List<GameTile> tiles;
    private CommunityChestDeck communityChestDeck;
    private ChanceDeck chanceDeck;

    /**
     * Constructs a GameSpace object
     */
    public GameBoard() {
        this.tiles = new ArrayList<>();
        this.communityChestDeck = new CommunityChestDeck();
        this.chanceDeck = new ChanceDeck();
        initializeBoard();
    }

    /**
     * Initializes the Monopoly GameBoard with all 40 spaces (including Chance and Community Chest Spaces)
     */
    private void initializeBoard() {
        tiles.add(new GoSpace());
        tiles.add(new PropertySpace("Mediterranean Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 60, 2, "Brown"));
        tiles.add(new CommunityChestSpace(communityChestDeck));
        tiles.add(new PropertySpace("Baltic Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 60, 4, "Brown"));
        tiles.add(new IncomeTaxSpace());
        tiles.add(new RailroadSpace());
        tiles.add(new PropertySpace("Oriental Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 100, 6, "Light Blue"));
        tiles.add(new ChanceSpace(chanceDeck));
        tiles.add(new PropertySpace("Vermont Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 100, 6, "Light Blue"));
        tiles.add(new PropertySpace("Connecticut Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 120, 8, "Light Blue"));
        tiles.add(new JailSpace());
        tiles.add(new PropertySpace("St. Charles Place", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 140, 10, "Pink"));
        tiles.add(new ElectricCompanySpace());
        tiles.add(new PropertySpace("States Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 140, 10, "Pink"));
        tiles.add(new PropertySpace("Virginia Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 160, 12, "Pink"));
        tiles.add(new RailroadSpace());
        tiles.add(new PropertySpace("St. James Place", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 180, 14, "Orange"));
        tiles.add(new CommunityChestSpace(communityChestDeck));
        tiles.add(new PropertySpace("Tennessee Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 200, 16, "Orange"));
        tiles.add(new PropertySpace("New York Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage",200, 16, "Orange"));
        tiles.add(new FreeParkingSpace());
        tiles.add(new PropertySpace("Kentucky Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 220, 18, "Red"));
        tiles.add(new ChanceSpace(chanceDeck));
        tiles.add(new PropertySpace("Indiana Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 240, 20, "Red"));
        tiles.add(new PropertySpace("Illinois Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 260, 22, "Red"));
        tiles.add(new RailroadSpace());
        tiles.add(new PropertySpace("Atlantic Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 280, 24, "Yellow"));
        tiles.add(new PropertySpace("Ventnor Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 300, 26, "Yellow"));
        tiles.add(new WaterWorksSpace());
        tiles.add(new PropertySpace("Marvin Gardens", "Buy Property, Pay rent, Buy Houses/Hotel, Mortgage", 280, 24, "Yellow"));
        tiles.add(new GoToJailSpace());
        tiles.add(new PropertySpace("Pacific Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 300, 26, "Green"));
        tiles.add(new PropertySpace("North Carolina Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 300, 26, "Green"));
        tiles.add(new CommunityChestSpace(communityChestDeck));
        tiles.add(new PropertySpace("Pennsylvania Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 320, 28, "Green"));
        tiles.add(new RailroadSpace());
        tiles.add(new ChanceSpace(chanceDeck));
        tiles.add(new PropertySpace("Park Place", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 350, 35, "Blue"));
        tiles.add(new LuxuryTaxSpace());
        tiles.add(new PropertySpace("Boardwalk", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 400, 50, "Blue"));
    }

    /**
     * Gets the game tile at the specified position.
     * @param position The position of the tile.
     * @return The game tile at the specified position.
     */
    public GameTile getTile(int position) {
        if (position >= 0 && position < tiles.size()) {
            return tiles.get(position);
        }
        throw new IllegalArgumentException("Invalid tile position: " + position);
    }

    /**
     * Draws a card from the Community Chest deck.
     * @return The card drawn from the Community Chest deck.
     */
    public String drawCommunityChestCard() {
        return communityChestDeck.drawCard();
    }

    public void returnCommunityChestCard(String card) {
        communityChestDeck.returnCardToDeck(card);
    }
    /**
     * Draws a card from the Chance deck.
     * @return The card drawn from the Chance deck.
     */
    public String drawChanceCard() {
        return chanceDeck.drawCard();
    }

    public int getNumberOfTiles() {
        return tiles.size();
    }

    /**
     * Executes a strategy of specified type for a player.
     * @param player The player to execute the strategy for.
     * @param type The type of strategy to execute. (i.e. "tile", "community:card", "chance:card")
     */
    public void executeStrategyType(Player player, String type) {
        if (Objects.equals(type, "tile")) {
            GameTile currTile = tiles.get(player.getPosition());
            if (currTile instanceof ChanceSpace) {
                chanceDeck.executeStrategy(player, drawChanceCard());
            } else if (currTile instanceof CommunityChestSpace) {
                communityChestDeck.executeStrategy(player, drawCommunityChestCard());
            } else {
//            currTile.executeStrategy(player);
            }
        } else if (type.contains("community:")){ // player uses get out of jail card
            String card = type.split(":")[1];
            communityChestDeck.executeStrategy(player, card);
        } else if (type.contains("chance:")) { // player uses get out of jail card
            String card = type.split(":")[1];
            chanceDeck.executeStrategy(player, card);
        }
    }
}