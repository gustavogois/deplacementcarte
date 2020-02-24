package util;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void getRelativePathFromResourcesTest() throws Exception {
        String pathFromResources = FileUtils.getPathFromResources("carte.txt");
        Stream<String> stream = Files.lines(Paths.get(pathFromResources));
        assertNotNull(stream);
    }
}