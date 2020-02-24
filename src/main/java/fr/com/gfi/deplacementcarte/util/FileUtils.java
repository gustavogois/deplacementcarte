package fr.com.gfi.deplacementcarte.util;

import java.io.File;

public class FileUtils {
    public static String getPathFromResources(String nomDeFichier) {
        return new File("").getAbsolutePath() + "\\src\\main\\resources\\" + nomDeFichier;
    }
}
