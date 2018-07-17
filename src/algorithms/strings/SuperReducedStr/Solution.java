package algorithms.strings.SuperReducedStr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the super_reduced_string function below.
    static String super_reduced_string(String s) {
        if (s.equals("")) return "Empty String";

        StringBuffer buffer = new StringBuffer(s);
        for (int i = 1; i < buffer.length(); i++) {
            if (buffer.charAt(i) == buffer.charAt(i - 1)) {
                // Delete both if they are the same
                buffer.delete(i - 1, i + 1);
                i = 0;
            }

            if (buffer.length() == 0) {
                return "Empty String";
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) throws IOException {
        File f = new File("./src/algorithms/strings/SuperReducedStr/reduced-string-testcases/input/input00.txt");
        final Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        String s = scanner.nextLine();

        String result = super_reduced_string(s);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

