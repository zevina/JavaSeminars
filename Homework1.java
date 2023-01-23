
// Написать программу вычисления n-ого треугольного числа

import java.util.*;

public class Homework1 {

  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    try {
      int n = getNumberByUser("Введите натуральное число N: ");
      if (n > 0) {

        int triangleN = (n + 1) * n / 2;
        System.out.println("N-ное треугольное число: " + triangleN);

      } else {
        System.out.println("Число введено некорректно!");
      }

    } catch (Exception e) {
      System.out.println("Некорректный ввод!");
    }
  }

  /**
   * Метод принимает число от пользователя
   * 
   * @param text Сообщение для пользователя
   * @return целое число
   */
  static int getNumberByUser(String text) {
    System.out.print(text);
    return input.nextInt();
  }

}
