// В файле содержится строка с исходными данными в такой форме:

//             {"name":"Ivanov","country":"Russia","city":"Moscow","age":"null"}

// Требуется на её основе построить и вывести на экран новую строку,в форме SQL запроса:

//             SELECT*FROM students WHERE name="Ivanov"AND country="Russia"AND city="Moscow";

// Для разбора строки используйте String.split.
// Сформируйте новую строку,используя StringBuilder.
// Значения null не включаются в запрос.
// 
// 
//                 РЕШЕНИЕ ДЛЯ ФАЙЛА С ОДНОЙ СТРОКОЙ (для нескольких строк см. hw_task_a.java)

package hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hw2_task_1 {

    public static void main(String[] args) {

        String fileData = getDataFromFile("hw2/file_1.txt");
        String sqlRequest = createSQLrequest(formatData(fileData));
        System.out.println(sqlRequest);
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
     * Метод форматирует данные из строки в двумерный массив
     * 
     * @param data строка данных
     * @return двумерный массив данных
     */
    public static String[][] formatData(String data) {
        
        data = data.replace("{", "");
        data = data.replace("}", "");
        data = data.replace("\"", "");

        String[] arrData = data.split(",");
        String[][] resarr = new String[arrData.length][2];
        String[] parts;
        int i = 0;
        for (int j = 0; j < resarr.length; j++) {
            parts = arrData[i].split(":");
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
