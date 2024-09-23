package Utils;

public class KeyValidator {
    public static void validateKey(int key, int alphabetSize) throws IllegalArgumentException {
        if (key < 0 || key >= alphabetSize) {
            throw new IllegalArgumentException("Ключ должен быть между 0 и " + (alphabetSize - 1));
        }
    }
}