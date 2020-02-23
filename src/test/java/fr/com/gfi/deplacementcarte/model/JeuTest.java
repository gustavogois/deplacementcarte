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
        this.jeu = new Jeu(new Carte(new Coordonner(2, 2)));
    }

    @Test
    public void positionDeDepartTest() {
        jeu.setPositionDeDepart(new Coordonner(0, 0));

        Coordonner coordPositionDeDepart = jeu.getPositionDeDepart();

        assertEquals(new Coordonner(0, 0), coordPositionDeDepart);
    }
}
