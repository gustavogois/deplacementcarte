package fr.com.gfi.deplacementcarte.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class JeuTest {
    Jeu jeu;
    Carte carte;

    @Test
    public void createGameTest() {
        // todo: lombok, builder
        Jeu jeu = new Jeu(new Carte(2, 2));

        assertNotNull(jeu);
    }
}
