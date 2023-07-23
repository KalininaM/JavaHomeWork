//Разработать программу, имитирующую поведение коллекции HashSet.
//В программе содать метод add добавляющий элемент, метод toString
//возвращающий строку с элементами множества
// *и метод позволяющий читать элементы по индексу.
//Формат данных Integer.

import java.util.HashMap;
import java.util.Iterator;

public class HomeWork6 {
    public static void main(String[] args) {
        myHashSet<Integer> mySet = new myHashSet<>();

        mySet.add(11);
        mySet.add(809);
        mySet.add(9);
        System.out.println(mySet);
        Iterator<Integer> myIterator = mySet.iterator();
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
        System.out.println(mySet.get(1));
    }
}
class myHashSet<T>{
    private HashMap<T, Object> hashMap = new HashMap<>();
    private static final Object myObject = new Object();
        public boolean add(T value){
            return hashMap.put(value, myObject) == null;
        }
        public boolean remove(T value){
            return hashMap.remove(value) != null;
        }
        public String toString(){
            return hashMap.keySet().toString();
        }
        public Iterator<T> iterator() {
            return hashMap.keySet().iterator();
        }
        public Integer get(Integer index) {
            String[] keyArray = hashMap
                                    .keySet()
                                    .toString()
                                    .replaceAll("[\\[\\]]", "")
                                    .split(",");
            if (index >= 0 && index < hashMap.size()){
                return Integer.parseInt(keyArray[index].trim());
            }
            return null;
        }
}
