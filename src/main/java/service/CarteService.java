package service;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;

public class CarteService {

    public Coordonner deplacement(Jeu jeu, char direction) {

        Coordonner courant = jeu.getCourant();

        switch (direction) {
            case 'E' :
                return estValable(jeu, direction) ? courant.est() : courant;
            default:
                return courant;
        }
    }

    public boolean estValable(Jeu jeu, char direction) {

        switch (direction) {
            case 'E' :
                //return (nEstPasLimiteEst(courant) && ilNYAPasBoisDroite()) ? true : false;
            default:
                return false;
        }
    }
}