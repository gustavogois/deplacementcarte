package util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;

import java.util.Arrays;

public class CarteUtil {

    public boolean estLimiteEst(Carte carte, Coordonner courant) {
        return courant.getX() >= (carte.getPoints()[courant.getY()].length - 1);
    }

    public boolean estLimiteSud(Carte carte, Coordonner courant) {
        return courant.getY() >= (carte.getPoints()[courant.getX()].length - 1);
    }

    public boolean ilYABoisDroite(Carte carte, Coordonner courant) {
        if (!estLimiteEst(carte, courant)) {
            return carte.getPoints()[courant.getX() + 1][courant.getY()] == '#';
        }
        return false;
    }

    public boolean ilYABoisDessous(Carte carte, Coordonner courant) {
        if (!estLimiteSud(carte, courant)) {
            return carte.getPoints()[courant.getX()][courant.getY() + 1] == '#';
        }
        return false;
    }

    public boolean estValable(Carte carte, Coordonner coord, char direction) {

        switch (direction) {
            case 'E' :
                return (!estLimiteEst(carte, coord) && !ilYABoisDroite(carte, coord)) ? true : false;
            case 'S' :
                return (!estLimiteSud(carte, coord) && !ilYABoisDessous(carte, coord)) ? true : false;
            default:
                return false;
        }
    }

    public void remplirAvec(Carte carte, char c) {
        Arrays.stream(carte.getPoints()).forEach(ligne -> Arrays.fill(ligne, c));
    }

}
