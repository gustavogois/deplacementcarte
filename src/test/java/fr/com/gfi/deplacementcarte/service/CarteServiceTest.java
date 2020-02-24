package fr.com.gfi.deplacementcarte.service;

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

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersEstEstLimite() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'E');

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersSud() {
        this.courant = new Coordonner(1, 0);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'S');

        assertEquals(1, nouveauCoord.getX());
        assertEquals(1, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersSudIlyaBois() {
        this.carte.setPoint(new Coordonner(0, 1), '#');

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'S');

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersSudEstLimite() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'S');

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersNord() {
        this.courant = new Coordonner(0, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'N');

        assertEquals(0, nouveauCoord.getX());
        assertEquals(0, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersNordIlyaBois() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'N');

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersNordEstLimite() {
        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'N');

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersOuest() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'O');

        assertEquals(0, nouveauCoord.getX());
        assertEquals(1, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersOuestIlyaBois() {
        this.courant = new Coordonner(1, 1);
        this.carte.setPoint(new Coordonner(0, 1), '#');

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'O');

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersOuestEstLimite() {
        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, 'O');

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void plusieuersDeplacements() {
        Coordonner nouveauCoord = service.deplacements(this.carte, this.courant, "SSSEEENNNNOOOO");

        // todo Transformar em um único equals, usando o equals de Coord (em todos!!)
        assertEquals(0, nouveauCoord.getX());
        assertEquals(1, nouveauCoord.getY());
    }
}