//Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что во входной
//        структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами.
//        Вывод должен быть отсортирован по убыванию числа телефонов.
import java.util.*;
import java.util.Map.Entry;
public class HomeWork5 {
    public static void main(String[] args) {
        Map<String, List<Integer>> phoneMap = new HashMap<>();
        phoneMap.put("Петров", Arrays.asList(795034554,234576,791361423));
        phoneMap.put("Любимова", Arrays.asList(555464));
        phoneMap.put("Чайка", Arrays.asList(234774, 238765));
        phoneMap.put("Иванов", Arrays.asList(654722,141844,224657,951654));
        System.out.println("Справочник:");
        phoneMap
                .entrySet()
                .stream()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Отсортированный справочник по убыванию числа телефонов:");
        SortedSet<Map.Entry<String, List<Integer>>> sortedset = new TreeSet<Map.Entry<String, List<Integer>>>(
                new Comparator<Entry<String,List<Integer>>>() {
                    @Override
                    public int compare(Entry<String, List<Integer>> arg0,
                                       Entry<String, List<Integer>> arg1) {
                        if (arg0.getValue().size() > arg1.getValue().size())
                            return -1;
                        else if (arg0.getValue().size() < arg1.getValue().size())
                            return 1;
                        else
                            return 1;
                    }
                }
        );
        sortedset.addAll(phoneMap.entrySet());
        for (Map.Entry<String, List<Integer>> em : sortedset){
            System.out.println(em.getKey()+"="+em.getValue());
        }
    }
}
