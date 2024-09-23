package Utils;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Validator {
    public static void validateFile(String filePath) throws FileNotFoundException {
        var path = Paths.get(filePath);

//        if (!Files.exists(path) || Files.isDirectory(path)) {
        if (!Files.exists(path)) {
            throw new FileNotFoundException("Файл " + filePath + " не существует или является директорией.");
        }
    }
}
