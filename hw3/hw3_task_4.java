/*
Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:

Разность:
    A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
    B - A = все числа из второй коллекции, которые не содержатся в первой

    Симметрическая разность:
    A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
*/

package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hw3_task_4 {
    public static void main(String[] args) {
        List<Integer> randomListA = createAndFillArrayList(7, 0, 10);
        List<Integer> randomListB = createAndFillArrayList(7, 0, 10);
        System.out.println("Массив чисел А:\n" + randomListA);
        System.out.println("Массив чисел B:\n" + randomListB);
        System.out.println();

        System.out.println("Разность массивов (A - B):\n" + arrayDiff(randomListA, randomListB));
        System.out.println("Разность массивов (B - A):\n" + arrayDiff(randomListB, randomListA));
        System.out.println("Симметрическая разность массивов (A ^ B):\n" + symArrayDiff(randomListB, randomListA));
    }

    /**
     * Метод формирует список и наполняет его случайными числами из заданного
     * диапазона
     * 
     * @param size размер списка (количество чисел)
     * @param min  минимальное значение диапазона
     * @param max  максимальное значение диапазона
     * @return список рандомных чисел
     */
    public static List<Integer> createAndFillArrayList(int size, int min, int max) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }

    /**
     * Метод находит разность между заданными массивами чисел
     * 
     * @param first  первый исходный массив
     * @param second второй исходный массив
     * @return массив элементов первого массива, которые не содержатся во втором
     *         массиве
     */
    public static List<Integer> arrayDiff(List<Integer> first, List<Integer> second) {
        List<Integer> diffList = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            if (!second.contains(first.get(i))) {
                diffList.add(first.get(i));
            }
        }
        return diffList;
    }

    /**
     * Метод находит симметрическую разность между заданными массивами чисел
     * 
     * @param first  первый исходный массив
     * @param second второй исходный массив
     * @return массив, состоящий из чисел первого массива, которые не содержатся во
     *         втором
     *         массиве, и чисел второго массива, которые не содержатся в первом
     */
    public static List<Integer> symArrayDiff(List<Integer> first, List<Integer> second) {
        List<Integer> diffList = new ArrayList<>();
        for (int i = 0; i < second.size(); i++) {
            if (!first.contains(second.get(i))) {
                diffList.add(second.get(i));
            }
        }
        for (int i = 0; i < first.size(); i++) {
            if (!second.contains(first.get(i))) {
                diffList.add(first.get(i));
            }
        }
        return diffList;
    }
}
