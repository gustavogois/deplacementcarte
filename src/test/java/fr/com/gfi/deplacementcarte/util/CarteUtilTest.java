package fr.com.gfi.deplacementcarte.util;

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
        this.carte = new Carte(new Coordonner(2, 2), ' ');
    }

    @Test
    public void remplirDeTest() {

        char[][] points = this.carte.getPoints();
        // todo use lambda to assert
        for (int ligne = 0 ; ligne < points.length ; ligne++) {
            for (int collone = 0 ; collone < points[ligne].length ; collone++) {
                assertEquals(' ', points[ligne][collone]);
            }
        }

        util.remplirAvec(this.carte, '#');

        // todo use lambda to assert
        for (int ligne = 0 ; ligne < points.length ; ligne++) {
            for (int collone = 0 ; collone < points[ligne].length ; collone++) {
                assertEquals('#', points[ligne][collone]);
            }
        }

    }

    @Test
    public void nEstPasLimiteSudTest() {
        assertFalse(util.estLimite(carte, new Coordonner(0, 0), 'S'));
        assertTrue(util.estLimite(carte, new Coordonner(0, 1), 'S'));
        assertFalse(util.estLimite(carte, new Coordonner(1, 0), 'S'));
        assertTrue(util.estLimite(carte, new Coordonner(1, 1), 'S'));
    }

    @Test
    public void ilYABoisDessousTest() {
        carte.setPoint(new Coordonner( 0, 1), '#');

        assertTrue(util.ilYABois(carte, new Coordonner(0, 0), 'S'));
        assertFalse(util.ilYABois(carte, new Coordonner(0, 1), 'S'));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 0), 'S'));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 1), 'S'));
    }

    @Test
    public void estValableDirectionSudTest() {
        carte.setPoint(new Coordonner( 0, 1), '#');

        Coordonner courant1 = new Coordonner(0, 0);
        assertFalse(util.estValable(this.carte, courant1, 'S'));

        Coordonner courant2 = new Coordonner(1, 0);
        assertTrue(util.estValable(this.carte, courant2, 'S'));

        Coordonner courant3 = new Coordonner(1, 1);
        assertFalse(util.estValable(this.carte, courant3, 'S'));

    }

    @Test
    public void nEstPasLimiteEstTest() {
        assertFalse(util.estLimite(carte, new Coordonner(0, 0), 'E'));
        assertFalse(util.estLimite(carte, new Coordonner(0, 1), 'E'));
        assertTrue(util.estLimite(carte, new Coordonner(1, 0), 'E'));
        assertTrue(util.estLimite(carte, new Coordonner(1, 1), 'E'));
    }

    @Test
    public void ilYABoisDroiteTest() {
        carte.setPoint(new Coordonner( 1, 0), '#');

        assertTrue(util.ilYABois(carte, new Coordonner(0, 0), 'E'));
        assertFalse(util.ilYABois(carte, new Coordonner(0, 1), 'E'));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 0), 'E'));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 1), 'E'));
    }

    @Test
    public void estValableDirectionEstTest() {
        Coordonner courantValideNonLimiteNonBois = new Coordonner(0, 0);
        assertTrue(util.estValable(this.carte, courantValideNonLimiteNonBois, 'E'));

        Coordonner courantInvalideLimite = new Coordonner(1, 0);
        assertFalse(util.estValable(this.carte, courantInvalideLimite, 'E'));

        Coordonner courantInvalideBois = new Coordonner(0, 0);
        carte.setPoint(new Coordonner( 1, 0), '#');
        assertFalse(util.estValable(this.carte, courantInvalideBois, 'E'));
    }

    @Test
    public void nEstPasLimiteNordTest() {
        assertTrue(util.estLimite(carte, new Coordonner(0, 0), 'N'));
        assertFalse(util.estLimite(carte, new Coordonner(0, 1), 'N'));
        assertTrue(util.estLimite(carte, new Coordonner(1, 0), 'N'));
        assertFalse(util.estLimite(carte, new Coordonner(1, 1), 'N'));
    }

    @Test
    public void ilYABoisDessusTest() {
        carte.setPoint(new Coordonner( 1, 0), '#');

        assertFalse(util.ilYABois(carte, new Coordonner(0, 0), 'N'));
        assertFalse(util.ilYABois(carte, new Coordonner(0, 1), 'N'));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 0), 'N'));
        assertTrue(util.ilYABois(carte, new Coordonner(1, 1), 'N'));
    }

    @Test
    public void estValableDirectionNordTest() {
        carte.setPoint(new Coordonner( 1, 0), '#');

        Coordonner courant1 = new Coordonner(0, 0);
        assertFalse(util.estValable(this.carte, courant1, 'N'));

        Coordonner courant2 = new Coordonner(0, 1);
        assertTrue(util.estValable(this.carte, courant2, 'N'));

        Coordonner courant3 = new Coordonner(1, 1);
        assertFalse(util.estValable(this.carte, courant3, 'N'));

    }

    @Test
    public void nEstPasLimiteOuestTest() {
        assertTrue(util.estLimite(carte, new Coordonner(0, 0), 'O'));
        assertTrue(util.estLimite(carte, new Coordonner(0, 1), 'O'));
        assertFalse(util.estLimite(carte, new Coordonner(1, 0), 'O'));
        assertFalse(util.estLimite(carte, new Coordonner(1, 1), 'O'));
    }

    @Test
    public void ilYABoisGaucheTest() {
        carte.setPoint(new Coordonner( 0, 1), '#');

        assertFalse(util.ilYABois(carte, new Coordonner(0, 0), 'O'));
        assertFalse(util.ilYABois(carte, new Coordonner(0, 1), 'O'));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 0), 'O'));
        assertTrue(util.ilYABois(carte, new Coordonner(1, 1), 'O'));
    }

    @Test
    public void estValableDirectionOuestTest() {
        carte.setPoint(new Coordonner( 0, 1), '#');

        Coordonner courant1 = new Coordonner(0, 0);
        assertFalse(util.estValable(this.carte, courant1, 'O'));

        Coordonner courant2 = new Coordonner(1, 0);
        assertTrue(util.estValable(this.carte, courant2, 'O'));

        Coordonner courant3 = new Coordonner(1, 1);
        assertFalse(util.estValable(this.carte, courant3, 'O'));

    }

}