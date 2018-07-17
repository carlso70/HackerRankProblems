package algorithms.strings.CaesarCipher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        StringBuffer buffer = new StringBuffer(s);

        for (int i = 0; i < buffer.length(); i++) {
            char c = buffer.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    buffer.setCharAt(i, (char) ('a' + (c - 'a' + k) % 26));
                } else {
                    buffer.setCharAt(i, (char) ('A' + (c - 'A' + k) % 26));
                }
            }
        }


        return buffer.toString();
    }


    public static void main(String[] args) throws IOException {
        File f = new File("./src/algorithms/strings/CaesarCipher/caesar-cipher-1-testcases/input/input03.txt");
        final Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        System.out.println(caesarCipher("f", 98));

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

