// Siona Vivian
// 24/7/24
// CS 143
// Lab 6: Recursion
/*
  The program is intended to calculate the Least common denominator.
*/
// FOR EXTRA CREDIT: Formartted Pascal's triangle with spaces and did both
//                   LCD and Pascal recursively.

/*
  Sources: https://en.wikipedia.org/wiki/Greatest_common_divisor#Euclidean_algorithm
           https://en.wikipedia.org/wiki/Least_common_multiple#Calculation
 */
import java.util.*;

public class LCD {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(lcd(3, 4, 7, 7)));
    System.out.println(Arrays.toString(lcd(7, 5, 22, 29)));
    System.out.println(Arrays.toString(lcd(3, 4, 48, 18)));
    System.out.println(Arrays.toString(lcd(1, 1, 2, 4)));
    System.out.println(Arrays.toString(lcd(2, 1, 2, 4)));
    System.out.println(Arrays.toString(lcd(5, 11, 12, 18)));
    System.out.println(Arrays.toString(lcd(3, 2, 21, 30)));
    System.out.println(Arrays.toString(lcd(5, 11, 12, 18)));
  }

  // Calculate the Least Common Multiple by using the Greatest Common Denominator
  public static int[] lcd(int numA, int numB, int denA, int denB) {
    int greatest;
    int least;

    // Reduce each fraction individually to prevent too big denominator later
    int[] t = reduceFraction(numA, denA);
    numA = t[0];
    denA = t[1];

    int[] x = reduceFraction(numB, denB);
    numB = x[0];
    denB = x[1];

    if (denA > denB) {
      greatest = denA;
      least = denB;
    } else {
      greatest = denB;
      least = denA;
    }

    // Generate new denominator using the GCD then fills the final array
    int newDen =  denA * denB / gcd(greatest, least)[0];
    int[] temp = {(numA * (newDen / denA)) + (numB * (newDen / denB)), newDen};

    // If the numbers add to 1, return 1 over 1
    if (temp[0] == temp[1]) {
      int[] m = {1, 1};
      return m;
    }

    return temp;
  }

  public static int[] reduceFraction(int a, int b) {
    int reducer = gcd(a, b)[0];
    int[] temp = {a / reducer, b / reducer};
    return temp;
  }

  // Calculates the Greatest Common Denominator between two denominators
  // Final number is always {int, 0}
  public static int[] gcd(int a, int b) {
    if (b == 0) {
      int[] temp = {a, 0};
      return temp;
    }

    return gcd(b, (a % b));
  }
}
