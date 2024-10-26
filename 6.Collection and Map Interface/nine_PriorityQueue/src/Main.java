import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)
    {
        PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); //burda karşılaştırma yapıyoruz dedi, normalde return 01 'di.
            }
        }.reversed());  //reversed() diyerek tersen bir kullanım yaptık.

        q.add("Aziz");
        q.add("Karagülmez");
        q.add("Ahmet");
        q.add("Sultan");

        Iterator<String> itr= q.iterator();   //while ile birlikte Iterator yazıp bir sonraki eleman varmı diye kontrol edib varsa diğerine geç deriz.
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("**************");

        for (String s: q){
            System.out.println(s);
        }


    }
}