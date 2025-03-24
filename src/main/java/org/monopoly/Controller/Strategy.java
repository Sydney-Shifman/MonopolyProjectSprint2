package org.monopoly.Controller;

import org.monopoly.Model.Players.HumanPlayer;

/**
 * Strategy interface for implementing different player strategies in the Monopoly game.
 * @author walshj05
 */
public interface Strategy {
    /**
     * Executes the strategy for the given player.
     * @param humanPlayer The player to execute the strategy for.
     */
    void executeStrategy(HumanPlayer humanPlayer);
}
