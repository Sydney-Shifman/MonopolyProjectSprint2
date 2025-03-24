package org.monopoly.Controller;

import org.monopoly.Model.HumanPlayer;
import org.monopoly.Model.TitleDeedDeck;
import java.util.*;

public class Banker {
    private double balance;
    private TitleDeedDeck deck;
    private int houses;
    private int hotels;

    public Banker() {
        this.balance = Double.POSITIVE_INFINITY;
        this.deck = new TitleDeedDeck();
        this.houses = 32;
        this.hotels = 32;
    }

    //Add money and player component
    public void sellProperty(String propertyName) {
        deck.drawCard(propertyName);
    }

    public void sellHouse(String propertyName) {
        //Wait for houses to be added to PropertySpace.
        if (this.houses == 0) {
            throw new IllegalStateException("There are no houses left.");
        }
        else {
            this.houses -= 1;
        }
    }

    public void buyHouses(String propertyName) {
        //Linked to Player selling house?
        this.houses += 1;
    }

    public void sellHotel(String propertyName) {
        //Wait for hotels to be added to PropertySpace.
        if (this.hotels == 0) {
            throw new IllegalStateException("There are no hotels left.");
        }
        else {
            this.hotels -= 1;
        }
    }

    public void buyHotels(String propertyName) {
        //Linked to Player selling hotel?
        this.hotels += 1;
    }

    public void auctionProperty(String propertyName, ArrayList<String> players) {
        int currentBidAmount = deck.getTitleDeeds().getProperty(propertyName).getPrice();
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
        this.balance -= 200;
    }

    public void receiveMoney(HumanPlayer humanPlayerName, int money) {
        humanPlayerName.subtractFromBalance(money);
        this.balance += money;
    }

    public TitleDeedDeck getDeck() {
        return this.deck;
    }

    public int getHouses() {
        return this.houses;
    }

    public int getHotels() {
        return this.hotels;
    }

    public double getBalance() {
        return this.balance;
    }
}
