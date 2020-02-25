package fr.com.gfi.deplacementcarte.util;

import fr.com.gfi.deplacementcarte.model.Carte;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void getPathFromResourcesTest() throws Exception {
        String pathFromResources = FileUtils.getPathFromResources(Carte.CARTE_FICHIER);
        Stream<String> stream = Files.lines(Paths.get(pathFromResources));
        assertNotNull(stream);
    }
}