package fr.com.gfi.deplacementcarte.model;

public class Jeu {

    private Carte carte;
    private Coordonner depart;
    private Coordonner courant;

    public Jeu(Carte carte, Coordonner depart) {
        this.carte = carte;
        setDepart(depart);
        setCourant(courant);
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
