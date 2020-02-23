package service;

import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;

public class JeuService {

    private CarteService carteService;

    // todo Considerar a imutabilidade dos objetos
    public Jeu deplacement(Jeu jeu, char direction) {
        Coordonner noveauCourant = carteService.deplacement(jeu, direction);
        jeu.setCourant(noveauCourant);

        return null;
    }
}
