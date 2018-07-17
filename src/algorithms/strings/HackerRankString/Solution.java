package algorithms.strings.HackerRankString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        Stack<Character> hrank = new Stack<>();
        hrank.push('k');
        hrank.push('n');
        hrank.push('a');
        hrank.push('r');
        hrank.push('r');
        hrank.push('e');
        hrank.push('k');
        hrank.push('c');
        hrank.push('a');
        hrank.push('h');

        for (int i = 0; i < s.length(); i++) {
            if (hrank.peek() == s.charAt(i))
                hrank.pop();
            if (hrank.empty())
                return "YES";
        }

        return "NO";
    }


    public static void main(String[] args) throws IOException {
        File f = new File("./src/algorithms/strings/HackerRankString/hackerrank-in-a-string-testcases/input/input00.txt");
        final Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            System.out.println(result);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

