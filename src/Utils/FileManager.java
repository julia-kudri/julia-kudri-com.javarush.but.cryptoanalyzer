package Utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class FileManager {
    public void processFile(String inputFilePath, String outputFilePath, int key, Cipher cipher) throws IOException {
        var inputPath = Paths.get(inputFilePath);
        var outputPath = Paths.get(outputFilePath);

        // Чтение всех строк из файла
        var lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);

        // Обработка каждой строки
        var processedLines = lines.stream()
                .map(line -> cipher.encrypt(line, key))
                .toList();

        // Запись обработанных строк в выходной файл
        Files.write(outputPath, processedLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
