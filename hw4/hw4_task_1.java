// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
// Arrays.asList(11, 22, 33, 44, 55)

package hw4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class hw4_task_1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<String> userList = getUserList();

        System.out.println();
        System.out.println("Исходный список: " + Arrays.toString(userList.toArray()));
        System.out.println();
        System.out.println("Развернутый список: " + Arrays.toString(reverseList(userList).toArray()));
    }

    private static LinkedList<String> getUserList() {
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Введите элемент списка (по окончании введите stop): ");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("stop"))
                break;
            list.add(input);
        }
        return list;
    }

    private static LinkedList<String> reverseList(LinkedList<String> list) {
        LinkedList<String> newList = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            newList.addLast(list.get(list.size() - 1 - i));
        }

        return newList;
    }

}
