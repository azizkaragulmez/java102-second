import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


        //Polimorfizm, polimorphism, çok biçimlilik
        Queue <String> q = new LinkedList<>();
        q.add("Aziz");
        q.add("Karagülmez");
        q.offer("Patika");
        q.remove("Karagülmez"); //herhangi bir değer girmezsen ilk elemanı siliyor. index giremeyiz object çünkü

        System.out.println(q.element());  //ilk elemanı vericek


        System.out.println(q.poll());  //ilk elemanı veriyor sonra onu kuyruktan çıkarıyor.

        System.out.println(q.peek());  //ilk elemanı verir ama bu silmez elementle aynı fark göremedik.
        System.out.println("-------------");
        // Queue kuyruk olduğunu biliyoruz, ilk giren ilk çıkar mantığı
        Iterator<String> itr = q.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}