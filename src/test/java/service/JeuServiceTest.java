package service;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JeuServiceTest {

    JeuService service;
    Jeu jeu;

    @Before
    public void setUp() throws Exception {
        this.service = new JeuService();

        Carte carte = new Carte(new Coordonner(2, 2), ' ');
        carte.setPoint(new Coordonner(1, 0), '#');
        this.jeu = new Jeu(carte, new Coordonner(0, 0));
    }

    @Test
    public void deplacementVersEstTest() {
        this.jeu.setCourant(new Coordonner(0, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, 'E');

        assertEquals(nouveauJeu.getCourant().getX(), 1);
        assertEquals(nouveauJeu.getCourant().getY(), 1);
    }

    @Test
    public void deplacementVersEstIlyaBois() {
        Jeu nouveauJeu = service.deplacement(this.jeu, 'E');

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersEstEstLimite() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, 'E');

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersSudTest() {
        Jeu nouveauJeu = service.deplacement(this.jeu, 'S');

        assertEquals(nouveauJeu.getCourant().getX(), 0);
        assertEquals(nouveauJeu.getCourant().getY(), 1);
    }

    @Test
    public void deplacementVersSudIlyaBois() {
        // todo: improvement
        jeu.getCarte().setPoint(new Coordonner(0, 1), '#');

        Jeu nouveauJeu = service.deplacement(this.jeu, 'S');

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersSudEstLimite() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, 'S');

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersNordTest() {
        jeu.setCourant(new Coordonner(0, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, 'N');

        assertEquals(nouveauJeu.getCourant().getX(), 0);
        assertEquals(nouveauJeu.getCourant().getY(), 0);
    }

    @Test
    public void deplacementVersNordIlyaBois() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, 'N');

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersNordEstLimite() {
        Jeu nouveauJeu = service.deplacement(this.jeu, 'N');

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersOuestTest() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, 'O');

        assertEquals(nouveauJeu.getCourant().getX(), 0);
        assertEquals(nouveauJeu.getCourant().getY(), 1);
    }

    @Test
    public void deplacementVersOuestIlyaBois() {
        jeu.setCourant(new Coordonner(1, 1));
        // todo: improvement
        jeu.getCarte().setPoint(new Coordonner(1, 0), '#');

        Jeu nouveauJeu = service.deplacement(this.jeu, 'O');

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersOuestEstLimite() {
        Jeu nouveauJeu = service.deplacement(this.jeu, 'O');

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

}