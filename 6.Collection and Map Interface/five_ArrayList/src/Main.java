import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //ÇOK KULLANILCAK BİR YAPI

        // ArrayList<Integer> liste= new ArrayList<>();   Böylede gösterim sağlanıyor. Yazılımcıya kalmış.
        List<Integer> liste = new ArrayList<>();      //java içinde tanımlanan capacity'si 10 dur. 10 dan fazla olursa 20,30 diye artıyor.

        liste.add(10);     //eleman ekleme Set'ler de olduğu gibi.
        liste.add(1);
        liste.add(4);
        liste.add(5);      //tekrar eden değerli bu ArrayList gösteriyor diğerlerinde ki gibi bir kere almıyor.
        liste.add(5);
        liste.add(5);
        liste.add(null);   //bunlar da null bir ekleme yapılıyor.

        Iterator<Integer> itr = liste.iterator();
        while (itr.hasNext()) {              //itr.hasNext() bir sonraki değerini yazdır demek.
            System.out.println(itr.next());
        }


        //iterator kullanmadan bizim için listeliyor.
        System.out.println(liste);

        //listenin boyutunu bize söyler
        System.out.println(liste.size());

        //get ile listeden eleman okuması yapılıyor index numarasını girilen değeri getiriyor.
        System.out.println(liste.get(2));

        //Verilen bir nesnenin listede hangi indiste tutulduğunu bulur. "lastındexOf" tekrar edenin en sonuncu indexini verir.
        System.out.println(liste.indexOf(5));
        System.out.println(liste.lastIndexOf(5));

        //burda ise bir değer ekliyebiliyoruz mesela 2. indexe ekliyebiliyoruz ve 2. indexteki değer 3. indexe kayıyor.
        liste.add(2, 15);
        liste.add(3, 12);  //sette değiştirmekti bildiğimiz üzere 3. indextekini 12 yapıyor.


        //contains arama işlemine yarıyor bu değer liste'de var mı diye
        System.out.println(liste.contains(10));

        //bir elemanı silme işlemi yapıyor. Silince index değerlerini yeniden düzenliyor.
        System.out.println(liste.remove(1));


        System.out.println("**********************************************");


        //bir listeyi başka bir listeye ekleme
        List<String> liste1 = new ArrayList<>();
        liste1.add("Antalya");
        liste1.add("Isparta");
        liste1.add("Konya");

        List<String> list2 = new ArrayList<>();
        list2.add("Burdur");   //üstüne değer ekliyebiliyoruz.
        //list2.addAll(0,liste1);    //buda bize başa atar liste1 i sonra burduru yazar öylede olur. bilmek için yazdım
        list2.addAll(liste1);  //liste1 i liste2 ye ekle demek
        System.out.println(list2);


        System.out.println("************************************");


        List<String> liste3 = liste1.subList(2, 3);   //listenin sadece 2'den başlayıp 4. indexe kadar. Yani listenin alt listlerinide alabiliyorum demek
        System.out.println(liste3);


        // toArray fonksiyonu parametresiz çağırırsanız Object tipinde bir dizi döner.
        Object[] objectArray = liste3.toArray();

        // toArray fonksiyonuna hangi tipte bir dizi oluşturmak istiyorsak,
        // o tipten bir nesne üretip parametre olarak göndeririz.
        // String tipinden bir dizi almak istediğimiz için "new String[0]" şeklinde bir nesne üretip, "toArray" fonksiyonuna gönderdik.
        String[] stringArray = liste3.toArray(new String[0]);

        //hepsini silmeye yarıyor
        liste.clear();

    }
}