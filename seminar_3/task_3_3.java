// Создать список типа ArrayList<String>.
// Поместить в него как строки, так и целые числа. 
// Пройти по списку, найти и удалить целые числа.


package seminar_3;

import java.util.ArrayList;
import java.util.List;

public class task_3_3 {
    public static void main(String[] args) {
        List stringAndNumbers = new ArrayList<String>();
        stringAndNumbers.add("Moscow");
        stringAndNumbers.add(125);
        stringAndNumbers.add(45);
        stringAndNumbers.add(125);
        stringAndNumbers.add(453);
        stringAndNumbers.add(79565);
        stringAndNumbers.add(13785);
        stringAndNumbers.add("Novosibirsk");
        stringAndNumbers.add(613);
        stringAndNumbers.add("Kazan");
        stringAndNumbers.add(687543);

        for (int i = 0; i < stringAndNumbers.size(); i++) {
            if (stringAndNumbers.get(i) instanceof Integer) {
                stringAndNumbers.remove(i);
                i--;
            }
        }
        System.out.println(stringAndNumbers);
    }
}
