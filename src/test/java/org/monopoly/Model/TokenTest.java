package org.monopoly.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TokenTest {
    private Token token;
    private Player player;

    @BeforeEach
    void setUp() {
        token = new Token("Top hat", "TokenPNGs/TopHat.png");
        player = new Player("Alice", token);
    }

    @Test
    void testTokenCreation() {
        assertEquals("Top hat", token.getName(), "Token name should be 'Top hat'.");
        assertEquals("TokenPNGs/TopHat.png", token.getIcon(), "Token icon should match.");
    }

    @Test
    void testTokenOwner() {
        assertEquals(player, token.getOwner(), "Token owner should be Alice.");
        assertEquals("Alice", token.getOwner().getName(), "Token owner's name should be Alice.");
    }

    @Test
    void testPlayerToken() {
        System.out.println("Player: " + player);
        System.out.println("Player's token: " + player.getToken());
        System.out.println("Token: " + token);
        assertEquals(token, player.getToken(), "Player's token should be the Top hat.");
    }
}