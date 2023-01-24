package hw1;

//  ----- минимальное количество команд -----

// Решено совместно с Рябовым Андреем

/**
 * На вход некоторому исполнителю подаётся два числа (a, b).
 * У исполнителя есть две команды
 * - команда 1 (к1): увеличить а в с раз, а умножается на c
 * - команда 2 (к2): увеличить на d, к a прибавляется d
 * Написать программу, которая выдаёт набор команд, позволяющий число a
 * превратить в число b или сообщить, что это невозможно.
 * Можно начать с более простого – просто подсчёта общего количества вариантов
 * Подумать над тем, как сделать минимальное количество команд
 * 
 * Пример 1: а = 1, b = 7, c = 2, d = 1
 * ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2
 * 
 * Пример 2: а = 11, b = 7, c = 2, d = 1
 * ответ: нет решения.
 * 
 */
// import java.util.ArrayList;
// import java.util.List;
import java.util.*;

import seminar_1.Library;

public class task_2 {

  public static void main(String[] args) {
    int a = Library.getNumberByUser("Введите число a: ");
    int b = Library.getNumberByUser("Введите число b: ");
    int c = Library.getNumberByUser("Введите число c: ");
    int d = Library.getNumberByUser("Введите число d: ");

    System.out.println(GetOrderCommands(a, b, c, d));
  }

  /**
   * Метод вычисляет минимальное количество команд для превращения числа y в число
   * x, если это возможно
   * 
   * @param x первое число
   * @param y второе число
   * @param z команда к1: увеличить x в z раз
   * @param p команда к2: увеличить x на число p
   * @return список команд в порядке их выполнения
   */
  public static String GetOrderCommands(int x, int y, int z, int p) {

    List<String> resultList = new ArrayList<>();

    if (y <= x) {
      System.out.println("нет решения");
      return null;

    } else {

      while (y > x) {
        if (y % z == 0 && y / z >= x) {
          y /= z;
          resultList.add("k1");

        } else {
          if ((y - p) >= x) {
            y -= p;
            resultList.add("k2");

          }
        }
      }
      Collections.reverse(resultList);
      String res = String.join(", ", resultList);
      return res;
    }
  }
}
