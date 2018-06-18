package data_struct.arrays.left_rotation;

import java.io.File;
import java.util.Scanner;

public class LeftRotation {

    // for shifting use % operator

    private static void leftRotation(int[] a, int d) {
        // d % a.length is the start index,
        for (int i = d % a.length, ct = 0; ct < a.length; i++, ct++) {
            System.out.print(a[i % a.length] + " ");
        }
    }

    public static void main(String[] args) throws Exception {

        File f = new File("./src/data_struct/arrays/left_rotation/array-left-rotation-testcases/input/input00.txt");
        Scanner scanner = new Scanner(f);
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();

        leftRotation(a, d);
    }
}
