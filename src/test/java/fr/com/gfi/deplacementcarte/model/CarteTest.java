package fr.com.gfi.deplacementcarte.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CarteTest {

    Carte carte;

    @Before
    public void before() {
        carte = new Carte(new Coordonner(2, 2));
    }

    @Test
    public void getPointTest() {
        carte.setPoint(new Coordonner(0, 1), '#');

        int point = carte.getPoint(new Coordonner(0, 1));

        assertEquals('#', point);
    }
}