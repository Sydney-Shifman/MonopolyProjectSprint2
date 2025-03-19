package org.monopoly.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        assertEquals("John Doe", player.getName());
        assertEquals(1500, player.getBalance());
        assertEquals(0, player.getPosition());
    }

    @Test
    public void testPlayerBalance() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.addToBalance(2000);
        assertEquals(3500, player.getBalance());
    }

    @Test
    public void testPlayerName() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        assertEquals("John Doe", player.getName());
    }

    @Test
    public void testPlayerSetPosition() {
        Player player = new Player("John Doe", new Token( "John Doe","BattleShip.png"));
        player.setPosition(5);
        assertEquals(5, player.getPosition());
    }
}
