package org.monopoly.Model.Cards;

import org.monopoly.Model.GameTiles.*;
import java.util.*;

public class TitleDeedCards {
    private HashMap<String, GameTile> properties;

    public TitleDeedCards() {
        this.properties = new HashMap<>();
        initializeCards();
    }

    private void initializeCards() {
        ArrayList<Integer> rentPrice = new ArrayList<>();

        setPropertyRentPrices(rentPrice, 2, 10, 30, 90, 160, 250);
        properties.put("Mediterranean Avenue", new PropertySpace("Mediterranean Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 60, rentPrice, ColorGroup.BROWN, 50, 50, 30));
        setPropertyRentPrices(rentPrice, 4, 20, 60, 180, 320, 450);
        properties.put("Baltic Avenue", new PropertySpace("Baltic Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 60, rentPrice, ColorGroup.BROWN, 50, 50, 30));

        setPropertyRentPrices(rentPrice, 6, 30, 90, 270, 400, 550);
        properties.put("Oriental Avenue", new PropertySpace("Oriental Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 100, rentPrice, ColorGroup.LIGHT_BLUE, 50, 50, 50));
        setPropertyRentPrices(rentPrice, 6, 30, 90, 270, 400, 550);
        properties.put("Vermont Avenue", new PropertySpace("Vermont Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 100, rentPrice, ColorGroup.LIGHT_BLUE, 50, 50, 50));
        setPropertyRentPrices(rentPrice, 8, 40, 100, 300, 450, 600);
        properties.put("Connecticut Avenue", new PropertySpace("Connecticut Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 120, rentPrice, ColorGroup.LIGHT_BLUE, 50, 50, 60));

        setPropertyRentPrices(rentPrice, 10, 50, 150, 450, 625, 750);
        properties.put("St. Charles Place", new PropertySpace("St. Charles Place", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 140, rentPrice, ColorGroup.PINK, 100, 100, 70));
        setPropertyRentPrices(rentPrice, 10, 50, 150, 450, 625, 750);
        properties.put("States Avenue", new PropertySpace("States Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 140, rentPrice, ColorGroup.PINK, 100, 100, 70));
        setPropertyRentPrices(rentPrice, 12, 60, 180, 500, 700, 900);
        properties.put("Virginia Avenue", new PropertySpace("Virginia Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 160, rentPrice, ColorGroup.PINK, 100, 100, 80));

        setPropertyRentPrices(rentPrice, 14, 70, 200, 550, 750, 950);
        properties.put("St. James Place", new PropertySpace("St. James Place", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 180, rentPrice, ColorGroup.ORANGE, 100, 100, 90));
        setPropertyRentPrices(rentPrice, 14, 70, 200, 550, 750, 950);
        properties.put("Tennessee Avenue", new PropertySpace("Tennessee Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 180, rentPrice, ColorGroup.ORANGE, 100, 100, 90));
        setPropertyRentPrices(rentPrice, 16, 80, 220, 600, 800, 1000);
        properties.put("New York Avenue", new PropertySpace("New York Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 200, rentPrice, ColorGroup.ORANGE, 100, 100, 100));

        setPropertyRentPrices(rentPrice, 18, 90, 250, 700, 875, 1050);
        properties.put("Kentucky Avenue", new PropertySpace("Kentucky Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 220, rentPrice, ColorGroup.RED, 150, 150, 110));
        setPropertyRentPrices(rentPrice, 18, 90, 250, 700, 875, 1050);
        properties.put("Indiana Avenue", new PropertySpace("Indiana Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 220, rentPrice, ColorGroup.RED, 150, 150, 110));
        setPropertyRentPrices(rentPrice, 20, 100, 300, 750, 925, 1100);
        properties.put("Illinois Avenue", new PropertySpace("Illinois Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 240, rentPrice, ColorGroup.RED, 150, 150, 120));

        setPropertyRentPrices(rentPrice, 22, 110, 330, 800, 975, 1150);
        properties.put("Atlantic Avenue", new PropertySpace("Atlantic Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 260, rentPrice, ColorGroup.YELLOW, 150, 150, 130));
        setPropertyRentPrices(rentPrice, 22, 110, 330, 800, 975, 1150);
        properties.put("Ventnor Avenue", new PropertySpace("Ventnor Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 260, rentPrice, ColorGroup.YELLOW, 150, 150, 130));
        setPropertyRentPrices(rentPrice, 24, 120, 360, 850, 1025, 1200);
        properties.put("Marvin Gardens", new PropertySpace("Marvin Gardens", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 280, rentPrice, ColorGroup.YELLOW, 150, 150, 140));

        setPropertyRentPrices(rentPrice, 26, 130, 390, 900, 1100, 1275);
        properties.put("Pacific Avenue", new PropertySpace("Pacific Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 300, rentPrice, ColorGroup.GREEN, 200, 200, 150));
        setPropertyRentPrices(rentPrice, 26, 130, 390, 900, 1100, 1275);
        properties.put("North Carolina Avenue", new PropertySpace("North Carolina Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 300, rentPrice, ColorGroup.GREEN, 200, 200, 150));
        setPropertyRentPrices(rentPrice, 28, 150, 450, 1000, 1200, 1400);
        properties.put("Pennsylvania Avenue", new PropertySpace("Pennsylvania Avenue", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 320, rentPrice, ColorGroup.GREEN, 200, 200, 160));

        setPropertyRentPrices(rentPrice, 35, 175, 500, 1100, 1300, 1500);
        properties.put("Park Place", new PropertySpace("Park Place", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 350, rentPrice, ColorGroup.DARK_BLUE, 200, 200, 175));
        setPropertyRentPrices(rentPrice, 50, 200, 600, 1400, 1700, 2000);
        properties.put("Boardwalk", new PropertySpace("Boardwalk", "Buy Property, Pay Rent, Buy Houses/Hotel, Mortgage", 400, rentPrice, ColorGroup.DARK_BLUE, 200, 200, 200));

        setRailroadRentPrices(rentPrice);
        properties.put("Reading Railroad", new RailroadSpace());
        setRailroadRentPrices(rentPrice);
        properties.put("Pennsylvania Railroad", new RailroadSpace());
        setRailroadRentPrices(rentPrice);
        properties.put("B&O Railroad", new RailroadSpace());
        setRailroadRentPrices(rentPrice);
        properties.put("Short Line Railroad", new RailroadSpace());

        setUtilitiesRentPriceMultiplier(rentPrice);
        properties.put("Electric Company", new ElectricCompanySpace());
        setUtilitiesRentPriceMultiplier(rentPrice);
        properties.put("Water Works", new WaterWorksSpace());
    }

    private void setPropertyRentPrices(ArrayList<Integer> rentPrices, int basicRent, int oneHouseRent, int twoHouseRent, int threeHouseRent, int fourHouseRent, int hotelRent) {
        rentPrices.clear();


        rentPrices.add(basicRent);
        rentPrices.add(oneHouseRent);
        rentPrices.add(twoHouseRent);
        rentPrices.add(threeHouseRent);
        rentPrices.add(fourHouseRent);
        rentPrices.add(hotelRent);
    }

    private void setRailroadRentPrices(ArrayList<Integer> rentPrices) {
        rentPrices.clear();

        rentPrices.add(25); // Rent for 1 Railroad
        rentPrices.add(50);
        rentPrices.add(100);
        rentPrices.add(200);
    }

    private void setUtilitiesRentPriceMultiplier(ArrayList<Integer> rentPrices) {
        rentPrices.clear();

        rentPrices.add(4); // Rent multiplier for 1 owned utility
        rentPrices.add(10);
    }

    public HashMap<String, GameTile> getProperties() {
        return this.properties;
    }

    public GameTile getProperty(String propertyName) {
        return this.properties.get(propertyName);
    }
}
