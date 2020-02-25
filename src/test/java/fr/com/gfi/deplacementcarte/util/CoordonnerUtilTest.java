package fr.com.gfi.deplacementcarte.util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordonnerUtilTest {

    CoordonnerUtil util;
    Coordonner coordonner;

    @Before
    public void setUp() throws Exception {
        this.util = new CoordonnerUtil();
        this.coordonner = new Coordonner(1, 2);
    }

    @Test
    public void immuabiliteEstTest() {
        Coordonner newCoord = util.deplacement(this.coordonner, Carte.EST);

        assertEquals(1, this.coordonner.getX());
        assertEquals(2, this.coordonner.getY());
        assertTrue(newCoord != this.coordonner);
    }

    @Test
    public void estTest() {
        Coordonner newCoord = util.deplacement(this.coordonner, Carte.EST);

        assertEquals(2, newCoord. getX());
        assertEquals(2, newCoord. getY());
    }

    @Test
    public void sudTest() {
        Coordonner newCoord = util.deplacement(this.coordonner, Carte.SUD);

        assertEquals(1, newCoord. getX());
        assertEquals(3, newCoord. getY());
    }

    @Test
    public void nordTest() {
        Coordonner newCoord = util.deplacement(this.coordonner, Carte.NORD);

        assertEquals(1, newCoord. getX());
        assertEquals(1, newCoord. getY());
    }

    @Test
    public void OuestTest() {
        Coordonner newCoord = util.deplacement(this.coordonner, Carte.OUEST);

        assertEquals(0, newCoord. getX());
        assertEquals(2, newCoord. getY());
    }
}