package fr.com.gfi.deplacementcarte.model;

import java.util.Arrays;

// todo: transform to stateless
public class Carte {
    private char[][] points;

    public Carte(Coordonner coord) {
        points = new char[coord.getX()][coord.getY()];
        Arrays.stream(points).forEach(ligne -> Arrays.fill(ligne, ' '));
    }

    public int getPoint(Coordonner coord) {
        return points[coord.getX()][coord.getY()];
    }

    public void setPoint(Coordonner coord, char valeur) {
        points[coord.getX()][coord.getY()] = valeur;
    }

    public char[][] getPoints() {
        return points;
    }
}
