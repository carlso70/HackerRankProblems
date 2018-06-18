package algorithms.implementation.grading_students;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Grading {

    /*
     * Complete the gradingStudents function below.
     * Rounds the grade to the nearest multiple of 5, if the difference between the grade and next multiple of 5
     * round up. Also, if the rounded grade is less that 40 there will be no adjusting
     */
    static int[] gradingStudents(int[] grades) {

        for (int i = 0; i < grades.length; i++) {
            // find the nearest multiple of 5
            int multipleFive = 5 * Math.round(grades[i] / 5);
            if (Math.abs(multipleFive - grades[i]) >= 3 && multipleFive + 5 >= 40) {
                // we want to round to the next multiple of 5
                grades[i] = multipleFive > grades[i] ? grades[i] : multipleFive + 5;
            }
        }

        return grades;
    }

    public static void main(String[] args) throws IOException {

        File f = new File("./src/algorithms/implementation/grading_students/grading-testcases/input/input00.txt");
        Scanner scan = new Scanner(f);

        BufferedWriter bw = new BufferedWriter(new FileWriter("./src/algorithms/implementation/grading_students/output.txt"));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}

