package algorithms.dynamic.maximum_subarray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSubArray {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {

        int[] result = new int[2]; // result of max subarray and subsequences

        // Max subarray, uses Kadane's algorithm
        int curMax = arr[0];
        int maxCount = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            maxCount = Math.max(curMax, maxCount);
        }

        result[0] = maxCount;

        // Max subSequence, tip: SORT
        Arrays.sort(arr);
        curMax = arr[0];
        maxCount = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            maxCount = Math.max(curMax, maxCount);
        }

        result[1] = maxCount;

        System.out.println(Arrays.toString(result));

        return result;
    }


    public static void main(String[] args) throws IOException {
        File f = new File("./src/algorithms/dynamic/maximum_subarray/maxsubarray-testcases/input/input03.txt");
        final Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
