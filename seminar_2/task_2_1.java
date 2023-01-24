
package seminar_2;

import java.util.*;

/**
 * task_2_1
 * Дано число N (>0) и символы c1 и c2.
 * Написать метод, который вернет строку длины N, которая состоит из
 * чередующихся символов c1 и c2, начиная с c1.
 */
public class task_2_1 {
  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int n = getNumberByUser("Введите четное число N (>0): ");
    char c1 = getCharByUser("Введите символ С1: ");
    char c2 = getCharByUser("Введите символ С2: ");
    System.out.println(getString(n, c1, c2));
  }

  public static int getNumberByUser(String text) {
    System.out.print(text);
    return input.nextInt();
  }

  public static char getCharByUser(String text) {
    System.out.print(text);
    String c = input.next();
    return c.charAt(0);
  }

  public static String getString(int x, char a, char b) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < x; i++) {
      if (i % 2 == 0) {
        result.append(a);
      } else {
        result.append(b);
      }
    }
    return result.toString();
  }
}