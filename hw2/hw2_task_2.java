/*
Реализуйте алгоритм сортировки пузырьком числового массива,
результат после каждой итерации запишите в лог-файл. 
*/


package hw2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.*;

public class hw2_task_2 {

    public static void main(String[] args) throws SecurityException, IOException {

        List<Integer> randomlist = fillRandomArrayList(createArrayList(10), 0, 100);

        System.out.println("Исходный массив чисел:\n" + randomlist);
        System.out.println();
        System.out.println("Отсортированный массив чисел:\n" + bubbleSort(randomlist));
    }

    /**
     * Метод формирует пустой список заданного размера
     * 
     * @param size размер списка (количество чисел)
     * @return пустой список
     */
    public static List<Integer> createArrayList(int size) {
        List<Integer> list = new ArrayList<>();
        while (list.size() < size)
            list.add(0);
        return list;
    }

    /**
     * Метод наполняет список случайными числами из заданного диапазона
     * 
     * @param list исходный список
     * @param min  минимальное значение диапазона
     * @param max  максимальное значение диапазона
     * @return список рандомных чисел
     */
    public static List<Integer> fillRandomArrayList(List<Integer> list, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, random.nextInt(min, max));
        }
        return list;
    }

    /**
     * Метод пузырьковой сортировки списка целых чисел (от меньшего к большему)
     * 
     * @param list исходный список чисел
     * @return отсортированный список чисел
     * @throws IOException
     * @throws SecurityException
     */
    public static List<Integer> bubbleSort(List<Integer> list) throws SecurityException, IOException {

        Logger logger = Logger.getLogger(hw2_task_2.class.getName());

        FileHandler fh = new FileHandler("hw2/log.log");
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        boolean f = true;
        while (f) {
            f = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    logger.log(Level.INFO, String.format("\n%d > %d: поменялись местами элементы на позициях %d и %d\n",
                            list.get(i), list.get(i + 1), i, i + 1));

                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    f = true;

                }
            }
        }
        return list;
    }
}
