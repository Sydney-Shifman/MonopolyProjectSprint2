package org.monopoly.Model;

import org.monopoly.Model.GameTiles.PropertySpace;
import org.monopoly.Model.Players.HumanPlayer;
import org.monopoly.Model.Cards.TitleDeedDeck;
import java.util.*;

public class Banker {
    private double bankBalance;
    private TitleDeedDeck deck;
    private int numHouses;
    private int numHotels;

    public Banker() {
        this.bankBalance = Double.POSITIVE_INFINITY;
        this.deck = new TitleDeedDeck();
        this.numHouses = 32;
        this.numHotels = 32;
    }

    //Add money and player component
    public void sellProperty(String propertyName) {
        //Mortgaged properties can be sold at an agreed upon price.
        deck.drawCard(propertyName);
    }

    public void sellHouse(String propertyName) {
        if (deck.getTitleDeeds().getProperty(propertyName) instanceof PropertySpace) {
            if (this.numHouses == 0) {
                throw new IllegalStateException("There are no houses left.");
            }
            else {
                this.numHouses -= 1;

                int numPropertyHouses = ((PropertySpace) deck.getTitleDeeds().getProperty(propertyName)).getNumHouses();
                ((PropertySpace) deck.getTitleDeeds().getProperty(propertyName)).setNumHouses(numPropertyHouses+1);
            }
        }

        else {
            throw new IllegalArgumentException("This property does not have houses.");
        }
    }

    public void buyHouses(String propertyName) {
        if (deck.getTitleDeeds().getProperty(propertyName) instanceof PropertySpace) {
            if (this.numHouses == 0) {
                throw new IllegalStateException("There are no houses left.");
            }
            else {
                this.numHouses += 1;

                int numPropertyHouses = ((PropertySpace) deck.getTitleDeeds().getProperty(propertyName)).getNumHouses();
                ((PropertySpace) deck.getTitleDeeds().getProperty(propertyName)).setNumHouses(numPropertyHouses-1);
            }
        }

        else {
            throw new IllegalArgumentException("This property does not have houses.");
        }
    }

    public void sellHotel(String propertyName) {
        if (deck.getTitleDeeds().getProperty(propertyName) instanceof PropertySpace) {
            if (this.numHotels == 0) {
                throw new IllegalStateException("There are no hotels left.");
            }
            else {
                this.numHotels -= 1;

                int numPropertyHotels = ((PropertySpace) deck.getTitleDeeds().getProperty(propertyName)).getNumHotels();
                ((PropertySpace) deck.getTitleDeeds().getProperty(propertyName)).setNumHotels(numPropertyHotels+1);
            }
        }

        else {
            throw new IllegalArgumentException("This property does not have hotels.");
        }
    }

    public void buyHotels(String propertyName) {
        if (deck.getTitleDeeds().getProperty(propertyName) instanceof PropertySpace) {
            if (this.numHotels == 0) {
                throw new IllegalStateException("There are no hotels left.");
            }
            else {
                this.numHotels += 1;

                int numPropertyHotels = ((PropertySpace) deck.getTitleDeeds().getProperty(propertyName)).getNumHotels();
                ((PropertySpace) deck.getTitleDeeds().getProperty(propertyName)).setNumHotels(numPropertyHotels-1);
            }
        }

        else {
            throw new IllegalArgumentException("This property does not have hotels.");
        }
    }

    public void auctionProperty(String propertyName, ArrayList<String> players) {
        int currentBidAmount = 1;
        HashMap<String, Integer> currentBidding = new HashMap<>();
        String currentHighestBidder;
        int numRounds = 1;

        while (true) {
            if (numRounds == 1) {
                System.out.println("Starting Bid for " + propertyName + " starting at $" + currentBidAmount);
            }
            else {
                System.out.println("Round " + numRounds + ", the bid now starts at $" + currentBidAmount);
            }

            ArrayList<String> bidders = getCurrentBidders(players);
            ArrayList<Integer> bidAmounts = getBidAmount(currentBidAmount, bidders);

            /*
            if ((numRounds == 1) && (bidders.isEmpty())) {
                //Return property to pile and get rid of ownership
            }
             */

            if (bidders.size() <= 1) {
                endAuction(propertyName, bidders, bidAmounts);
                break;
            }

            System.out.println(bidders);
            System.out.println(bidAmounts);

            for (int i = 0; i < bidders.size(); i++) {
                currentBidding.put(bidders.get(i), bidAmounts.get(i));
            }
            System.out.println(currentBidding);

            currentHighestBidder = getHighestBidder(currentBidding);
            System.out.println(currentHighestBidder);

            currentBidAmount = currentBidding.get(currentHighestBidder);
            System.out.println(currentBidAmount);

            numRounds++;
        }
    }

    private void endAuction(String propertyName, ArrayList<String> bidders, ArrayList<Integer> bidAmounts) {
        //Subtract bid amount from winning player.
        //Make winning player the new owner.
        System.out.println("The Auction for " + propertyName + " ended!");
        System.out.println("Winner: " + bidders.getFirst());
        System.out.println("Bid Amount: " + bidAmounts.getFirst());
    }

    //Add timer to countdown the time for response.
    private ArrayList<String> getCurrentBidders(ArrayList<String> players) {
        ArrayList<String> bidders = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        //Only asks players who have enough money to bid.
        for (String player:players) {
            System.out.println(player + " do you want to bid on this property (Y/N)? ");
            char answer = keyboard.next().charAt(0);

            while ((answer != 'Y') && (answer != 'y') && (answer != 'N') && (answer != 'n')) {
                System.out.println("Invalid response, " + player + " do you want to bid on this property (Y/N)? ");
                answer = keyboard.next().charAt(0);
            }

            if ((answer == 'Y') || (answer == 'y')) {
                bidders.add(player);
            }
        }
        return bidders;
    }

    private ArrayList<Integer> getBidAmount(int currentBid, ArrayList<String> bidders) {
        ArrayList<Integer> bidAmounts = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        for (String bidder:bidders) {
            System.out.println(bidder + " how much do you want to bid? ");
            int answer = keyboard.nextInt();

            while (answer <= currentBid) {
                System.out.println("Invalid response, " + bidder + " how much do you want to bid? ");
                answer = keyboard.nextInt();
            }

            bidAmounts.add(answer);
        }

        return bidAmounts;
    }

    private String getHighestBidder(HashMap<String, Integer> currentBidding) {
        int bid = 0;
        String highestBidder = "";

        for (String bidder: currentBidding.keySet()) {
            if (currentBidding.get(bidder) > bid) {
                bid = currentBidding.get(bidder);
                highestBidder = bidder;
            }
        }

        return highestBidder;
    }

    public void mortgageProperty(String propertyName) {
        deck.getTitleDeeds().getProperties().get(propertyName).setMortgagedStatus(true);
    }

    public void payGoSpace(HumanPlayer humanPlayerName) {
        humanPlayerName.addToBalance(200);
        this.bankBalance -= 200;
    }

    public void receiveMoney(HumanPlayer humanPlayerName, int money) {
        humanPlayerName.subtractFromBalance(money);
        this.bankBalance += money;
    }

    public TitleDeedDeck getDeck() {
        return this.deck;
    }

    public int getHouses() {
        return this.numHouses;
    }

    public int getHotels() {
        return this.numHotels;
    }

    public double getBalance() {
        return this.bankBalance;
    }
}
