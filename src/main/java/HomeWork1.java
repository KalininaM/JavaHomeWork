//Первый семинар.
// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//Пункты реализовать в методе main
//*Пункты реализовать в разных методах

import java.util.Random;
public class HomeWork1 {

    public static void main(String[] args) {
        int i = new Random().nextInt(2000);
        System.out.println("Случайное число i =  " + i);
        int n = Integer.highestOneBit(i);
        System.out.println("Номер старшего значащего бита выпавшего числа n =  " + n);

        int[] m1 = multiples(n, i);
        System.out.println("Числа, кратные n (" +n+ ") в диапазоне от " + i + " до " + Short.MAX_VALUE + ":");
        printArray(m1);
        int[] m2 = notMultiples(n, i);
        System.out.println("Числа, некратные n (" +n+ ") в диапазоне от " + Short.MIN_VALUE + " до " + i + ":");
        printArray(m2);
    }
    static int[] multiples(int n, int i) {
         int count = 0;
         for (int j = i; j < Short.MAX_VALUE; j++) {
             if (j % n == 0) {
                count++;
             }
         }
        int[] m1 = new int[count];
         count = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[count++] = j;
            }
        }
         return m1;
    }
    static int[] notMultiples(int n, int i) {
        int count = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                count++;
            }
        }
        int[] m2 = new int[count];
        count = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                m2[count++] = j;
            }
        }
        return m2;
    }
    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
