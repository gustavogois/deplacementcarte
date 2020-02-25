package fr.com.gfi.deplacementcarte.util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;

public class CoordonnerUtil {

    public Coordonner deplacement(Coordonner coord, char direction) {
        switch (direction) {
            case Carte.EST:
                return new Coordonner(coord.getX() + 1, coord.getY());
            case Carte.SUD:
                return new Coordonner(coord.getX(), coord.getY() + 1);
            case Carte.NORD:
                return new Coordonner(coord.getX(), coord.getY() - 1);
            case Carte.OUEST:
                return new Coordonner(coord.getX() - 1, coord.getY());
            default:
                return coord;
        }
    }
}
