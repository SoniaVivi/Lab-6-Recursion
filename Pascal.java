// Siona Vivian
// 24/7/24
// CS 143
// Lab 6: Recursion
/*
  The program is to print Pascal's triangle to the console
*/
// FOR EXTRA CREDIT: Formartted Pascal's triangle with recursive spaces
//                   and did both
//                   LCD and Pascal recursively.
// Sources: https://en.wikipedia.org/wiki/Pascal's_triangle#Calculating_a_row_or_diagonal_by_itself

public class Pascal {
  public static void main(String[] args) {
    calculatePascal(18, 0);
  }

  public static void calculatePascal(int rows, int prevRows) {
    String buffer = repeatSpaces(prevRows);

    if (rows == 0) {
      System.out.print(buffer);
      System.out.print(" 1");
      System.out.println();

    } else {
      calculatePascal(rows - 1, prevRows + 1);
      System.out.print(" " + buffer);

      printEntry(rows, rows);
      System.out.println();
    }
  }

  // print a single cell in a row
  public static int printEntry(int row, int i) {
    int top = (row+1-i);

    // Avoids zero division or bad top
    if (i == 0 || top == 0) {
      System.out.print("1 ");
      return 1;
    }

    int prev = printEntry(row, i - 1);
    int calc = Math.round((top * prev) / i);
    System.out.print(calc + " ");

    return calc;

  }

  public static String repeatSpaces(int count) {
    if (count == 0) {
      return "";
    }

    return " " + repeatSpaces(count - 1);
  }
}
