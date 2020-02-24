package util;

import fr.com.gfi.deplacementcarte.model.Coordonner;

public class CoordonnerUtil {

    public Coordonner est(Coordonner coord) {
        return new Coordonner(coord.getX() + 1, coord.getY());
    }

    public Coordonner sud(Coordonner coord) {
        return new Coordonner(coord.getX(), coord.getY() + 1);
    }

}
