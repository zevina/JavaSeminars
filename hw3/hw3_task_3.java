// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое этого списка.

package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hw3_task_3 {
    public static void main(String[] args) {
        List<Integer> randomlist = createAndFillArrayList(10, 0, 100);
        System.out.println("Массив целых чисел: " + randomlist);
        System.out.println();
        System.out.println("Минимальное значение списка: " + MinOfList(randomlist));
        System.out.println("Максимальное значение списка: " + MaxOfList(randomlist));
        System.out.printf("Среднее арифметическое значение списка: %.2f", avgValue(randomlist));

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
     * Метод находит минимальное значение в заданном списке
     * 
     * @param list список значений
     * @return минимальное значение
     */
    public static int MinOfList(List<Integer> list) {
        int minValue = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < minValue) {
                minValue = list.get(i);
            }
        }
        return minValue;
    }

    /**
     * Метод находит максимальное значение в заданном списке
     * 
     * @param list список значений
     * @return минимальное значение
     */
    public static int MaxOfList(List<Integer> list) {
        int maxValue = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                maxValue = list.get(i);
            }
        }
        return maxValue;
    }

    /**
     * Метод возвращает среднее арифметическое значение заданного списка
     * 
     * @param list список
     * @return среднее арифметическое значение
     */
    public static double avgValue(List<Integer> list) {
        double sumValues = 0;
        for (int i = 0; i < list.size(); i++) {
            sumValues += list.get(i);
        }
        double avgValue = sumValues / list.size();
        return avgValue;
    }

}
