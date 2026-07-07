"""
Pascal's Triangle
------------------
Logic: We build each row in-place from the previous row.
For a row of size (i+1), we start with 1 at the ends, and update
middle elements from RIGHT to LEFT using:
     row[j] = row[j] + row[j-1]
This works in-place because row[j-1] (needed for the update)
has not been overwritten yet when we move right-to-left.
"""


def print_pascals_triangle(num_rows):
    row = [0] * num_rows

    for i in range(num_rows):
        row[i] = 1  # rightmost element of current row is always 1

        # update middle elements from right to left
        for j in range(i - 1, 0, -1):
            row[j] = row[j] + row[j - 1]

        # leading spaces for triangle shape
        spaces = "  " * (num_rows - i - 1)

        # build the row string
        row_str = "".join(f"{row[j]:4d}" for j in range(i + 1))

        print(spaces + row_str)


def main():
    num_rows = int(input("Enter number of rows: "))

    if num_rows <= 0:
        print("Number of rows must be positive.")
        return

    print_pascals_triangle(num_rows)


if __name__ == "__main__":
    main()
