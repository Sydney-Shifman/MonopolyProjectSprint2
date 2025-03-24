package org.monopoly.View;

import org.monopoly.Model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Monopoly!");

        // Create a new game board
        GameBoard gameBoard = new GameBoard();

        // Demonstrate the game board functionality
        for (int i = 0; i < 40; i++) {
            GameTile gameTile = gameBoard.getTile(i);
            System.out.println(gameTile.getName() + " does: " + gameTile.landOn() + "\n");
        }

        // Demonstrate chance cards works via board
        System.out.println("Chance Cards:");
        for (int i = 0; i < 16; i++) {
            System.out.println(gameBoard.drawChanceCard());
        }
        System.out.println();

        System.out.println("Reshuffled Chance Cards and draw the deck again:");
        for (int i = 0; i < 16; i++) {
            System.out.println(gameBoard.drawChanceCard());
        }


        // Demonstrate community chest cards works via board
        ArrayList<String> commChestCards = new ArrayList<>();

        System.out.println("Community Chest Cards:");
        for (int i = 0; i < 16; i++) {
            String commChestCard = gameBoard.drawCommunityChestCard();
            commChestCards.add(commChestCard);
            System.out.println(commChestCard);
        }
        System.out.println("\nThis should be empty now:");
        System.out.println(gameBoard.drawCommunityChestCard());

        // Demonstrate the reshuffle of community chest cards
        for (String card : commChestCards) {
            gameBoard.returnCommunityChestCard(card);
        }
        System.out.println("\nReshuffled Community Chest Cards:");
        for (int i = 0; i < 16; i++) {
            System.out.println(gameBoard.drawCommunityChestCard());
        }

        // Demonstrate the Dice class words.
        System.out.println("Dice Functionality:");
        HumanPlayer humanPlayer = new HumanPlayer("Alice", new Token("Thimble", "Thimble.png"));
        Dice dice = new Dice();

        for (int i = 0; i < 20; i++) {
            humanPlayer.takeTurn(dice);
        }
    }
}
