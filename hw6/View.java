package hw6;

import java.util.*;

public class View {
    private static Scanner input = new Scanner(System.in);

    public static void printAll(List<Laptop> laptops) {
        // печать списка ноутбуков
        System.out.println("_________________________________________\n\nКаталог ноутбуков:\n");
        for (Laptop l : laptops) {
            System.out.println(l);
        }
    }

    public static void printSelection(List<Laptop> filterLaptops) {
        // печать списка ноутбуков
        if (filterLaptops.size() != 0) {
            System.out.println("_________________________________________\n\nНоутбуки, подходящие под заданный критерий:\n");
            for (Laptop l : filterLaptops) {
                System.out.println(l);
            }
        }
        else System.out.println("_________________________________________\n\nНичего не найдено!\n");
    }

    public static Integer getNumberMainMenu() {
        System.out.print(
                "Выберите команду:\n1 - показать весь список ноутбуков\n2 - отфильтровать ноутбуки по критерию\n\n");
        try {
            Integer select = input.nextInt();
            return select;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getNumberFilterMenu() {
        System.out.print(
                "\nВведите цифру, соответствующую необходимому критерию:\n1 - бренд производителя\n2 - процессор\n3 - объем оперативной памяти\n4 - размер жесткого диска\n5 - операционная система\n6 - цвет\n7 - стоимость\n\n");
        return input.nextInt();
    }

    public static Map<Integer, String> stringFilter(Integer num) {
        Map<Integer, String> stringFilter = new HashMap<>();
        System.out.print("Введите значение критерия:\n");
        String value = input.next().toLowerCase();
        stringFilter.put(num, value);
        return stringFilter;
    }

    public static Map<Integer, ArrayList<Integer>> integerFilter(Integer num) {
        Map<Integer, ArrayList<Integer>> integerFilter = new HashMap<>();
        ArrayList<Integer> values = new ArrayList<>();

        try {
            System.out.print("Введите минимальное значение критерия:\n");
            values.add(input.nextInt());
    
            System.out.print("Введите максимальное значение критерия:\n");
            values.add(input.nextInt());
        } catch (Exception e) {
            System.out.println("Некорректный ввод");
        }

        integerFilter.put(num, values);
        return integerFilter;
    }

}
