/*
В файле содержится строка с данными:

[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:

Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/

package hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hw2_task_3 {

    public static void main(String[] args) {
        String fileData = getDataFromFile("hw2/file_3.txt");
        System.out.println(fileData);
        System.out.println();

        List<String> logList = createLogString(formatData(fileData));
        for (String string : logList) {
            System.out.println(string);
        }
    }

    /**
     * Метод считывает данные из файла
     * 
     * @param path путь к файлу
     * @return строка данных
     */
    public static String getDataFromFile(String path) {

        StringBuilder resultLine = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resultLine.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultLine.toString();
    }

    /**
     * Метод форматирует данные из строки
     * 
     * @param data строка данных
     * @return двумерный массив данных
     */
    public static String[][] formatData(String data) {

        data = data.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .replace("{", "")
                .replace("}", "");

        String[] arrData = data.split(", ");

        String[] columnCount = arrData[0].split(",");

        String[][] resarr = new String[arrData.length][columnCount.length];

        String[] parts = new String[columnCount.length];

        for (int i = 0; i < resarr.length; i++) {
            parts = arrData[i].split(",");

            int index = 0;
            for (int j = 0; j < resarr[0].length; j++) {
                index = parts[j].indexOf(":");
                resarr[i][j] = parts[j].substring(index + 1);
            }
        }
        return resarr;
    }

    /**
     * Метод формирует строку на основании данных из двумерного массива
     * 
     * @param arrayData двумерный массив данных
     * @return список форматированных строк
     */
    public static List<String> createLogString(String[][] arrayData) {

        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < arrayData.length; i++) {
            String part = String.format("Студент %s получил %s по предмету %s.", arrayData[i][0], arrayData[i][1],
                    arrayData[i][2]);
            resultList.add(part);
        }

        return resultList;
    }

}