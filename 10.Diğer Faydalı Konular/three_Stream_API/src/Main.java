import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(12);
        list.add(3);
        list.add(89);
        list.add(25);
        list.add(25);

        /*for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        for (Integer i:list){
            System.out.println(i);
        }Yukardakilerden farklı Stream Apı ile çalışabiliriz,Lambda excreption kullanmış olduk*/

        list.stream().forEach(i-> System.out.println(i));  //aynı çıktıyı verir
        list.forEach(i-> System.out.println(i));      //direk kendi üzerinden de oluyor


        System.out.println("###############################################");
        //DİĞER BİR ÖZELLİĞİ FİLTRELEME
        list.stream().filter(num -> num>60).forEach(i -> System.out.println(i)); //i ler num da olur farklıda sadece ikisi aynı olmak zorunda


        System.out.println("###############################################");
        //DİĞER BİR ÖZELLİK BİR DEĞERİ BİR KEZ ALMA
        list.stream().distinct().forEach(i-> System.out.println(i));


        System.out.println("###############################################");
        //DİĞER BİR ÖZELLİK BİR DEĞERİ SIRALAMA
        list.stream().sorted().forEach(i-> System.out.println(i));  //sıralama
        list.stream().distinct().sorted().forEach(i-> System.out.println(i));   //bir kez alıp sıralama
        list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(i-> System.out.println(i));  //bir kez alıp tersine sırlama


        System.out.println("###############################################");
        //DİĞER BİR ÖZELLİK BİR DEĞERİN ALCAĞI ELEMAN SAYISI SINIRLAMA
        list.stream().limit(5).forEach(i-> System.out.println(i)); //ilk 5 elemanı alır


        System.out.println("###############################################");
        //DİĞER BİR ÖZELLİK ELEMAN ATLAMA
        list.stream().skip(3).limit(5).forEach(i-> System.out.println(i));//ilk 3 elemanı atla sonra 5 tane eleman al


        System.out.println("###############################################");
        //DİĞER BİR ÖZELLİK ELEMAN SAYISI ÖĞRENME
        long c= list.stream().skip(3).limit(5).count();  //count işlemi bitir o yüzden forech kullanmıyoruz
        System.out.println(c);


        System.out.println("###############################################");
        //DİĞER BİR ÖZELLİK ELEMAN VARMI
        boolean control= list.stream().anyMatch(i-> i==25);   //true false döndürür 25 elamanı varmı diye soruyoruz
        System.out.println(control);

        System.out.println("#####################################");
        //DİĞER BİR ÖZELLİK ELEMANMI
        boolean control2= list.stream().allMatch(i-> i==25);   //true false döndürür 25 elamanı mı diye hepsi 25 olması şartı koyar
        System.out.println(control2);


        System.out.println("#####################################");
        //DİĞER BİR ÖZELLİK ELEMANMI HİÇ BİRİ ŞARTTAN GEÇMİYORSA
        boolean control3= list.stream().noneMatch(i->i<0);  //allMatch tersi
        System.out.println(control3);


        System.out.println("#####################################");
        //DİĞER BİR ÖZELLİK BÜTÜN ELEMANLARA İŞLEM YAPABİLİYORUZ
        list.stream().map(i->i *2).forEach(i-> System.out.println(i)); //hepsini 2 le çarpıyor
        list.stream().map(i->Math.sqrt(i)).forEach(i-> System.out.println(i));  //kare kökünü alma

        //DAHA VARDIR ÖZELLİK AMA BAKILIR, LİSTELERDE İŞLEM YAPMAMIZI KOLAYLAŞTIRIR, LAMBDA DA KULLANIYORUZ PEKİŞİYOR.



    }
}