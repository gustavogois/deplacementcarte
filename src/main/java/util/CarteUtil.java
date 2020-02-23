package util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;

public class CarteUtil {

    public boolean nEstPasLimiteEst(Carte carte, Coordonner courant) {
        return courant.getX() < (carte.getPoints()[courant.getY()].length - 1);
    }
}
