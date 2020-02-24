package fr.com.gfi.deplacementcarte.service;

import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;

public class JeuService {

    private CarteService carteService = new CarteService();

    // todo Considerar a imutabilidade dos objetos
    public Jeu deplacement(Jeu jeu, char direction) {
        Coordonner noveauCourant = carteService.deplacement(jeu.getCarte(), jeu.getCourant(), direction);
        jeu.setCourant(noveauCourant);
        return jeu;
    }

    public Jeu deplacements(Jeu jeu, String directions) {
        Coordonner noveauCourant = carteService.deplacements(jeu.getCarte(), jeu.getCourant(), directions);
        jeu.setCourant(noveauCourant);
        return jeu;
    }

}
