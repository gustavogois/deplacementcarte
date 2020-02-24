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
    public void deplacementTest() {
        this.jeu.setCourant(new Coordonner(0, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, 'E');

        assertEquals(nouveauJeu.getCourant().getX(), 1);
        assertEquals(nouveauJeu.getCourant().getY(), 1);
    }

    @Test
    public void deplacementVersEstIlyaBois() {
        Jeu nouveauJeu = service.deplacement(this.jeu, 'E');

        assertEquals(0, nouveauJeu.getCourant().getX());
        assertEquals(0, nouveauJeu.getCourant().getY());
    }

    @Test
    public void deplacementVersEstEstLimite() {
        jeu.setCourant(new Coordonner(1, 1));

        Jeu nouveauJeu = service.deplacement(this.jeu, 'E');

        assertEquals(1, nouveauJeu.getCourant().getX());
        assertEquals(1, nouveauJeu.getCourant().getY());
    }

}