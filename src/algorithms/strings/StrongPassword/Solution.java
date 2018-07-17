package algorithms.strings.StrongPassword;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        char[] numbers = "0123456789".toCharArray();
        char[] lower_case = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] special_characters = "!@#$%^&*()-+".toCharArray();

        int num = 0, low = 0, up = 0, spec = 0;
        for (int i = 0; i < n; i++) {
            if (contains(password.charAt(i), numbers)) num = 1;
            if (contains(password.charAt(i), lower_case)) low = 1;
            if (contains(password.charAt(i), upper_case)) up = 1;
            if (contains(password.charAt(i), special_characters)) spec = 1;
        }


        int requiredType = 4 - (num + low + up + spec);
        if (6 - n < requiredType) {
            return requiredType;
        } else {
            return 6 - n;
        }

    }

    static boolean contains(char c, char[] arr) {
        for (char a : arr) {
            if (a == c) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        File f = new File("./src/algorithms/strings/StrongPassword/strong-password-testcases/input/input00.txt");
        final Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(answer);
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
