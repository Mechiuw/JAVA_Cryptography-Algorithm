package algorithm;

import java.util.*;

public class ENCRYPT01 {
    public static void run() {
        data("tHisIsIEncRawodOOjabUbdgOobsmskkHTWV");
    }
    public static void data(String encrypt){

        //TODO BREAKING APART - CONVERT INTO CHAR
        char[] layer1 = encrypt.toCharArray();
        List<Character> layer2 = new ArrayList<>();

        //TODO LAYER 1 ENCRYPT - ADD TO LIST
        for(int i = layer1.length - 1; i >= 0; i--){
            layer2.add(layer1[i]);
        }

        //TODO LAYER 2 ENCRYPT - CHECK LOWERCASE AND UPPERCASE
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<Character> layer3 = new ArrayList<>();

        for (int i = 0; i < layer2.size(); i++) {
            char currentChar = layer2.get(i);
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
                char[] upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
                for (int j = 0; j < upperAlphabets.length - 1; j++) {
                    if (upperAlphabets[j] == currentChar) {
                        layer3.add(upperAlphabets[j + 1]);
                        break;
                    }
                }
            }
        }

        //TODO LAYER 3
        for(int i = 0; i < layer3.size(); i++){
            if(i % 2 == 0){
                layer3.set(i, Character.forDigit(i/2, layer2.size()));
            }
            else if(i % 3 == 0){
                layer3.set(i,Character.toUpperCase(layer3.get(i)));
            }
        }

        //TODO LAYER 4
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < layer3.size(); i++){
            result.append(layer3.get(i));
        }

        System.out.print(result);
    }
}
