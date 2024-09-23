package Utils;

import Data.Alphabet;

public class Cipher {

        public String encrypt(String inputFile, int key) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < inputFile.length(); i++) {
                char currentChar = inputFile.charAt(i);
                int index = Alphabet.getAlphabet().indexOf(currentChar);

                if (index != -1) {
                    int newIndex = (index + key) % Alphabet.getAlphabet().size();
                    if (newIndex < 0) {
                        newIndex += Alphabet.getAlphabet().size();  // Для отрицательных значений
                    }

                    result.append(Alphabet.getAlphabet().get(newIndex));
                } else {
                    result.append(currentChar); // не меняем символы, которых нет в алфавите
                }
            }

            return result.toString();
        }

        public String decrypt(String inputFile, int key) {
            key = -key;
            return encrypt(inputFile, key); // Расшифровка аналогична шифрованию с отрицательным сдвигом
        }
    }
