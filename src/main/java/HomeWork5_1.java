//Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что во входной
//        структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами.
//        Вывод должен быть отсортирован по убыванию числа телефонов.
import java.util.*;
public class HomeWork5_1 {
    static HashMap<String, ArrayList<Integer>> phoneMap;
    public static void main(String[] args) {
        phoneMap = new HashMap<>();
        addNumber("Ivan", 123);
        addNumber("Ivan", 423);
        addNumber("Ivan", 024);
        addNumber("Ivan", 642);
        addNumber("Olga", 246);
        addNumber("Petr", 594);
        addNumber("Petr", 742);
        addNumber("Petr", 139);

        System.out.println("Справочник:");
        System.out.println(phoneMap);

        System.out.println("Отсортированный справочник по убыванию числа телефонов:");
        phoneMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size() - o1.size()))
                .forEach(System.out::println);

    }
    private static void addNumber (String name, Integer number){
        phoneMap.putIfAbsent(name, new ArrayList<>());
        phoneMap.get(name).add(number);
    }

}
