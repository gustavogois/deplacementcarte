package fr.com.gfi.deplacementcarte.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public static final String SRC_MAIN_RESOURCES = "\\src\\main\\resources\\";

    public static String getPathFromResources(String nomDeFichier) {
        return new File("").getAbsolutePath() + SRC_MAIN_RESOURCES + nomDeFichier;
    }

    public static List<String> obtenirListeDuFichier(String nomFichier) {
        // todo improvement
        List<String> lignes = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(FileUtils.getPathFromResources(nomFichier)))) {
            lignes = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lignes;
    }

}
