package org.monopoly.Model.Cards;

import org.monopoly.Model.GameTiles.GameTile;
import java.util.*;

public class TitleDeedDeck {
    private ArrayList<GameTile> drawPile;
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

    public GameTile drawCard(String currentProperty) {
        GameTile property = properties.getProperty(currentProperty);

        if (!drawPile.contains(property)) {
            throw new NoSuchElementException("Property has already been purchased.");
        }

        this.drawPile.remove(property);

        return property;
    }

    public void returnCard(String currentProperty) {
        GameTile property = properties.getProperty(currentProperty);

        if (drawPile.contains(property)) {
            throw new IllegalArgumentException("Property is already in deck.");
        }

        this.drawPile.add(property);
    }

    public TitleDeedCards getTitleDeeds() {
        return this.properties;
    }

    public int getSize() {
        return this.drawPile.size();
    }
}
