package service;

import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;
import util.CarteUtil;
import util.CoordonnerUtil;

public class CarteService {

    private CarteUtil Carteutil = new CarteUtil();
    private CoordonnerUtil coordUtil = new CoordonnerUtil();

    public Coordonner deplacement(Jeu jeu, char direction) {

        Coordonner courant = jeu.getCourant();

        switch (direction) {
            case 'E' :
                return Carteutil.estValable(jeu.getCarte(), jeu.getCourant(), direction) ?
                        coordUtil.est(courant) : courant;
            default:
                return courant;
        }
    }

}
