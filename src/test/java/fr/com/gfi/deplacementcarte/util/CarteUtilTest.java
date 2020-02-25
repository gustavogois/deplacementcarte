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
        this.carte = new Carte(new Coordonner(2, 2), Carte.LIBRE);
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

        util.remplirAvec(this.carte, Carte.BOIS);

        // todo use lambda to assert
        for (int ligne = 0 ; ligne < points.length ; ligne++) {
            for (int collone = 0 ; collone < points[ligne].length ; collone++) {
                assertEquals(Carte.BOIS, points[ligne][collone]);
            }
        }

    }

    @Test
    public void nEstPasLimiteSudTest() {
        assertFalse(util.estLimite(carte, new Coordonner(0, 0), Carte.SUD));
        assertTrue(util.estLimite(carte, new Coordonner(0, 1), Carte.SUD));
        assertFalse(util.estLimite(carte, new Coordonner(1, 0), Carte.SUD));
        assertTrue(util.estLimite(carte, new Coordonner(1, 1), Carte.SUD));
    }

    @Test
    public void ilYABoisDessousTest() {
        carte.setPoint(new Coordonner( 0, 1), Carte.BOIS);

        assertTrue(util.ilYABois(carte, new Coordonner(0, 0), Carte.SUD));
        assertFalse(util.ilYABois(carte, new Coordonner(0, 1), Carte.SUD));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 0), Carte.SUD));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 1), Carte.SUD));
    }

    @Test
    public void estValableDirectionSudTest() {
        carte.setPoint(new Coordonner( 0, 1), Carte.BOIS);

        Coordonner courant1 = new Coordonner(0, 0);
        assertFalse(util.estValable(this.carte, courant1, Carte.SUD));

        Coordonner courant2 = new Coordonner(1, 0);
        assertTrue(util.estValable(this.carte, courant2, Carte.SUD));

        Coordonner courant3 = new Coordonner(1, 1);
        assertFalse(util.estValable(this.carte, courant3, Carte.SUD));

    }

    @Test
    public void nEstPasLimiteEstTest() {
        assertFalse(util.estLimite(carte, new Coordonner(0, 0), Carte.EST));
        assertFalse(util.estLimite(carte, new Coordonner(0, 1), Carte.EST));
        assertTrue(util.estLimite(carte, new Coordonner(1, 0), Carte.EST));
        assertTrue(util.estLimite(carte, new Coordonner(1, 1), Carte.EST));
    }

    @Test
    public void ilYABoisDroiteTest() {
        carte.setPoint(new Coordonner( 1, 0), Carte.BOIS);

        assertTrue(util.ilYABois(carte, new Coordonner(0, 0), Carte.EST));
        assertFalse(util.ilYABois(carte, new Coordonner(0, 1), Carte.EST));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 0), Carte.EST));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 1), Carte.EST));
    }

    @Test
    public void estValableDirectionEstTest() {
        Coordonner courantValideNonLimiteNonBois = new Coordonner(0, 0);
        assertTrue(util.estValable(this.carte, courantValideNonLimiteNonBois, Carte.EST));

        Coordonner courantInvalideLimite = new Coordonner(1, 0);
        assertFalse(util.estValable(this.carte, courantInvalideLimite, Carte.EST));

        Coordonner courantInvalideBois = new Coordonner(0, 0);
        carte.setPoint(new Coordonner( 1, 0), Carte.BOIS);
        assertFalse(util.estValable(this.carte, courantInvalideBois, Carte.EST));
    }

    @Test
    public void nEstPasLimiteNordTest() {
        assertTrue(util.estLimite(carte, new Coordonner(0, 0), Carte.NORD));
        assertFalse(util.estLimite(carte, new Coordonner(0, 1), Carte.NORD));
        assertTrue(util.estLimite(carte, new Coordonner(1, 0), Carte.NORD));
        assertFalse(util.estLimite(carte, new Coordonner(1, 1), Carte.NORD));
    }

    @Test
    public void ilYABoisDessusTest() {
        carte.setPoint(new Coordonner( 1, 0), Carte.BOIS);

        assertFalse(util.ilYABois(carte, new Coordonner(0, 0), Carte.NORD));
        assertFalse(util.ilYABois(carte, new Coordonner(0, 1), Carte.NORD));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 0), Carte.NORD));
        assertTrue(util.ilYABois(carte, new Coordonner(1, 1), Carte.NORD));
    }

    @Test
    public void estValableDirectionNordTest() {
        carte.setPoint(new Coordonner( 1, 0), Carte.BOIS);

        Coordonner courant1 = new Coordonner(0, 0);
        assertFalse(util.estValable(this.carte, courant1, Carte.NORD));

        Coordonner courant2 = new Coordonner(0, 1);
        assertTrue(util.estValable(this.carte, courant2, Carte.NORD));

        Coordonner courant3 = new Coordonner(1, 1);
        assertFalse(util.estValable(this.carte, courant3, Carte.NORD));

    }

    @Test
    public void nEstPasLimiteOuestTest() {
        assertTrue(util.estLimite(carte, new Coordonner(0, 0), Carte.OUEST));
        assertTrue(util.estLimite(carte, new Coordonner(0, 1), Carte.OUEST));
        assertFalse(util.estLimite(carte, new Coordonner(1, 0), Carte.OUEST));
        assertFalse(util.estLimite(carte, new Coordonner(1, 1), Carte.OUEST));
    }

    @Test
    public void ilYABoisGaucheTest() {
        carte.setPoint(new Coordonner( 0, 1), Carte.BOIS);

        assertFalse(util.ilYABois(carte, new Coordonner(0, 0), Carte.OUEST));
        assertFalse(util.ilYABois(carte, new Coordonner(0, 1), Carte.OUEST));
        assertFalse(util.ilYABois(carte, new Coordonner(1, 0), Carte.OUEST));
        assertTrue(util.ilYABois(carte, new Coordonner(1, 1), Carte.OUEST));
    }

    @Test
    public void estValableDirectionOuestTest() {
        carte.setPoint(new Coordonner( 0, 1), Carte.BOIS);

        Coordonner courant1 = new Coordonner(0, 0);
        assertFalse(util.estValable(this.carte, courant1, Carte.OUEST));

        Coordonner courant2 = new Coordonner(1, 0);
        assertTrue(util.estValable(this.carte, courant2, Carte.OUEST));

        Coordonner courant3 = new Coordonner(1, 1);
        assertFalse(util.estValable(this.carte, courant3, Carte.OUEST));

    }

}