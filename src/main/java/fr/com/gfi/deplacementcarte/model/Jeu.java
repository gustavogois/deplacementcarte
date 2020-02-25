package fr.com.gfi.deplacementcarte.model;

import fr.com.gfi.deplacementcarte.util.FileUtils;

import java.util.List;

import static fr.com.gfi.deplacementcarte.util.FileUtils.obtenirListeDuFichier;

public class Jeu {

    public static final String SEPARATEUR_DES_COORDONNEES = ",";

    private Carte carte;
    private Coordonner depart;
    private Coordonner courant;
    private String directions;

    public Jeu(Carte carte, Coordonner depart) {
        this.carte = carte;
        setDepart(depart);
        setCourant(courant);
    }

    public Jeu(String nomFichierJeu) {
        List<String> lignes = obtenirListeDuFichier(nomFichierJeu);
        String[] premiereLigne = lignes.get(0).split(SEPARATEUR_DES_COORDONNEES);

        this.carte = new Carte(Carte.CARTE_FICHIER);
        this.depart = new Coordonner(Integer.parseInt(premiereLigne[0]), Integer.parseInt(premiereLigne[1]));
        this.courant = this.depart;
        this.directions = lignes.get(1);
    }

    public void setDepart(Coordonner coord) {
        this.depart = coord;
        this.courant = coord;
    }

    public Coordonner getDepart() {
        return depart;
    }

    public Coordonner getCourant() {
        return courant;
    }

    public void setCourant(Coordonner courant) {
        this.courant = courant;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }
}
