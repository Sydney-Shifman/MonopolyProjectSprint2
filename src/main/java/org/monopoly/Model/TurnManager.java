package org.monopoly.Model;

import org.monopoly.Model.Players.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages the turns of the players in the game.
 * Keeps track of the current player and the order of the players.
 * @author walshj05
 */
public class TurnManager {
    private int currentPlayerIndex;
    private final HashMap<Integer, Player> players;
    private int numPlayers;

    public TurnManager(int numPlayers, ArrayList<Player> players) {
        this.numPlayers = numPlayers;
        this.currentPlayerIndex = 0;
        this.players = new HashMap<>();
        for (int i = 0; i < numPlayers; i++) {
            this.players.put(i, players.get(i));
        }
    }

    /**
     * Continues to the next player in the turn order.
     */
    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
    }

    /**
     * Gets the current player
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void removePlayer(Player player) {
        for (int i = 0; i < numPlayers; i++) {
            if (players.get(i) == player) {
                players.remove(i);
                break;
            }
        }
        numPlayers--;
    }
}
