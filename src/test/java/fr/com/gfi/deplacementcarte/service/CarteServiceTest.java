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
        this.carte = new Carte(new Coordonner(2, 2), Carte.LIBRE);
        this.carte.setPoint(new Coordonner(1, 0), Carte.BOIS);
        this.courant = new Coordonner(0, 0);
    }

    @Test
    public void deplacementVersEst() {
        this.courant = new Coordonner(0, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.EST);

        assertEquals(1, nouveauCoord.getX());
        assertEquals(1, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersEstIlyaBois() {
        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.EST);

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersEstEstLimite() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.EST);

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersSud() {
        this.courant = new Coordonner(1, 0);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.SUD);

        assertEquals(1, nouveauCoord.getX());
        assertEquals(1, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersSudIlyaBois() {
        this.carte.setPoint(new Coordonner(0, 1), Carte.BOIS);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.SUD);

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersSudEstLimite() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.SUD);

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersNord() {
        this.courant = new Coordonner(0, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.NORD);

        assertEquals(0, nouveauCoord.getX());
        assertEquals(0, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersNordIlyaBois() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.NORD);

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersNordEstLimite() {
        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.NORD);

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersOuest() {
        this.courant = new Coordonner(1, 1);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.OUEST);

        assertEquals(0, nouveauCoord.getX());
        assertEquals(1, nouveauCoord.getY());
    }

    @Test
    public void deplacementVersOuestIlyaBois() {
        this.courant = new Coordonner(1, 1);
        this.carte.setPoint(new Coordonner(0, 1), Carte.BOIS);

        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.OUEST);

        assertTrue(nouveauCoord == courant);
    }

    @Test
    public void deplacementVersOuestEstLimite() {
        Coordonner nouveauCoord = service.deplacement(this.carte, this.courant, Carte.OUEST);

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