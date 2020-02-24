package fr.com.gfi.deplacementcarte.util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;

import java.util.Arrays;

public class CarteUtil {

    public boolean estLimite(Carte carte, Coordonner courant, char c) {
        switch (c) {
            case 'E':
                return courant.getX() >= (carte.getPoints()[courant.getY()].length - 1);
            case 'S':
                return courant.getY() >= (carte.getPoints()[courant.getX()].length - 1);
            case 'N':
                return courant.getY() == 0;
            case 'O':
                return courant.getX() == 0;
            default:
                return false;
        }
    }

    public boolean ilYABois(Carte carte, Coordonner courant, char c) {
        switch (c) {
            case 'E':
                return !estLimite(carte, courant, 'E') &&
                        carte.getPoints()[courant.getX() + 1][courant.getY()] == '#';
            case 'S':
                return !estLimite(carte, courant, 'S') &&
                        carte.getPoints()[courant.getX()][courant.getY() + 1] == '#';
            case 'N':
                return !estLimite(carte, courant, 'N') &&
                        carte.getPoints()[courant.getX()][courant.getY() - 1] == '#';
            case 'O':
                return !estLimite(carte, courant, 'O') &&
                        carte.getPoints()[courant.getX() - 1][courant.getY()] == '#';
            default:
                return false;
        }
    }

    public boolean estValable(Carte carte, Coordonner coord, char direction) {

        switch (direction) {
            case 'E' :
                return !estLimite(carte, coord, 'E') && !ilYABois(carte, coord, 'E');
            case 'S' :
                return !estLimite(carte, coord, 'S') && !ilYABois(carte, coord, 'S');
            case 'N' :
                return !estLimite(carte, coord, 'N') && !ilYABois(carte, coord, 'N');
            case 'O' :
                return !estLimite(carte, coord, 'O') && !ilYABois(carte, coord, 'O');
            default:
                return false;
        }
    }

    public void remplirAvec(Carte carte, char c) {
        Arrays.stream(carte.getPoints()).forEach(ligne -> Arrays.fill(ligne, c));
    }
}
