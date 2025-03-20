package org.monopoly.Model;

import java.util.*;

public class TitleDeedDeck {
    private ArrayList<PropertySpace> drawPile;
    private TitleDeedCards properties;

    public TitleDeedDeck() {
        this.drawPile = new ArrayList<>();
        this.properties = new TitleDeedCards();
        initializeDeck();
    }

    private void initializeDeck() {
        for (String propertyName : properties.getProperties().keySet()) {
            drawPile.add(properties.getProperties().get(propertyName));
        }
    }

    public PropertySpace drawCard(String currentProperty) {
        PropertySpace property = properties.getProperty(currentProperty);

        if (!drawPile.contains(property)) {
            throw new NoSuchElementException("Property has already been purchased.");
        }

        this.drawPile.remove(property);

        return property;
    }

    public void returnCard(String currentProperty) {
        PropertySpace property = properties.getProperty(currentProperty);

        if (drawPile.contains(property)) {
            throw new IllegalArgumentException("Property is already in deck.");
        }

        this.drawPile.add(property);
    }

    public TitleDeedCards getTitleDeeds() {
        return this.properties;
    }

    //Need to add all methods and attributes to propertySpace.
    /**
    public String displayCardInfo(String currentProperty) {
        PropertySpace property = properties.getProperty(currentProperty);

        return "\nProperty Name: " + property.getName() +
                "\nColor Group: " + property.getColorGroup() +
                "\nPurchase Price: $" + property.getPrice() +
                "\nRent (without houses/hotels): $" + property.getRent() +
                "\nRent with 1 House: $" + property.getRent() + //Create Array for Rent
                "\nRent with 2 Houses: $" + property.getRent() +
                "\nRent with 3 Houses: $" + property.getRent() +
                "\nRent with 4 Houses: $" + property.getRent() +
                "\nRent with Hotel: $" + property.getRent() +
                "\nMortgage Value: $" +
                "\nHouses: " +
                "\nHotel: ";
    }
    */

    public int getSize() {
        return this.drawPile.size();
    }
}
