package util;

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
            default:
                return false;
        }
    }

    public boolean ilYABoisDroite(Carte carte, Coordonner courant) {
        if (!estLimite(carte, courant, 'E')) {
            return carte.getPoints()[courant.getX() + 1][courant.getY()] == '#';
        }
        return false;
    }

    public boolean ilYABoisDessous(Carte carte, Coordonner courant) {
        if (!estLimite(carte, courant, 'S')) {
            return carte.getPoints()[courant.getX()][courant.getY() + 1] == '#';
        }
        return false;
    }

    public boolean estValable(Carte carte, Coordonner coord, char direction) {

        switch (direction) {
            case 'E' :
                return (!estLimite(carte, coord, 'E') && !ilYABoisDroite(carte, coord)) ? true : false;
            case 'S' :
                return (!estLimite(carte, coord, 'S') && !ilYABoisDessous(carte, coord)) ? true : false;
            default:
                return false;
        }
    }

    public void remplirAvec(Carte carte, char c) {
        Arrays.stream(carte.getPoints()).forEach(ligne -> Arrays.fill(ligne, c));
    }

}
