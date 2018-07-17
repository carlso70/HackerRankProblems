package algorithms.strings.twoCharacter;

import java.io.*;

public class Solution {

    // Complete the solve function below.
    static int solve(String s) {
        System.out.println(s);
        return 1;
    }

    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("./src/algorithms/strings/twoCharacter/two-characters-testcases/input" +
                "/input00.txt");
        BufferedReader bufferedReader = new BufferedReader(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = solve(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

