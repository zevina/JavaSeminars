// Пусть дан произвольный список целых чисел, удалить из него чётные числа

package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hw3_task_2 {
    public static void main(String[] args) {
        List<Integer> randomlist = createAndFillArrayList(10, 0, 100);
        System.out.println("Исходный массив чисел:\n" + randomlist);
        System.out.println();

        System.out.println("Отфильтрованный массив чисел:\n" + removeEvenFromList(randomlist));
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
     * Метод удаляет четные числа из исходного списка
     * 
     * @param list исходный список чисел
     * @return отфильтрованный список
     */
    public static List<Integer> removeEvenFromList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }
}