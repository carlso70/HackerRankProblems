package data_struct.arrays.dynamic_arr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {

    /*
     * Complete the dynamicArray function below.
     */
    static int[] dynamicArray(int n, int[][] queries) {
        /*
         * Write your code here.
         */

        List<List<Integer>> seqList = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++)
            seqList.add(new ArrayList<Integer>());

        int lastAnswer = 0;

        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int option = queries[i][0];
            int x = (queries[i][1] ^ lastAnswer) % n;
            int y = queries[i][2];

            if (option == 1) {
                seqList.get(x).add(y);
            } else {
                lastAnswer = seqList.get(x).get(y % seqList.get(x).size());
                System.out.println(lastAnswer);
                answers.add(lastAnswer);
            }
        }

        // Convert answers to int array
        int[] res = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++)
            res[i] = answers.get(i);

        return res;
    }


    public static void main(String[] args) throws IOException {
        File f = new File("./src/data_struct/arrays/dynamic_arr/dynamic-array-testcases/input/input03.txt");
        final Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = dynamicArray(n, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
