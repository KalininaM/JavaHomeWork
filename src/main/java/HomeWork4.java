//Организовать ввод и хранение данных пользователей. ФИО возраст, пол и выход из режима ввода информации
//        вывод в формате Фамилия И.О. возраст пол
//        добавить возможность выхода или вывода списка отсортированного по возрасту!)
//        *реализовать сортировку по возрасту с использованием индексов
//        *реализовать сортировку по возрасту и полу с использованием индексов
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class HomeWork4 {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();

        while (true) {
            System.out.println("Введите фамилию -> ");
            family.add(scanner.nextLine());
            System.out.println("Введите имя -> ");
            name.add(scanner.nextLine());
            System.out.println("Введите отчество -> ");
            soname.add(scanner.nextLine());
            System.out.println("Введите возраст -> ");
            age.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Введите пол (М/Ж) -> ");
            gender.add(scanner.nextLine().toLowerCase().contains("ж"));
            id.add(gender.size() - 1);
            System.out.println("Продолжить ввод да/нет? -> ");
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("нет")) break;
        }
        System.out.println();
        System.out.println("Список пользователей");
        for (int i = 0; i < family.size(); i++) {
            System.out.printf("%s %s.%s. %s %s\n", family.get(i), name.get(i).toUpperCase().charAt(0),
                    soname.get(i).toUpperCase().charAt(0), (gender.get(i)) ? "ж" : "м", age.get(i));
        }

        System.out.println();
        // Сортировка по возрасту
        System.out.println("Сортировать по возрасту? Введите \"да\" для " +
                    "выполнения сортировки по возрасту или \"нет\" для выхода из программы: ");
        String selectAge = scanner.nextLine();
        if (selectAge.toLowerCase().contains("да")) {
            id.sort((o1, o2) -> age.get(o1) - age.get(o2));
            System.out.println();
            for (int i = 0; i < id.size(); i++) {
                System.out.printf("%s %s.%s. %s %s\n", family.get(id.get(i)),
                        name.get(id.get(i)).toUpperCase().charAt(0),
                        soname.get(id.get(i)).toUpperCase().charAt(0), (gender.get(id.get(i))) ? "ж" : "м",
                        age.get(id.get(i)));
            }
            System.out.println();
        }
        // Сортировка по возрасту и полу
        System.out.println("Сортировать по возрасту и полу? Введите \"да\" для " +
                "выполнения сортировки по возрасту или \"нет\" для выхода из программы: ");
        String selectAgeGender = scanner.nextLine();
        if (selectAgeGender.toLowerCase().contains("да")) {
            id.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String gen1 = gender.get(o1).toString();
                    String gen2 = gender.get(o2).toString();
                    int isComp = gen1.compareToIgnoreCase(gen2);
                    if (isComp != 0) {
                        return isComp;
                    }
                    return age.get(o1) - age.get(o2);
                }
            });
            for (int i = 0; i < id.size(); i++) {
                System.out.printf("%s %s.%s. %s %s\n", family.get(id.get(i)),
                        name.get(id.get(i)).toUpperCase().charAt(0),
                        soname.get(id.get(i)).toUpperCase().charAt(0), (gender.get(id.get(i))) ? "ж" : "м",
                        age.get(id.get(i)));
            }
        }
    }
}
