package seminar_3;

import java.util.Comparator;

// сортировка по возрастанию
public class SortRuleMinMax implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // if (o1 < o2) return -1;
        // else if (o1 > o2) return 1;
        // else return 0;
        return o1 - o2;
    }
}