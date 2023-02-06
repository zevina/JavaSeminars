/*
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

package hw5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class hw5_task_2 {
    
    public static void main(String[] args) {
        
        ArrayList<String> employees = new ArrayList<>(Arrays.asList("Иван", "Петр", "Антон", "Анатолий", "Иван", "Антон", "Иван", "Петр", "Иван"));
        Map<String, Integer> countNames = countEmployees(employees);
        printMap(countNames);
    }

    private static Map<String, Integer> countEmployees(ArrayList<String> employees) {
        Map<String, Integer> countNames = new HashMap<>();
        for (String name : employees) {
            if (countNames.containsKey(name)) {
                int value = countNames.get(name) + 1;
                countNames.put(name, value);
            }
            else {
                countNames.put(name, 1);
            }
        }
        return countNames;
    }

    private static void printMap(Map<String, Integer> map) {

        map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);
    }
}
