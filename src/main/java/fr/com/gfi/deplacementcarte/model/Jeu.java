package fr.com.gfi.deplacementcarte.model;

public class Jeu {

    private Carte carte;
    private Coordonner positionDeDepart;

    public Jeu(Carte carte) {
        this.carte = carte;
    }

    public void setPositionDeDepart(Coordonner coord) {
        this.positionDeDepart = coord;
    }

    public Coordonner getPositionDeDepart() {
        return positionDeDepart;
    }
}
