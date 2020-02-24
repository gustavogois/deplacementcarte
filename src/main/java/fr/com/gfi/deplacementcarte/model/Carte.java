package fr.com.gfi.deplacementcarte.model;

import util.CarteUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// todo: immuabilité
public class Carte {
    private char[][] points;

    public Carte(Coordonner taille, char c) {
        points = new char[taille.getX()][taille.getY()];
        new CarteUtil().remplirAvec(this, c);
    }

    public Carte(String nomDeFichier) {

        // todo improvement
        List<String> lignes = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("/" + nomDeFichier))) {

            lignes = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        points = new char[lignes.size()][];
        for (int i = 0 ; i < lignes.size() ; i++) {
            points[i] = new char[lignes.get(i).length()];
            for (int j = 0 ; j < points[i].length ; j++) {
                points[i][j] = lignes.get(i).charAt(j);
            }
        }
    }

    public int getPoint(Coordonner coord) {
        return points[coord.getX()][coord.getY()];
    }

    public void setPoint(Coordonner coord, char valeur) {
        points[coord.getX()][coord.getY()] = valeur;
    }

    public char[][] getPoints() {
        return points;
    }
}
