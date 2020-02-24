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
        return Carteutil.estValable(carte, courant, direction) ? coordUtil.deplacement(courant, direction) : courant;
    }

    public Coordonner deplacements(Carte carte, Coordonner courant, String directions) {

        // todo Verificar se existe forma melhor de fazer com stream
        Coordonner nouveauCoord = courant;
        for (int i = 0 ; i < directions.length() ; i++) {
            char direction = directions.charAt(i);
            nouveauCoord = deplacement(carte, courant, direction);
            courant = nouveauCoord;
        }
        return nouveauCoord;
    }
}
