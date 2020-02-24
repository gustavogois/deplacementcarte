package fr.com.gfi.deplacementcarte.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JeuTest {
    Jeu jeu;
    Carte carte;

    @Before
    public void createJeuTest() {
        // todo: lombok, builder
        Coordonner taille = new Coordonner(2, 2);
        Coordonner depart = new Coordonner(0, 0);
        this.jeu = new Jeu(new Carte(taille), depart);
    }

    @Test
    public void departTest() {
        assertEquals(new Coordonner(0, 0), jeu.getDepart());
        assertEquals(new Coordonner(0, 0), jeu.getCourant());
    }
}
