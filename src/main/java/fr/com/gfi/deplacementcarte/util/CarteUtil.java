package fr.com.gfi.deplacementcarte.util;

import fr.com.gfi.deplacementcarte.model.Carte;
import fr.com.gfi.deplacementcarte.model.Coordonner;

import java.util.Arrays;

public class CarteUtil {

    public boolean estLimite(Carte carte, Coordonner courant, char c) {
        switch (c) {
            case Carte.EST:
                return courant.getX() >= (carte.getPoints()[courant.getY()].length - 1);
            case Carte.SUD:
                return courant.getY() >= (carte.getPoints()[courant.getX()].length - 1);
            case Carte.NORD:
                return courant.getY() == Carte.LIMITE_Y;
            case Carte.OUEST:
                return courant.getX() == Carte.LIMITE_X;
            default:
                return false;
        }
    }

    public boolean ilYABois(Carte carte, Coordonner courant, char c) {
        switch (c) {
            case Carte.EST:
                return !estLimite(carte, courant, Carte.EST) &&
                        carte.getPoints()[courant.getX() + 1][courant.getY()] == Carte.BOIS;
            case Carte.SUD:
                return !estLimite(carte, courant, Carte.SUD) &&
                        carte.getPoints()[courant.getX()][courant.getY() + 1] == Carte.BOIS;
            case Carte.NORD:
                return !estLimite(carte, courant, Carte.NORD) &&
                        carte.getPoints()[courant.getX()][courant.getY() - 1] == Carte.BOIS;
            case Carte.OUEST:
                return !estLimite(carte, courant, Carte.OUEST) &&
                        carte.getPoints()[courant.getX() - 1][courant.getY()] == Carte.BOIS;
            default:
                return false;
        }
    }

    public boolean estValable(Carte carte, Coordonner coord, char direction) {

        switch (direction) {
            case Carte.EST:
                return !estLimite(carte, coord, Carte.EST) && !ilYABois(carte, coord, Carte.EST);
            case Carte.SUD:
                return !estLimite(carte, coord, Carte.SUD) && !ilYABois(carte, coord, Carte.SUD);
            case Carte.NORD:
                return !estLimite(carte, coord, Carte.NORD) && !ilYABois(carte, coord, Carte.NORD);
            case Carte.OUEST:
                return !estLimite(carte, coord, Carte.OUEST) && !ilYABois(carte, coord, Carte.OUEST);
            default:
                return false;
        }
    }

    public void remplirAvec(Carte carte, char c) {
        Arrays.stream(carte.getPoints()).forEach(ligne -> Arrays.fill(ligne, c));
    }
}
