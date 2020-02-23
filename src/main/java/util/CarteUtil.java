package util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;

public class CarteUtil {

    public boolean estLimiteEst(Carte carte, Coordonner courant) {
        return courant.getX() >= (carte.getPoints()[courant.getY()].length - 1);
    }

    public boolean ilYABoisDroite(Carte carte, Coordonner courant) {
        if (!estLimiteEst(carte, courant)) {
            return carte.getPoints()[courant.getX() + 1][courant.getY()] == '#';
        }
        return false;
    }
}
