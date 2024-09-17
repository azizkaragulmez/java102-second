import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {

        //ARALARINDA Kİ FARK LİNKEDLİSTLERDE ARAYA ELEMAN EKLEMEK MALİYETİ DÜŞÜK.
        //ARRAYLİSTLERDE İSE ARAMA ELEMANI BULMA DAHA HIZLI.
        //HANGİSİNİ KULLANMAK GEREKTİĞİ YAZILIMCIYA KALMIŞ HANGİSİ PROJESİNE UYGUNSA ONU KULLANMALI.

        List<String> liste=new LinkedList<>();

        liste.add("Aziz");
        liste.add("Aziz");
        liste.add("Karagülmez");
        liste.add("Java");
        liste.add("102");

        liste.remove("Aziz");  //bulduğu ilk Aziz'i siliyor.
        liste.remove(2);    //index ile de sildirebiliyoruz.

        liste.add(2,"Krglmz");
        System.out.println(liste.get(2));

        Iterator<String> itr = liste.iterator();   //for gibi düşünüyoruz.
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        for (String str: liste){
            System.out.println(str);
        }
    }
}