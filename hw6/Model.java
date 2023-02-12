package hw6;

import java.time.LocalDate;
import java.util.*;

public class Model {
        public static List<Laptop> createLaptopList() {
                List<Laptop> laptops = new ArrayList<>();

                // наполнение списка ноутбуков
                Laptop laptop = new Laptop("Apple", "MacBook Pro 16",
                                LocalDate.of(2021, 10, 26),
                                "Apple M1 Pro", 16, 512, "MacOS", 175_000);
                laptop.addColor("Grey");
                laptop.addColor("White");
                laptops.add(laptop);

                laptop = new Laptop("Apple",
                                "MacBook Pro 16",
                                LocalDate.of(2021, 10, 13),
                                "Apple M1 Pro", 8, 256, "MacOS", 125_000);
                laptop.addColor("Silver");
                laptops.add(laptop);

                laptop = new Laptop("Huawei",
                                "MateBook X Pro",
                                LocalDate.of(2022, 6, 14),
                                "Intel Core i7-1260P", 16, 1024, "Windows 10", 85_000);
                laptop.addColor("Blue");
                laptops.add(laptop);

                laptop = new Laptop("Honor",
                                "MagicBook Pro",
                                LocalDate.of(2022, 9, 9),
                                "AMD Ryzen 5 4600H", 8, 512, "Windows 10", 90_000);
                laptop.addColor("Silver");
                laptop.addColor("Red");
                laptops.add(laptop);

                laptop = new Laptop("Asus",
                                "TUF Gaming F15",
                                LocalDate.of(2023, 1, 22),
                                "Intel Core i7-11800H", 16, 1024, "Windows 11", 100_000);
                laptop.addColor("Black");
                laptop.addColor("Grey");
                laptops.add(laptop);

                laptop = new Laptop("Lenovo",
                                "Legion 5 Pro",
                                LocalDate.of(2021, 11, 5),
                                "AMD Ryzen 7 6800H", 32, 2048, "без ОС", 185_000);
                laptop.addColor("Black");
                laptop.addColor("Blue");
                laptops.add(laptop);
                return laptops;
        }

        public static List<Laptop> getStringSelection(Map<Integer, String> stringFilter, List<Laptop> laptops) {
                List<Laptop> filterLaptops = new ArrayList<>();
                if (stringFilter.keySet().toArray()[0].equals(1)) {
                        for (Laptop laptop : laptops) {
                                if (laptop.getBrandName().toLowerCase().contains(stringFilter.get(1))) {
                                        filterLaptops.add(laptop);
                                }
                        }
                }
                if (stringFilter.keySet().toArray()[0].equals(2)) {
                        for (Laptop laptop : laptops) {
                                if (laptop.getCpu().toLowerCase().contains(stringFilter.get(2))) {
                                        filterLaptops.add(laptop);
                                }
                        }
                }
                if (stringFilter.keySet().toArray()[0].equals(5)) {
                        for (Laptop laptop : laptops) {
                                if (laptop.getSystemOS().toLowerCase().contains(stringFilter.get(5))) {
                                        filterLaptops.add(laptop);
                                }
                        }
                }
                if (stringFilter.keySet().toArray()[0].equals(6)) {
                        for (Laptop laptop : laptops) {
                                if (laptop.getColor().toLowerCase().contains(stringFilter.get(6))) {
                                        filterLaptops.add(laptop);
                                }
                        }
                }
                return filterLaptops;
        }

        public static List<Laptop> getIntegerSelection(Map<Integer, ArrayList<Integer>> integerFilter, List<Laptop> laptops) {
                List<Laptop> filterLaptops = new ArrayList<>();

                String res = integerFilter.values().toString();
                res = res.substring(2, res.length() - 2);
                String[] result = res.split(", ");
                int[] arr = new int[2];
                for (int i = 0; i < result.length; i++) {
                        arr[i] = Integer.parseInt(result[i]);
                }
                int minValue = arr[0];
                int maxValue = arr[1];
                System.out.println(minValue);
                System.out.println(maxValue);

                if (integerFilter.keySet().toArray()[0].equals(3)) {
                        for (Laptop laptop : laptops) {

                                if (laptop.getRam() >= minValue && laptop.getRam() <= maxValue) {
                                        filterLaptops.add(laptop);
                                }
                        }
                }
                if (integerFilter.keySet().toArray()[0].equals(4)) {
                        for (Laptop laptop : laptops) {

                                if (laptop.getHardDiskSize() >= minValue && laptop.getHardDiskSize() <= maxValue) {
                                        filterLaptops.add(laptop);
                                }
                        }
                }
                if (integerFilter.keySet().toArray()[0].equals(7)) {
                        for (Laptop laptop : laptops) {

                                if (laptop.getPrice() >= minValue && laptop.getPrice() <= maxValue) {
                                        filterLaptops.add(laptop);
                                }
                        }
                }
                return filterLaptops;
        }
}
