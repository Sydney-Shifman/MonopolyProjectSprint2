package org.monopoly.Controller;

import org.monopoly.Model.Player;

/**
 * Strategy interface for implementing different player strategies in the Monopoly game.
 * @author walshj05
 */
public interface Strategy {
    /**
     * Executes the strategy for the given player.
     * @param player The player to execute the strategy for.
     */
    void executeStrategy(Player player);
}
