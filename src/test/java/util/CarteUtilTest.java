package util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarteUtilTest {

    CarteUtil util;
    Carte carte;

    @Before
    public void setUp() throws Exception {
        this.util = new CarteUtil();
        this.carte = new Carte(new Coordonner(2, 2));
    }

    @Test
    public void nEstPasLimiteEstTest() {
        assertFalse(util.estLimiteEst(carte, new Coordonner(0, 0)));
        assertFalse(util.estLimiteEst(carte, new Coordonner(0, 1)));
        assertTrue(util.estLimiteEst(carte, new Coordonner(1, 0)));
        assertTrue(util.estLimiteEst(carte, new Coordonner(1, 1)));
    }

    @Test
    public void ilYABoisDroite() {
        carte.setPoint(new Coordonner( 1, 0), '#');

        assertTrue(util.ilYABoisDroite(carte, new Coordonner(0, 0)));
        assertFalse(util.ilYABoisDroite(carte, new Coordonner(0, 1)));
        assertFalse(util.ilYABoisDroite(carte, new Coordonner(1, 0)));
        assertFalse(util.ilYABoisDroite(carte, new Coordonner(1, 1)));
    }
}