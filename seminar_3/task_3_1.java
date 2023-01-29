// Заполнить список десятью случайными числами. 
// Отсортировать список методом sort() и вывести его на экран.

package seminar_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_3_1 {

    public static void main(String[] args) {
        List<Integer> randomlist = fillArrayList(10, 0, 100);
        System.out.println("Исходный массив чисел:\n" + randomlist);
        System.out.println();
        randomlist.sort(new SortRuleMinMax()); // сортировка по возрастанию
        System.out.println(randomlist);
        randomlist.sort(new SortRuleMaxMin()); // сортировка по убыванию
        System.out.println(randomlist);
    }

    /**
     * Метод формирует список и наполняет его случайными числами из заданного диапазона
     * @param size размер списка (количество чисел)
     * @param min минимальное значение диапазона
     * @param max максимальное значение диапазона
     * @return список рандомных чисел
     */
    public static ArrayList<Integer> fillArrayList(int size, int min, int max) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }

}
