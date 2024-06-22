package algorithm;

import java.util.*;

public class ENCRYPT01 {
    public static void run() {
        String encrypted = encrypt("example");
        System.out.println("Encrypted message: " + encrypted);

        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted message: " + decrypted);
    }

    public static String encrypt(String input) {
        // BREAKING APART - CONVERT INTO CHAR
        char[] layer1 = input.toCharArray();
        List<Character> layer2 = new ArrayList<>();

        // LAYER 1 ENCRYPT - ADD TO LIST
        for (int i = layer1.length - 1; i >= 0; i--) {
            layer2.add(layer1[i]);
        }

        // LAYER 2 ENCRYPT - CHECK LOWERCASE AND UPPERCASE
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        List<Character> layer3 = new ArrayList<>();

        for (char currentChar : layer2) {
            boolean found = false;

            // Check lowercase alphabet
            for (int j = 0; j < alphabets.length - 1; j++) {
                if (alphabets[j] == currentChar) {
                    layer3.add(alphabets[j + 1]);
                    found = true;
                    break;
                }
            }

            // Check uppercase alphabet
            if (!found) {
                for (int j = 0; j < upperAlphabets.length - 1; j++) {
                    if (upperAlphabets[j] == currentChar) {
                        layer3.add(upperAlphabets[j + 1]);
                        break;
                    }
                }
            }
        }

        // LAYER 3 - REPLACE WITH INDEX FOR 2, REPLACE WITH UPPERCASE FOR 3
        for (int i = 0; i < layer3.size(); i++) {
            if (i % 2 == 0) {
                layer3.set(i, Character.forDigit(i / 2, 10)); // Adjusted radix for digits
            } else if (i % 3 == 0) {
                layer3.set(i, Character.toUpperCase(layer3.get(i)));
            }
        }

        // LAYER 4 - APPEND RESULT STRING
        StringBuilder result = new StringBuilder();
        for (char c : layer3) {
            result.append(c);
        }

        return result.toString();
    }

    public static String decrypt(String input) {
        // LAYER 4 - CONVERT STRING TO LIST OF CHARACTERS
        List<Character> layer3 = new ArrayList<>();
        for (char c : input.toCharArray()) {
            layer3.add(c);
        }

        // LAYER 3 - REVERSE TRANSFORMATIONS
        List<Character> originalChars = new ArrayList<>(layer3);
        for (int i = 0; i < layer3.size(); i++) {
            if (i % 2 == 0) {
                // Convert digits back to their original characters
                int originalIndex = Character.getNumericValue(layer3.get(i)) * 2;
                layer3.set(i, originalChars.get(originalIndex));
            }
        }

        // LAYER 2 - REVERSE ALPHABET SHIFT
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        List<Character> layer2 = new ArrayList<>();

        for (char currentChar : layer3) {
            boolean found = false;

            // Check lowercase alphabet
            for (int j = 1; j < alphabets.length; j++) {
                if (alphabets[j] == currentChar) {
                    layer2.add(alphabets[j - 1]);
                    found = true;
                    break;
                }
            }

            // Check uppercase alphabet
            if (!found) {
                for (int j = 1; j < upperAlphabets.length; j++) {
                    if (upperAlphabets[j] == currentChar) {
                        layer2.add(upperAlphabets[j - 1]);
                        break;
                    }
                }
            }
        }

        // LAYER 1 - REVERSE THE LIST TO GET ORIGINAL ORDER
        Collections.reverse(layer2);

        // Convert list back to string
        StringBuilder result = new StringBuilder();
        for (char c : layer2) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        run();
    }
}
