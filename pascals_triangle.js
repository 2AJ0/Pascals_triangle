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

const readline = require("readline");

function printPascalsTriangle(numRows) {
    const row = new Array(numRows).fill(0);

    for (let i = 0; i < numRows; i++) {
        row[i] = 1; // rightmost element of current row is always 1

        // update middle elements from right to left
        for (let j = i - 1; j > 0; j--) {
            row[j] = row[j] + row[j - 1];
        }

        // leading spaces for triangle shape
        const spaces = "  ".repeat(numRows - i - 1);

        // build the row string
        let rowStr = "";
        for (let j = 0; j <= i; j++) {
            rowStr += row[j].toString().padStart(4, " ");
        }

        console.log(spaces + rowStr);
    }
}

function main() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question("Enter number of rows: ", (answer) => {
        const numRows = parseInt(answer, 10);

        if (isNaN(numRows) || numRows <= 0) {
            console.log("Number of rows must be positive.");
        } else {
            printPascalsTriangle(numRows);
        }

        rl.close();
    });
}

main();
