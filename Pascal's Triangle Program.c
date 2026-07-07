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

#include <stdio.h>

void printPascalsTriangle(int numRows) {
    int row[numRows];

    for (int i = 0; i < numRows; i++) {
        row[i] = 1; // rightmost element of current row is always 1

        // update middle elements from right to left
        for (int j = i - 1; j > 0; j--) {
            row[j] = row[j] + row[j - 1];
        }

        // print leading spaces for triangle shape
        for (int s = 0; s < numRows - i - 1; s++) {
            printf("  ");
        }

        // print the row
        for (int j = 0; j <= i; j++) {
            printf("%4d", row[j]);
        }
        printf("\n");
    }
}

int main() {
    int numRows;

    printf("Enter number of rows: ");
    scanf("%d", &numRows);

    if (numRows <= 0) {
        printf("Number of rows must be positive.\n");
        return 1;
    }

    printPascalsTriangle(numRows);

    return 0;
}
