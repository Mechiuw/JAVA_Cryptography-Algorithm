package algorithm;

public class ENCRYPT03 {
    private static final String vocal = "AEIOUaeiou";
    private static final char replacement = '#';
    private static final char replacement2 = '&';
    private static final char replacement3 = '*';
    private static int shift = 0;

    public static void run() {
        String encryptedMessage = data("CAN YOU understand THESE???");
        System.out.println("Encrypted: " + encryptedMessage);
        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted: " + decryptedMessage);
    }

    public static String data(String encrypt) {
        StringBuilder result = new StringBuilder();
        for (char x : encrypt.toCharArray()) {
            if (vocal.indexOf(x) != -1) {
                if (shift > 3) {
                    result.append(replacement2);
                } else {
                    result.append(replacement);
                }
                shift++;
            } else {
                result.append(x);
            }
        }
        result.reverse();
        return result.toString();
    }

    public static String decrypt(String encrypted) {
        StringBuilder result = new StringBuilder(encrypted);
        result.reverse(); // Reverse the reversal done in encryption

        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            char currentChar = result.charAt(i);
            if (currentChar == replacement || currentChar == replacement2 || currentChar == replacement3) {
                if (shift > 3) {
                    decrypted.append(vocal.charAt(1)); // Replace with a specific vowel, adjust as needed
                } else {
                    decrypted.append(vocal.charAt(0)); // Replace with a specific vowel, adjust as needed
                }
                shift++;
            } else {
                decrypted.append(currentChar);
            }
        }
        return decrypted.toString();
    }
}
