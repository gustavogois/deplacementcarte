package service;

import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;
import util.CarteUtil;
import util.CoordonnerUtil;

public class CarteService {

    private CarteUtil Carteutil = new CarteUtil();
    private CoordonnerUtil coordUtil = new CoordonnerUtil();

    public Jeu deplacement(Jeu jeu, char direction) {

//        Jeu nouveauJeu = new Jeu(jeu);

//        switch (direction) {
//            case 'E' :
//                return Carteutil.estValable(jeu.getCarte(), jeu.getCourant(), direction) ?
//                        coordUtil.est(courant) : courant;
//            default:
//                return courant;
//        }
        return null;
    }

}
