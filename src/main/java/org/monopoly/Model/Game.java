package org.monopoly.Model;

import org.monopoly.Controller.Banker;
import org.monopoly.Model.Players.HumanPlayer;
import org.monopoly.Model.Players.Player;
import org.monopoly.Model.Players.Token;

import java.util.ArrayList;

/**
 * Represents the game logic and state for a game of Monopoly
 * @author walshj05
 */
public class Game {
    private Banker banker;
    private GameBoard gameBoard;
    private TurnManager turnManager;
    private Dice dice;

    public Game(int numHumanPlayers, Token[] playerTokens) {
        if (numHumanPlayers < 2 || numHumanPlayers > 4) {
            throw new IllegalArgumentException("Invalid number of players");
        }
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numHumanPlayers; i++) {
            players.add(new HumanPlayer("Player" + (i + 1), playerTokens[i]));
        }

        this.banker = new Banker();
        this.gameBoard = new GameBoard();
        this.turnManager = new TurnManager(numHumanPlayers, players);
        this.dice = new Dice();
    }

    /**
     * Allows the current player to take their turn
     */
    public void playerTakeTurn(){
        int doublesNeeded = 0;
        Player currentPlayer = turnManager.getCurrentPlayer();

        // Check to see if a player is in jail
        if (currentPlayer.isInJail()){
            jailTurnLogic(currentPlayer);
            if (currentPlayer.isInJail()){
                doublesNeeded = 1; // passes the base turn logic
            } else {
                Dice.resetNumDoubles(); // allows base turn logic
            }
        }

        // Player takes standard turn
        while (Dice.getNumDoubles() == doublesNeeded && Dice.getNumDoubles() < 3) {
            currentPlayer.takeTurn(dice);
            int pos = currentPlayer.getPosition();
//            gameBoard.getTile(pos).executeStrategy(currentPlayer)
            if (dice.isDouble()) {
                Dice.incrementNumDoubles();
            }
            doublesNeeded++;
        }
        Dice.resetNumDoubles();
        turnManager.nextPlayer();
    }

    /**
     * Logic for a player's turn while in jail
     * @param player Player object
     */
    public void jailTurnLogic(Player player){
        if (player.getJailTurns() == 3){
            player.releaseFromJail();
        } else {
            dice.roll();
            if (dice.isDouble()){
                player.releaseFromJail();
            } else {
                player.incrementJailTurns();
            }
        }
    }

    /**
     * Removes a player from the game.
     * @param player Player object
     */
    public void removePlayer(Player player){
        turnManager.removePlayer(player);
    }
}
