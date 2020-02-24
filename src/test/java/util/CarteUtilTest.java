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
    public void ilYABoisDroiteTest() {
        carte.setPoint(new Coordonner( 1, 0), '#');

        assertTrue(util.ilYABoisDroite(carte, new Coordonner(0, 0)));
        assertFalse(util.ilYABoisDroite(carte, new Coordonner(0, 1)));
        assertFalse(util.ilYABoisDroite(carte, new Coordonner(1, 0)));
        assertFalse(util.ilYABoisDroite(carte, new Coordonner(1, 1)));
    }

    @Test
    public void estValableDirectionETest() {
        Coordonner courantValideNonLimiteNonBois = new Coordonner(0, 0);
        assertTrue(util.estValable(this.carte, courantValideNonLimiteNonBois, 'E'));

        Coordonner courantInvalideLimite = new Coordonner(1, 0);
        assertFalse(util.estValable(this.carte, courantInvalideLimite, 'E'));

        Coordonner courantInvalideBois = new Coordonner(0, 0);
        carte.setPoint(new Coordonner( 1, 0), '#');
        assertFalse(util.estValable(this.carte, courantInvalideBois, 'E'));
    }

    @Test
    public void remplirDeTest() {

        char[][] points = this.carte.getPoints();
        // todo use lambda to assert
        for (int ligne = 0 ; ligne < points.length ; ligne++) {
            for (int collone = 0 ; collone < points[ligne].length ; collone++) {
                assertEquals(0, points[ligne][collone]);
            }
        }

        util.remplirAvec(this.carte, ' ');

        // todo use lambda to assert
        for (int ligne = 0 ; ligne < points.length ; ligne++) {
            for (int collone = 0 ; collone < points[ligne].length ; collone++) {
                assertEquals(' ', points[ligne][collone]);
            }
        }

    }
}