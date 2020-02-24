package service;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;
import util.CarteUtil;
import util.CoordonnerUtil;

public class CarteService {

    private CarteUtil Carteutil = new CarteUtil();
    private CoordonnerUtil coordUtil = new CoordonnerUtil();

    public Coordonner deplacement(Carte carte, Coordonner courant, char direction) {

        // todo: immutability
        switch (direction) {
            case 'E' :
                return Carteutil.estValable(carte, courant, direction) ?
                        coordUtil.deplacement(courant, 'E') : courant;
            default:
                return courant;
        }
    }

}
