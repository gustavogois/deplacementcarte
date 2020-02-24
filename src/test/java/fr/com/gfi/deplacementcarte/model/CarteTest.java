package fr.com.gfi.deplacementcarte.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarteTest {

    Carte carte;
    Carte carteFichier;

    @Before
    public void before() {
        carte = new Carte(new Coordonner(2, 2), ' ');
        carteFichier = new Carte("carte.txt");
    }

    @Test
    public void getPointTest() {
        carte.setPoint(new Coordonner(0, 1), '#');

        int point = carte.getPoint(new Coordonner(0, 1));

        assertEquals('#', point);
    }

    @Test
    public void constructeurRemplirAvecTest() {
        char[][] points = this.carte.getPoints();
        // todo use lambda to assert
        for (int ligne = 0 ; ligne < points.length ; ligne++) {
            for (int collone = 0 ; collone < points[ligne].length ; collone++) {
                assertEquals(' ', points[ligne][collone]);
            }
        }
    }

    @Test
    public void carteFichierTest() {
        assertNotNull(carteFichier.getPoints());
    }
}