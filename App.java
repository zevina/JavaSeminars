/* Этапы решения любой задачи:

1. Уточнять ТЗ
2. Декомпозиция
    2.0 Ввод числа
    2.1 Создание массива
    2.2 Заполнение массива
    2.4 Печать результата
    2.3 Получение только четных чисел
    2.5 Получение кол-ва четных чисел
3. Алгоритм
4. Код
5. Тесты

 */

// Дан массив чисел, нужно сформировать новую выборку из только четных чисел

// package course.geekbrains;

//import course.geekbrains.Library;

//import java.util.Arrays;
//import java.util.List;
//import java.util.*;
//import java.lang.Math;

public class App {

  public static void main(String[] args) {

    int len = Library.getNumberByUser("Введите количество элементов: ");
    int[] items = Library.createArray(len);
    Library.fillArray(items, 0, 10);
    System.out.println(Library.print("Исходный массив: ", items, " "));

    int evenCount = Library.getCountEvenItems(items);
    int[] evenItems = Library.getEvenItems(items, evenCount);
    System.out.println(Library.print("Массив четных чисел: ", evenItems, " "));

  }
}
