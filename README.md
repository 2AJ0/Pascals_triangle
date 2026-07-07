# Pascal's Triangle — Multi-Language Implementation

A clean, consistent implementation of **Pascal's Triangle** in five languages: **C, C++, Java, Python, and JavaScript**. All five versions use the exact same underlying algorithm, so you can compare syntax across languages side by side.

## 📐 Algorithm

Instead of recomputing binomial coefficients or using nested arrays, this project builds each row **in-place** from the previous row using a single 1D array:

```
row[j] = row[j] + row[j-1]
```

The update is applied **right to left**, which is what makes the in-place trick work — `row[j-1]` hasn't been overwritten yet when `row[j]` is updated.

**Steps for each row `i` (0-indexed):**
1. Set `row[i] = 1` (the new rightmost element is always 1).
2. For `j` from `i-1` down to `1`: `row[j] += row[j-1]`.
3. Print the row (with leading spaces for the triangular shape).

This gives an **O(n²) time, O(n) space** solution — no extra row arrays, no recursion, no factorial computation.

## 📁 Project Structure

```
├── pascals_triangle.c      # C implementation
├── pascals_triangle.cpp    # C++ implementation
├── PascalsTriangle.java    # Java implementation
├── pascals_triangle.py     # Python implementation
├── pascals_triangle.js     # JavaScript implementation
└── README.md
```

## ▶️ How to Run

### C
```bash
gcc pascals_triangle.c -o pascals_triangle
./pascals_triangle
```

### C++
```bash
g++ pascals_triangle.cpp -o pascals_triangle
./pascals_triangle
```

### Java
```bash
javac PascalsTriangle.java
java PascalsTriangle
```

### Python
```bash
python3 pascals_triangle.py
```

### JavaScript (Node.js)
```bash
node pascals_triangle.js
```

Each program will prompt:
```
Enter number of rows:
```

## 📊 Sample Output (6 rows)

```
              1
            1   1
          1   2   1
        1   3   3   1
      1   4   6   4   1
   1   5  10  10   5   1
```

## ✅ Why This Approach?

| Feature | Benefit |
|---|---|
| In-place row update | Minimal memory usage (single array, no 2D storage) |
| Same logic across languages | Easy to compare syntax and idioms |
| No factorials / no recursion | Avoids overflow and stack depth issues for larger row counts |
| Simple loop structure | Easy to read, extend, or port to other languages |

## 🛠️ Requirements

- **C**: GCC or any standard C compiler
- **C++**: g++ (C++11 or later)
- **Java**: JDK 8+
- **Python**: Python 3.6+
- **JavaScript**: Node.js 12+

## 📄 License

Feel free to use, modify, and share this project for learning purposes.
