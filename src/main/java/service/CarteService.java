package service;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;
import util.CarteUtil;

public class CarteService {

    private CarteUtil util = new CarteUtil();

    public Coordonner deplacement(Jeu jeu, char direction) {

        Coordonner courant = jeu.getCourant();

        switch (direction) {
            case 'E' :
                return util.estValable(jeu.getCarte(), jeu.getCourant(), direction) ? courant.est() : courant;
            default:
                return courant;
        }
    }

}
