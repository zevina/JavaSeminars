package hw1;

// ----- подсчёт общего количества вариантов -----

/*
На вход некоторому исполнителю подаётся два числа (a, b).
У исполнителя есть две команды:
- команда 1 (к1): увеличить а в с раз, а умножается на c
- команда 2 (к2): увеличить на d, к a прибавляется d
Написать программу, которая выдаёт набор команд, позволяющий число a
превратить в число b или сообщить, что это невозможно.
Можно начать с более простого – просто подсчёта общего количества вариантов
Подумать над тем, как сделать минимальное количество команд

  Пример 1: а = 1, b = 7, c = 2, d = 1
  ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2

  Пример 2: а = 11, b = 7, c = 2, d = 1
  ответ: нет решения.

*/

public class task_1 {

  public static void main(String[] args) {

    try {
      int a = Library.getNumberByUser("Введите число a: ");
      int b = Library.getNumberByUser("Введите число b: ");
      int c = Library.getNumberByUser("Введите число c (>1): ");
      int d = Library.getNumberByUser("Введите число d (>0): ");

      if (c <= 1 || d <= 0) {
        System.out.println("Некорректный ввод!");
      } else {

        if (b <= a || (b - a) < d) {
          System.out.println("\nНет решений!");
        } else {

          if (b / a < c) {
            System.out.println("\nОдно решение.");
          } else {

            System.out.println("\nОбщее количество вариантов решения: " + CountCommands(a, b, c, d));
          }
        }
      }

    } catch (Exception e) {
      System.out.println("Некорректный ввод!");
    }
  }

  public static int CountCommands(int x, int y, int z, int p) {
    int count = 1;
    int n;

    while (y / z > 1) {
      n = (y / z - x) / p + 1;
      count += n;
      y /= z;
    }
    return count;
  }
}