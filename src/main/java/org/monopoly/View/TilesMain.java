package org.monopoly.View;

import org.monopoly.Exceptions.*;
import org.monopoly.Model.Cards.*;
import org.monopoly.Model.GameBoard;
import org.monopoly.Model.GameTiles.*;
import org.monopoly.Model.Players.*;

import java.util.ArrayList;

import static org.monopoly.Model.Cards.ColorGroup.*;

public class TilesMain {

    public static void main(String[] args) throws InsufficientFundsException {
        Token token = new Token("Thimble", "TokensPNGs/Thimble.png");
        HumanPlayer player = new HumanPlayer("Test Player", token);
        player.addToBalance(1000000000);
        GameBoard gameBoard = new GameBoard();

        for (int i = 0; i< 40; i++) {
            player.setPosition(i);
            gameBoard.executeStrategyType(player, "tile");
        }
    }
}