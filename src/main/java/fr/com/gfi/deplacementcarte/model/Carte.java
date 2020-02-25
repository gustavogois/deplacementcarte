package fr.com.gfi.deplacementcarte.model;

import fr.com.gfi.deplacementcarte.util.CarteUtil;

import java.util.List;

import static fr.com.gfi.deplacementcarte.util.FileUtils.obtenirListeDuFichier;

// todo: immuabilité
public class Carte {
    public static final String CARTE_FICHIER = "carte.txt";
    public static final char EST = 'E';
    public static final char NORD = 'N';
    public static final char OUEST = 'O';
    public static final char SUD = 'S';
    public static final int LIMITE_X = 0;
    public static final int LIMITE_Y = 0;
    public static final char BOIS = '#';
    public static final char LIBRE = (char) 32;

    private char[][] points;

    public Carte(Coordonner taille, char c) {
        points = new char[taille.getX()][taille.getY()];
        new CarteUtil().remplirAvec(this, c);
    }

    public Carte(String nomDeFichier) {
        definirPointsDesLignes(obtenirListeDuFichier(CARTE_FICHIER));
    }

    private void definirPointsDesLignes(List<String> lignes) {
        points = new char[lignes.size()][];
        for (int i = 0 ; i < lignes.size() ; i++) {
            points[i] = new char[lignes.get(i).length()];
            for (int j = 0 ; j < points[i].length ; j++) {
                points[i][j] = lignes.get(i).charAt(j);
            }
        }
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
