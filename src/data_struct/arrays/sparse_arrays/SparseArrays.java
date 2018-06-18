package data_struct.arrays.sparse_arrays;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SparseArrays {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        int i = 0;
        for (String q : queries) {
            for (String s : strings) {
                if (s.equals(q))
                    result[i]++;
            }
            i++;
        }

        System.out.println(Arrays.toString(result));
        return result;
    }


    public static void main(String[] args) throws IOException {
        File f = new File("./src/data_struct/arrays/sparse_arrays/sparse-arrays-testcases/input/input11.txt");
        final Scanner scanner = new Scanner(f);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
