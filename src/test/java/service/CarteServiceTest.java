package service;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarteServiceTest {

    CarteService service;
    Carte carte;
    Coordonner courant;

    @Before
    public void before() {
        this.service = new CarteService();
        this.carte = new Carte(new Coordonner(2, 2), ' ');
        this.carte.setPoint(new Coordonner(1, 0), '#');
        this.courant = new Coordonner(0, 0);
    }

    @Test
    public void deplacementVersEst() {
        this.courant = new Coordonner(0, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'E');

        assertEquals(1, nouveauCoord.getX());
        assertEquals(1, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersEstIlyaBois() {
        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'E');

        assertEquals(0, nouveauCoord.getX());
        assertEquals(0, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersEstEstLimite() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'E');

        assertEquals(1, nouveauCoord.getX());
        assertEquals(1, nouveauCoord.getY());
    }
}