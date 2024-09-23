package Application;

import Data.Alphabet;
import Utils.Cipher;
import Utils.FileManager;
import Utils.KeyValidator;
import Utils.Validator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainApp  {

    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        {
            try (scanner) {
                int choice = scanner.nextInt();
                Cipher cipher;
                FileManager fileManager = new FileManager();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Введите путь к зашифрованному файлу:");
                        String outputFileEncrypt = scanner.nextLine();
                        System.out.println("Введите путь к исходному файлу:");
                        String inputFileEncrypt = scanner.nextLine();
                        System.out.println("Введите ключ:");
                        int keyEncrypt = scanner.nextInt();
                        System.out.println("Начинаем шифровку....");
                        scanner.nextLine();
                        cipher = new Cipher();

                        try {
                            Validator.validateFile(inputFileEncrypt);
                            KeyValidator.validateKey(keyEncrypt, Alphabet.getAlphabet().size());
                            fileManager.processFile(inputFileEncrypt, keyEncrypt, cipher);
                            System.out.println("Файл успешно зашифрован.");
                        } catch (Exception e) {
                            System.err.println("Ошибка: " + e.getMessage());
                        }
                    }

                    case 2 -> {
                        System.out.println("Введите путь к расшифрованному файлу:");
                        String outputFileDecrypt = scanner.nextLine();
                        System.out.println("Введите путь к зашифрованному файлу:");
                        String inputFileDecrypt = scanner.nextLine();
                        System.out.println("Введите ключ:");
                        int keyDecrypt = scanner.nextInt();
                        System.out.println("Начинаем расшифровку....");
                        scanner.nextLine();
                        cipher = new Cipher();

                        try {
                            Validator.validateFile(inputFileDecrypt);
                            KeyValidator.validateKey(keyDecrypt, Alphabet.getAlphabet().size());
                            fileManager.processFile(inputFileDecrypt, -keyDecrypt, cipher);
                            System.out.println("Файл успешно расшифрован.");
                        } catch (Exception e) {
                            System.err.println("Ошибка: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        System.out.println("Выход...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Неверная опция!");
                        System.exit(1);
                    }

                }
            }
        }



    }

    private String readFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    private static void printMenu() {
        System.out.println("""
                ШИФР ЦЕЗАРЯ
                Введите опцию:
                1. Зашифровать текст
                2. Расшифровать текст с ключом
                3. Выйти
                """);
    }
}
