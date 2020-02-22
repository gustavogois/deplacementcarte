package fr.com.gfi.deplacementcarte.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameTest {
    Game game;
    Carte carte;

    @Test
    public void createGameTest() {
        Game game = new Game(new Carte(2, 2));

        assertNotNull(game);
    }
}
