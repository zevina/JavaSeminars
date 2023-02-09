// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.

package hw5;

import java.util.*;

public class hw5_task_1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите данные в формате \"фамилия имя:номер телефона\". Для остановки введите stop: ");
        Map<String, ArrayList<String>> nameToNumbers = fillMap();

        printMap(nameToNumbers);
    }

    private static String[] getUserData() {
        String input = scanner.nextLine();
        String[] resData = input.split(":");
        return resData;
    }

    private static Map fillMap() {
        Map<String, ArrayList<String>> nameToNumbers = new HashMap<>();
        
        while (true) {
            String[] userData = getUserData();
            if (userData[0].equals("stop"))
            break;

            if (nameToNumbers.containsKey(userData[0])) {
                ArrayList<String> values = nameToNumbers.get(userData[0]);
                values.add(userData[1]);
                nameToNumbers.put(userData[0], values);
            }
            else {
                ArrayList<String> values = new ArrayList<>();
                values.add(userData[1]);
                nameToNumbers.put(userData[0], values);
            }
        }
        return nameToNumbers;
    }

    private static void printMap(Map<String, ArrayList<String>> nameToNumbers) {
        for (String name: nameToNumbers.keySet()) {
            String key = name.toString();
            ArrayList<String> values = nameToNumbers.get(name); 
            System.out.println(key + " " + Arrays.toString(values.toArray()));
        }
    }
}
