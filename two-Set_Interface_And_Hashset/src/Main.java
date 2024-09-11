import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> hSet= new HashSet<>();
        hSet.add(10);        //HashSet'te iki tane 10 olduğu halde bir tane 10 u yazdırıyor. 20 10 30 diyerek.
        hSet.add(20);        //bunların sıralaması neden 20 10 30 dersek ise bunların sıralaması hashlere göre sıralıyor.
        hSet.add(10);        //hafızada örnekğin 20->12313  10->234342 30->234213421 diyerekten ona göre bir sıralamaya yapıyor.
        hSet.add(30);        //istediğimiz kadar deeğer ekliyebiliyoruz aynı değer olmadığı sürece (bir tanesini yazıyor).
        hSet.add(null);      //null değerde atayabiliyoruz.

        System.out.println(hSet.size());         //boyutunu öğreniyoruz. --> çıktısı 4
        System.out.println(hSet.isEmpty());      //içinin boş olup olmadığını sorgular, true false döndürür.
        System.out.println(hSet.contains(20));   //bu sorgulama yapıyor. 20 değeri var mı diye, true false döndürür.
        hSet.remove(10);                      //değeri silme işlemi yapar.
       // hSet.clear();                          //komple silme işlemi yapıyor.

        /*  for(Integer sayi: hSet){
            System.out.println(sayi);
        }*/

        Iterator<Integer> itr = hSet.iterator();   //bu kullanım gezme işlemine yarıyor yani yukardaki forech gibi
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}