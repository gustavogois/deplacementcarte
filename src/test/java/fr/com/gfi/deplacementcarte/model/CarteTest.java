package fr.com.gfi.deplacementcarte.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CarteTest {

    Carte carte;

    @Test
    public void demarrerAvecValeursTest() {
        carte = new Carte(2, 2);
        Arrays.stream(carte.getPoints()).forEach(r -> Arrays.fill(r, ' '));

        // todo: use lambda to iterate and assert
        assertEquals(' ', carte.getPoint(0, 0));
        assertEquals(' ', carte.getPoint(0, 1));
        assertEquals(' ', carte.getPoint(1, 0));
        assertEquals(' ', carte.getPoint(1, 1));
    }

    @Test
    public void getPointTest() {
        carte = new Carte(2, 2);
        carte.setPoint(0, 1, ' ');

        int point = carte.getPoint(0, 1);

        assertEquals(' ', point);
    }
}