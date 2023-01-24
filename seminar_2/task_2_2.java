package seminar_2;

import java.util.Scanner;

/*
 * Напишите метод, который сжимает строку. 
Пример: aaaabbbcdd → a4b3cd2
 */
public class task_2_2 {
  public static void main(String[] args) {
    Scanner scaner = new Scanner(System.in);
    System.out.println("Введите строку: ");
    String line = scaner.nextLine();

    System.out.println(compressString(line));

    scaner.close();
  }

  public static String compressString(String userString) {
    StringBuilder result = new StringBuilder();
    int count = 0;

    for (int i = 0; i < userString.length() - 1; i++) {
      if (userString.charAt(i) == userString.charAt(i + 1)) {
        count++;
      } else if (userString.charAt(i) != userString.charAt(i + 1)) {
        count++;
        result.append(userString.charAt(i));
        if (count > 1) {
          result.append(count);
        }
        count = 0;
      }
      if (i == userString.length() - 2
          && userString.charAt(userString.length() - 2) != userString.charAt(userString.length() - 1)) {
        result.append(userString.charAt(i));
      } else if (i == userString.length() - 2
          && userString.charAt(userString.length() - 2) == userString.charAt(userString.length() - 1)) {
        count++;
        result.append(userString.charAt(i));
        result.append(count);
      }
    }
    return result.toString();
  }
}
