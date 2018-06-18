package algorithms.implementation.MagicSquare;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        // t[][] is all 8 magic squares from left-right, top-bottom

        int cost[] = {0, 0, 0, 0, 0, 0, 0, 0};
        int t[][] = {
                {4, 9, 2, 3, 5, 7, 8, 1, 6},
                {4, 3, 8, 9, 5, 1, 2, 7, 6},
                {2, 9, 4, 7, 5, 3, 6, 1, 8},
                {2, 7, 6, 9, 5, 1, 4, 3, 8},
                {8, 1, 6, 3, 5, 7, 4, 9, 2},
                {8, 3, 4, 1, 5, 9, 6, 7, 2},
                {6, 7, 2, 1, 5, 9, 8, 3, 4},
                {6, 1, 8, 7, 5, 3, 2, 9, 4},
        };

        // The loop calculates and keeps track of abs difference between the input magic square and all real squares
        // at index X from left to right, top to bottom

        for (int i = 0; i < 8; i++) {
            cost[i] = Math.abs(t[i][0] - s[0][0]) + Math.abs(t[i][1] - s[0][1]) + Math.abs(t[i][2] - s[0][2]);
            cost[i] += Math.abs(t[i][3] - s[1][0]) + Math.abs(t[i][4] - s[1][1]) + Math.abs(t[i][5] - s[1][2]);
            cost[i] += Math.abs(t[i][6] - s[2][0]) + Math.abs(t[i][7] - s[2][1]) + Math.abs(t[i][8] - s[2][2]);
        }

        // After calculating the absolute differences for each value at each location for all 8 of the possible
        // Magic Square solutions, the costs array is sorted from least to greatest.
        Arrays.sort(cost);
        //System.out.println(cost[0]);
        return cost[0];
    }


    public static void main(String[] args) throws IOException {
        File f = new File("./src/algorithms/implementation/MagicSquare/magic-square-forming-testcases/input" +
                "/input01.txt");
        Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

