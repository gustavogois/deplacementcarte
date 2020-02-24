package util;

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
        Coordonner newCoord = util.est(this.coordonner);

        assertEquals(1, this.coordonner.getX());
        assertEquals(2, this.coordonner.getY());
        assertTrue(newCoord != this.coordonner);
    }

    @Test
    public void est() {
        Coordonner newCoord = util.est(this.coordonner);

        assertEquals(2, newCoord. getX());
        assertEquals(2, newCoord. getY());
    }
}