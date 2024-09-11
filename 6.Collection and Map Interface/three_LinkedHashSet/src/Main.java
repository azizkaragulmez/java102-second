import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args)
    {
        //HashSet'le ayırtan tek özelliği bunlarda nasıl bir sırayla verirsen öyle bir çıktı alırsın diğerinde rasgele gelebiliyordu.
        LinkedHashSet<Integer> lSet=new LinkedHashSet<>();
        lSet.add(10);
        lSet.add(20);
        lSet.add(30);
        lSet.add(10);

        Iterator<Integer> itr= lSet.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}