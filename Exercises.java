// Siona Vivian
// 24/7/24
// CS 143
// Lab 6: Recursion
/*
  The following excises is to identify and fix the problems code snippets that
  was provided.
*/
// FOR EXTRA CREDIT: Formartted Pascal's triangle with spaces and did both
//                   LCD and Pascal recursively.

public class Exercises {
  public static void main(String[] args) {
    System.out.println(mystery(3, 50));
    System.out.println(mystery(2, 27));
    System.out.println(fixedSum(1));
    System.out.println(fixedSum(2));
    System.out.println(fixedSum(3));
    System.out.println(fixedSum(4));

  }

  // Multiplies a and b recursively
  public static int mystery(int a, int b) {
    // Base case
    if (b == 1) {
      return a;
    } else {
      // Multiple a by b
      return a + mystery(a, b - 1);
    }
  }

  /*
    The errors is due to not reducing n when calling sum(n) in the else
     statement. Can be fixed by subtracting 1 from n in the call
    return n + sum(n - 1);
   */
  public int brokenSum(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n + brokenSum(n);
    }
  }

  public static int fixedSum(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n + fixedSum(n - 1);
    }
  }
}
