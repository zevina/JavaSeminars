
package hw1;

import java.util.*;

public class Library {
  private static Random random = new Random();
  private static Scanner input = new Scanner(System.in);

  // Ввод числа

  /**
   * Метод принимает число от пользователя
   *
   * @param text Сообщение для пользователя
   * @return число
   */
  public static int getNumberByUser(String text) {
    System.out.print(text);
    return input.nextInt();
  }

  // Создание массива

  /**
   * Этот метод создает новый массив
   *
   * @param size размер массива
   * @return новый массив
   */
  static int[] createArray(int size) {
    return new int[size];
  }

  // Заполнение массива

  /**
   * Метод заполняет исходный массив случайными числами из заданного диапазона
   *
   * @param col пустой массив для заполнения
   * @param min минимальное значение диапазона
   * @param max максимальное значение диапазона
   */
  static void fillArray(int[] col, int min, int max) {
    int count = col.length;
    int index = 0;
    while (index < count) {
      col[index] = random.nextInt(min, max);
      index = index + 1;
    }
  }

  // Получение кол-ва четных чисел

  /**
   * Метод считает количество четных чисел в массиве
   *
   * @param array исследуемый массив
   * @return количество четных чисел в массиве
   */
  static int getCountEvenItems(int[] array) {
    int length = array.length;
    int count = 0;
    for (int i = 0; i < length; i++) {
      if (array[i] % 2 == 0)
        count++;
    }
    return count;
  }

  // Получение массива из только четных чисел

  /**
   * Метод формирует новый массив четных чисел из исходного массива
   *
   * @param rawData           исходный массив
   * @param countEvenElements количество четных чисел в исходном массиве
   * @return новый массив
   */
  static int[] getEvenItems(int[] rawData, int countEvenElements) {
    int count = rawData.length;
    int[] evenItems = Library.createArray(countEvenElements);

    int k = 0;

    for (int i = 0; i < count; i++) {
      if (rawData[i] % 2 == 0) {
        evenItems[k] = rawData[i];
        k++;
      }
    }
    return evenItems;
  }

  // Печать результата

  /**
   * Метод формирует строку из массива с заданным разделителем для вывода в
   * консоль
   *
   * @param text пояснительный текст
   * @param data заданный массив
   * @param sep  разделитель
   * @return строка
   */
  static String print(String text, int[] data, String sep) {
    String output = text;
    int count = data.length;

    int index = 0;
    while (index < count) {
      output += data[index] + sep;
      index = index + 1;
    }
    return output;
  }

}

// Способ работы с файлом, когда происходит автоматическое закрытие файла

// import java.io.FileWriter;
// import java.io.IOException;

// try(FileWriter fileWriter = new FileWriter("file.txt")) {
// fileWriter.append("TEST ".repeat(100)); // что-то, что нужно добавить в фалй
// } catch (IOException ex) {
// System.out.println("Не удалось открыть файл");
// }