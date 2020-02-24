package util;

import fr.com.gfi.deplacementcarte.model.Coordonner;

public class CoordonnerUtil {

    public Coordonner deplacement(Coordonner coord, char direction) {
        switch (direction) {
            case 'E':
                return new Coordonner(coord.getX() + 1, coord.getY());
            case 'S':
                return new Coordonner(coord.getX(), coord.getY() + 1);
            case 'N':
                return new Coordonner(coord.getX(), coord.getY() - 1);
            default:
                return coord;
        }
    }
}
