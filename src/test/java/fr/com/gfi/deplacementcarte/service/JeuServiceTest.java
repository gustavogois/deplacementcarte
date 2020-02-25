package fr.com.gfi.deplacementcarte.service;

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

        Carte carte = new Carte(new Coordonner(2, 2), Carte.LIBRE);
        carte.setPoint(new Coordonner(1, 0), Carte.BOIS);
        this.jeu = new Jeu(carte, new Coordonner(0, 0));
    }

    @Test
    public void deplacementVersEstTest() {
        this.jeu.setCourant(new Coordonner(0, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.EST);

        assertEquals(nouveauJeu.getCourant().getX(), 1);
        assertEquals(nouveauJeu.getCourant().getY(), 1);
    }

    @Test
    public void deplacementVersEstIlyaBois() {
        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.EST);

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersEstEstLimite() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.EST);

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersSudTest() {
        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.SUD);

        assertEquals(nouveauJeu.getCourant().getX(), 0);
        assertEquals(nouveauJeu.getCourant().getY(), 1);
    }

    @Test
    public void deplacementVersSudIlyaBois() {
        // todo: improvement
        jeu.getCarte().setPoint(new Coordonner(0, 1), Carte.BOIS);

        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.SUD);

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersSudEstLimite() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.SUD);

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersNordTest() {
        jeu.setCourant(new Coordonner(0, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.NORD);

        assertEquals(nouveauJeu.getCourant().getX(), 0);
        assertEquals(nouveauJeu.getCourant().getY(), 0);
    }

    @Test
    public void deplacementVersNordIlyaBois() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.NORD);

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersNordEstLimite() {
        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.NORD);

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersOuestTest() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.OUEST);

        assertEquals(nouveauJeu.getCourant().getX(), 0);
        assertEquals(nouveauJeu.getCourant().getY(), 1);
    }

    @Test
    public void deplacementVersOuestIlyaBois() {
        jeu.setCourant(new Coordonner(1, 1));
        // todo: improvement
        jeu.getCarte().setPoint(new Coordonner(1, 0), Carte.BOIS);

        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.OUEST);

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacementVersOuestEstLimite() {
        Jeu nouveauJeu = service.deplacement(this.jeu, Carte.OUEST);

        assertTrue(nouveauJeu.getCourant() == jeu.getCourant());
    }

    @Test
    public void deplacements() {
        Jeu nouveauJeu = service.deplacements(this.jeu, "SSSEEENNNNOOOO");

        // todo Transformar em um único equals, usando o equals de Coord (em todos!!)
        assertEquals(new Coordonner(0, 1), jeu.getCourant());
    }

    @Test
    public void jouerAuJeuTest() {
        Jeu jeu = service.jouerAuJeu("premier_test.txt");

        //assertEquals(new Coordonner(9, 2), jeu.getCourant());
    }
}