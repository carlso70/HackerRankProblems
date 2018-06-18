package algorithms.implementation.cat_and_mouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CatAndMouse {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        if (Math.abs(z - y) == Math.abs(z - x))
            return "Mouse C";
        else if (Math.abs(z - x) < Math.abs(z - y))
            return "Cat A";
        else
            return "Cat B";

    }


    public static void main(String[] args) throws IOException {

        File f = new File("./src/algorithms/implementation/cat_and_mouse/cats-and-a-mouse-testcases/input/input00.txt");
        Scanner scanner = new Scanner(f);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
