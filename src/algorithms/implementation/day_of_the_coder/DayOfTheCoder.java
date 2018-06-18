package algorithms.implementation.day_of_the_coder;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DayOfTheCoder {

    // Complete the solve function below.
    static String solve(int year) {

        return "";
    }


    public static void main(String[] args) throws IOException {
        File f = new File("./src/algorithms/implementation/day_of_the_coder/day-of-the-programmer-testcases/input/input00.txt");
        Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = solve(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
