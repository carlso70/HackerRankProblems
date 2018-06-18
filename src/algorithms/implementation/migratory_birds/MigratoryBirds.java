package algorithms.implementation.migratory_birds;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    // It is guaranteed that each bird is of type 1,2,3,4,5
    static int migratoryBirds(int[] ar) {
        int[] ctArray = new int[5];

        for (int i = 0; i < ar.length; i++) {
            ctArray[ar[i] - 1]++;
        }

        int maxCt = 0;
        int type = 0;
        for (int i = 0; i < ctArray.length; i++)
            if (maxCt < ctArray[i]) {
                maxCt = ctArray[i];
                type = i + 1;
            }
        return type;
    }


    public static void main(String[] args) throws IOException {
        File f = new File("./src/algorithms/implementation/migratory_birds/migratory-birds-testcases/input" +
                "/input00.txt");
        Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}