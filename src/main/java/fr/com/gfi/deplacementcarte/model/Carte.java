package fr.com.gfi.deplacementcarte.model;

import util.CarteUtil;

import java.util.Arrays;

// todo: immuabilité
public class Carte {
    private char[][] points;

    public Carte(Coordonner taille, char c) {
        points = new char[taille.getX()][taille.getY()];
        new CarteUtil().remplirAvec(this, c);
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
