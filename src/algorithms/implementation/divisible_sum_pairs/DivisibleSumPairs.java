package algorithms.implementation.divisible_sum_pairs;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DivisibleSumPairs {

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {

        int ct = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if ((ar[i] + ar[j]) % k == 0)
                    ct++;
        return ct;
    }


    public static void main(String[] args) throws IOException {

        File f = new File("./src/algorithms/implementation/divisible_sum_pairs/divisible-sum-pairs-testcases/input" +
                "/input00.txt");
        Scanner scanner = new Scanner(f);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
