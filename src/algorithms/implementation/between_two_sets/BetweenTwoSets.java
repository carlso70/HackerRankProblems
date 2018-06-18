package algorithms.implementation.between_two_sets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BetweenTwoSets {

    // Euclidean algorithm for GCD
    static private int gcd(int a, int b) {
        if (a == 0) return Math.abs(b);
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /*
     * Complete the getTotalX function below.
     * O(n log(n)) solution.
     * 1. find the LCM of all the integers of array A.
     * 2. find the GCD of all the integers of array B.
     * 3. Count the number of multiples of LCM that evenly divides the GCD.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */

        // 1. Find the LCM of a[]
        int lcm = 1;
        for (int i = 0; i < a.length; i++) {
            lcm = lcm(a[i], lcm);
        }


        // 2. Find the GCD of b[]
        int gcd = 0;
        for (int i = 1; i < b.length; i++) {
            gcd = gcd(b[i], gcd);
        }


        if (lcm > gcd) return 0;
        if (gcd % lcm != 0) {
            return 0;
        }

        // 3. Count the number of multiples of LCM that evenly divides the GCD
        int totalX = 0;
        for (int i = gcd; i > lcm; i--)
            if (i % lcm == 0 && gcd % i == 0)
                totalX++;

        return totalX;
    }


    public static void main(String[] args) throws IOException {

        File f = new File("./src/algorithms/implementation/between_two_sets/between-two-sets-testcases/input" +
                "/input00.txt");
        Scanner scan = new Scanner(f);

        BufferedWriter bw = new BufferedWriter(new FileWriter("./src/algorithms/between_two_sets.txt"));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
