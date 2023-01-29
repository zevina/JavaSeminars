// Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. 
// 1. Вывести название каждой планеты и количество его повторений в списке.
// 2. Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.

package seminar_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task_3_2 {
    public static void main(String[] args) {
        List<String> planets = Arrays.asList("Меркурий", "Венера", "Земля", "Земля", "Меркурий", "Марс", "Юпитер",
                "Земля", "Меркурий");

        System.out.println(planets);
        List<String> planetNames = new ArrayList<>();
        List<Integer> planetCount = new ArrayList<>();

        for (String planet : planets) {
            if (!planetNames.contains(planet)) {
                planetNames.add(planet);
                planetCount.add(1);
            } else {
                int index = planetNames.indexOf(planet);
                planetCount.set(index, planetCount.get(index) + 1);
            }
        }

        for (int i = 0; i < planetNames.size(); i++) {
            System.out.printf("%s - %d\n", planetNames.get(i), planetCount.get(i));
        }

        planets = removeDuplicates(planets);
        System.out.println(planets);
    }

    /**
     * Метод удаляет повторяющиеся элементы исходного списка
     * @param list исходный список 
     * @return список неповторяющихся элементов исходного списка
     */
    public static List<String> removeDuplicates(List<String> list) {
        List<String> items = new ArrayList<String>();
        for (String item : list) {
            if (!items.contains(item)) {
                items.add(item);
            }
        }
        return items;
    }
}
