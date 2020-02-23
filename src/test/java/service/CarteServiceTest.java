package service;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarteServiceTest {

    CarteService service;
    private Carte carte;

    @Before
    public void before() {
        this.service = new CarteService();
        this.carte = new Carte(new Coordonner(2, 2));
    }
}