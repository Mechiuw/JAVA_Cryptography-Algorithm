package algorithm;

public class ENCRYPT02 {
    public static void run() {
        data("simple cryptography method being developed");
    }
    public static void data(String encrypt){
        char[] x = encrypt.toCharArray();
        StringBuilder result = new StringBuilder();
        for(char a : x){
            a+=5;
            result.append(a);
            System.out.print(a);
        }
        System.out.println();
        decrypt(String.valueOf(result));

    }

    public static void decrypt(String decrypt){
        char[] brake = decrypt.toCharArray();
        for(char x : brake){
            x-=5;
            System.out.print(x);
        }
    }
}
