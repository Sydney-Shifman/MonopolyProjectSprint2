package org.monopoly.Model.Cards;

import org.monopoly.Model.GameTiles.PropertySpace;

import java.util.HashMap;

public class TitleDeedCards {
    private HashMap<String, PropertySpace> properties;

    public TitleDeedCards() {
        this.properties = new HashMap<>();
        initializeCards();
    }

    private void initializeCards() {
        properties.put("Mediterranean Avenue", new PropertySpace("Mediterranean Avenue", "Brown", 20, 10, "Brown"));
        properties.put("Baltic Avenue", new PropertySpace("Baltic Avenue", "Brown", 30, 15, "Brown"));

        properties.put("Oriental Avenue", new PropertySpace("Oriental Avenue", "Light Blue", 50, 25, "Light Blue"));
        properties.put("Vermont Avenue", new PropertySpace("Vermont Avenue", "Light Blue", 50, 25, "Light Blue"));
        properties.put("Connecticut Avenue", new PropertySpace("Connecticut Avenue", "Light Blue", 60, 30, "Light Blue"));

        properties.put("St. Charles Place", new PropertySpace("St. Charles Place", "Pink", 70, 35, "Pink"));
        properties.put("States Avenue", new PropertySpace("States Avenue", "Pink", 70, 35, "Pink"));
        properties.put("Virginia Avenue", new PropertySpace("Virginia Avenue", "Pink", 80, 40, "Pink"));

        properties.put("St. James Place", new PropertySpace("St. James Place", "Orange", 90, 45,"Orange"));
        properties.put("Tennessee Avenue", new PropertySpace("Tennessee Avenue", "Orange", 90, 45,"Orange"));
        properties.put("New York Avenue", new PropertySpace("New York Avenue", "Orange", 100, 50, "Orange"));

        properties.put("Kentucky Avenue", new PropertySpace("Kentucky Avenue", "Red", 120, 60, "Red"));
        properties.put("Indiana Avenue", new PropertySpace("Indiana Avenue", "Red", 120, 60, "Red"));
        properties.put("Illinois Avenue", new PropertySpace("Illinois Avenue", "Red", 140, 70, "Red"));

        properties.put("Atlantic Avenue", new PropertySpace("Atlantic Avenue", "Yellow", 150, 75, "Yellow"));
        properties.put("Ventnor Avenue", new PropertySpace("Ventnor Avenue", "Yellow", 150, 75, "Yellow"));
        properties.put("Marvin Gardens", new PropertySpace("Marvin Gardens", "Yellow", 160, 80, "Yellow"));

        properties.put("Pacific Avenue", new PropertySpace("Pacific Avenue", "Green", 200, 100, "Green"));
        properties.put("North Carolina Avenue", new PropertySpace("North Carolina Avenue", "Green", 200, 100, "Green"));
        properties.put("Pennsylvania Avenue", new PropertySpace("Pennsylvania Avenue", "Green", 220, 110, "Green"));

        properties.put("Park Place", new PropertySpace("Park Place", "Dark Blue", 350, 175, "Dark Blue"));
        properties.put("Boardwalk", new PropertySpace("Boardwalk", "Dark Blue", 400, 200, "Dark Blue"));

        properties.put("Reading Railroad", new PropertySpace("Reading Railroad", "Railroad", 200, 100, "Railroad"));
        properties.put("Pennsylvania Railroad", new PropertySpace("Pennsylvania Railroad", "Railroad", 200, 100, "Railroad"));
        properties.put("B&O Railroad", new PropertySpace("B&O Railroad", "Railroad", 200, 100, "Railroad"));
        properties.put("Short Line", new PropertySpace("Short Line", "Railroad", 200, 100, "Railroad"));

        properties.put("Electric Company", new PropertySpace("Electric Company", "Utility", 150, 75, "Utility"));
        properties.put("Water Works", new PropertySpace("Water Works", "Utility", 150, 75, "Utility"));
    }

    public HashMap<String, PropertySpace> getProperties() {
        return this.properties;
    }

    public PropertySpace getProperty(String propertyName) {
        return this.properties.get(propertyName);
    }
}
