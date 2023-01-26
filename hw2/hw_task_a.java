
// В файле содержится строка с исходными данными в такой форме:

//             {"name":"Ivanov","country":"Russia","city":"Moscow","age":"null"}

// Требуется на её основе построить и вывести на экран новую строку,в форме SQL запроса:

//             SELECT*FROM students WHERE name="Ivanov"AND country="Russia"AND city="Moscow";

// Для разбора строки используйте String.split.
// Сформируйте новую строку,используя StringBuilder.
// Значения null не включаются в запрос.
// 
// 
//           РЕШЕНИЕ ДЛЯ ФАЙЛА С НЕСКОЛЬКИМИ СТРОКАМИ (для одной строки см. hw_task_1.java)

package hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hw_task_a {

    public static void main(String[] args) {

        List<String> arrayList = getDataFromFile("hw2/file_2.txt");
        String sqlRequest;
        for (String string : arrayList) {
            sqlRequest = createSQLrequest(formatData(string));
            System.out.println(sqlRequest);
        }

    }

    /**
     * Метод считывает данные из файла
     * 
     * @param path путь к файлу
     * @return список строк данных
     */
    public static List<String> getDataFromFile(String path) {
        List<String> arrList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arrList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrList;
    }

    /**
     * Метод форматирует данные из строки в двумерный массив
     * 
     * @param data строка данных
     * @return двумерный массив данных
     */
    public static String[][] formatData(String data) {
        String formatData = data.substring(1, data.length() - 1);
        String[] arrData = formatData.split(",");
        for (int i = 0; i < arrData.length; i++) {
            arrData[i] = arrData[i].substring(1, arrData[i].length() - 1);
        }

        String[][] resarr = new String[arrData.length][2];
        String[] parts;
        int i = 0;
        for (int j = 0; j < resarr.length; j++) {
            parts = arrData[i].split("\":\"");
            i++;
            for (int k = 0; k < resarr[1].length; k++) {
                resarr[j][k] = parts[k];
            }
        }

        return resarr;
    }

    /**
     * Метод формирует SQL запрос на основании данных из двумерного массива
     * 
     * @param arrayData двумерный массив данных
     * @return строка SQL запроса
     */
    public static String createSQLrequest(String[][] arrayData) {
        StringBuilder sqlRequest = new StringBuilder();
        sqlRequest.append("SELECT*FROM students WHERE ");
        List<String> resultList = new ArrayList<>();
        for (int j = 0; j < arrayData.length; j++) {
            if (!arrayData[j][1].equals("null")) {
                String part = String.format("%s=\"%s\"", arrayData[j][0], arrayData[j][1]);
                resultList.add(part);
            }
        }
        sqlRequest.append(String.join(" AND ", resultList));
        return sqlRequest.toString();

    }

}
