package service;

import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;
import util.CarteUtil;
import util.CoordonnerUtil;

public class CarteService {

    private CarteUtil Carteutil = new CarteUtil();
    private CoordonnerUtil coordUtil = new CoordonnerUtil();

    public Jeu deplacement(Jeu jeu, char direction) {

        // todo: immutability
        switch (direction) {
            case 'E' :
                Coordonner nouveauCoord = Carteutil.estValable(jeu.getCarte(), jeu.getCourant(), direction) ?
                        coordUtil.est(jeu.getCourant()) : jeu.getCourant();
                jeu.setCourant(nouveauCoord);
                return jeu;
            default:
                return jeu;
        }
    }

}
