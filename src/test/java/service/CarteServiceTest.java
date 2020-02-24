package service;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import fr.com.gfi.deplacementcarte.model.Jeu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarteServiceTest {

    CarteService service;
    private Jeu jeu;

    @Before
    public void before() {
        this.service = new CarteService();
        Carte carte = new Carte(new Coordonner(2, 2), ' ');
        this.jeu = new Jeu(carte, new Coordonner(0, 0));
    }

    @Test
    public void deplacementVersEst() {

    }
}