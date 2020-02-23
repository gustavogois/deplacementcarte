package util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarteUtilTest {

    CarteUtil util;

    @Before
    public void setUp() throws Exception {
        this.util = new CarteUtil();
    }

    @Test
    public void nEstPasLimiteEstTest() {

        Carte carte = new Carte(new Coordonner(2, 2));

        assertTrue(util.nEstPasLimiteEst(carte, new Coordonner(0, 0)));
        assertTrue(util.nEstPasLimiteEst(carte, new Coordonner(0, 1)));
        assertFalse(util.nEstPasLimiteEst(carte, new Coordonner(1, 0)));
        assertFalse(util.nEstPasLimiteEst(carte, new Coordonner(1, 1)));
    }
}