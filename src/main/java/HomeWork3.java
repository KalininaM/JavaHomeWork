//Пусть дан произвольный список целых чисел.
//
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение

import java.util.ArrayList;
import java.util.Random;

public class HomeWork3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            list.add(new Random().nextInt(100));
        }
        System.out.println("Произвольный список целых чисел: ");
        System.out.println(list);

        delEvenNumbers(list);
        minValue(list);
        maxValue(list);
        avarageValue(list);
    }
    static void delEvenNumbers (ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % 2 == 0) {
                temp.add(list.get(i));
            }
        }
        list.removeAll(temp);
        System.out.println("1. Список без четных чисел: ");
        System.out.println(list);
    }
    static void minValue(ArrayList<Integer> list){
        Integer minValue = list.get(0);
        for (int i = 0; i < list.size(); i ++){
            if (list.get(i) < minValue){
                minValue = list.get(i);
            }
        }
        System.out.println("2. Минимальное значение: " + minValue);
    }
    static void maxValue(ArrayList<Integer> list){
        Integer maxValue = list.get(0);
        for (int i = 0; i < list.size(); i ++){
            if (list.get(i) > maxValue){
                maxValue = list.get(i);
            }
        }
        System.out.println("3. Максимальное значение: " + maxValue);
    }
    static void avarageValue(ArrayList<Integer> list){
        double avarageValue = 0;
        if (list.size() > 0)
        {
            double sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            avarageValue = sum / list.size();
        }
        System.out.println("4. Среднее значение: " + avarageValue);
    }
}
