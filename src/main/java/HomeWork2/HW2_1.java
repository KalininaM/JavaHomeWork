package HomeWork2;
//1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
//        используя StringBuilder или String. Данные для фильтрации приведены ниже в виде json-строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class HW2_1 {
    public static void main(String[] args) {
        try {
            File file = new File("students");
            if (!file.exists()) {
                String s = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
                FileWriter writer = new FileWriter(file);
                writer.write(s);
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла!");
        }
        String string = readFile(new File("students"));
        System.out.println(string);
        StringBuilder resultQuery = requestCondition(string);
        System.out.println(resultQuery);
    }
    static String readFile(File file){
        StringBuilder result = new StringBuilder();
        String line = "";
        try {
            FileReader reader = new FileReader(file);
            int i;
            while((i = reader.read()) != -1) {
                result.append((char)i);
            }
            return line = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    static StringBuilder requestCondition(String string){
        StringBuilder result = new StringBuilder("select * from students where ");
        String[] sql = string.split(" ");

        boolean firstCondition = true;

        for (String condition : sql) {
            if (condition.contains("null")) {
                continue;
            } else {
                if (!firstCondition) {
                    result.append(" AND ");
                }
                result.append(condition);
                firstCondition = false;
            }
        }

        result = new StringBuilder(result.toString().replace("{", ""));
        result = new StringBuilder(result.toString().replace("}", ""));
        result = new StringBuilder(result.toString().replace(":", "="));
        result = new StringBuilder(result.toString().replace(",", " "));

        return result;
    }
}
