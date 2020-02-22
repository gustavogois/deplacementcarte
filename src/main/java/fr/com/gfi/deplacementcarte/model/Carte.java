package fr.com.gfi.deplacementcarte.model;

import java.util.Arrays;

// todo: transform to stateless
public class Carte {
    private char[][] points;

    public Carte(int x, int y) {
        points = new char[x][y];
    }

    public int getPoint(int x, int y) {
        return points[x][y];
    }

    public void setPoint(int x, int y, char valeur) {
        points[x][y] = valeur;
    }

    public char[][] getPoints() {
        return points;
    }
}
