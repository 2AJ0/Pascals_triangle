/*
 * Pascal's Triangle
 * ------------------
 * Logic: We build each row in-place from the previous row.
 * For a row of size (i+1), we start with 1 at the ends, and update
 * middle elements from RIGHT to LEFT using:
 *      row[j] = row[j] + row[j-1]
 * This works in-place because row[j-1] (needed for the update)
 * has not been overwritten yet when we move right-to-left.
 */

import java.util.Scanner;

public class PascalsTriangle {

    static void printPascalsTriangle(int numRows) {
        long[] row = new long[numRows];

        for (int i = 0; i < numRows; i++) {
            row[i] = 1; // rightmost element of current row is always 1

            // update middle elements from right to left
            for (int j = i - 1; j > 0; j--) {
                row[j] = row[j] + row[j - 1];
            }

            // print leading spaces for triangle shape
            StringBuilder sb = new StringBuilder();
            for (int s = 0; s < numRows - i - 1; s++) {
                sb.append("  ");
            }

            // print the row
            for (int j = 0; j <= i; j++) {
                sb.append(String.format("%4d", row[j]));
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int numRows = scanner.nextInt();

        if (numRows <= 0) {
            System.out.println("Number of rows must be positive.");
            scanner.close();
            return;
        }

        printPascalsTriangle(numRows);
        scanner.close();
    }
}
