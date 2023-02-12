package hw6;

import java.util.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
    }

    public void main() {
        List<Laptop> laptops = model.createLaptopList();
        Integer select = view.getNumberMainMenu();

        if (select == 1) {
            view.printAll(laptops);
        } else if (select == 2) {
            Integer filter = view.getNumberFilterMenu();
            List<Laptop> filterLaptops = new ArrayList<>();
            
            if (filter == 1 || filter == 2 || filter == 5 || filter == 6) {
                Map<Integer, String> stringFilter = view.stringFilter(filter);
                filterLaptops = model.getStringSelection(stringFilter, laptops);
                view.printSelection(filterLaptops);
            } else if (filter == 3 || filter == 4 || filter == 7) {
                filterLaptops = model.getIntegerSelection(view.integerFilter(filter), laptops);
                view.printSelection(filterLaptops);
            } else
                System.out.println("Некорректный ввод");
        } else
            System.out.println("Некорректный ввод!");

    }
}
