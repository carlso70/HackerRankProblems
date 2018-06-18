package algorithms.implementation.PickingNumbers;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PickingNumbers {

    // Complete the pickingNumbers function below.
    static int pickingNumbers(int[] a) {

        // Find all the pairs of numbers that are one apart, so that you can choose any number in sub array(list) and
        // it's absolute difference with any other member will be <= 1
        int ct = 0;
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> pairLt = new ArrayList<>();
            ArrayList<Integer> pairGt = new ArrayList<>();
            pairGt.add(a[i]);
            pairLt.add(a[i]);
            for (int j = 0; j < a.length; j++) {
                if (i == j) continue;
                if (Math.abs(a[i] - a[j]) <= 1 && a[i] >= a[j]) {
                    pairGt.add(a[j]);
                }
                if (Math.abs(a[i] - a[j]) <= 1 && a[i] <= a[j]) {
                    pairLt.add(a[j]);
                }
            }
            System.out.println(pairGt);
            System.out.println(pairLt);
            if (pairLt.size() > ct)
                ct = pairLt.size();
            else if (pairGt.size() > ct)
                ct = pairGt.size();
        }
        return ct;
    }


    public static void main(String[] args) throws IOException {

        File f = new File("./src/algorithms/implementation/PickingNumbers/picking-numbers-testcases/input/input00.txt");
        Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
