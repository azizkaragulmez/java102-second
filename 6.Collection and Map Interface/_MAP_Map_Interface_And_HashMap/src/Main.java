import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> country = new HashMap<>();
        Map<String, String> country2 = new HashMap<>();  //yukardakide bu da farketmez bilelim görelim diye ama yukardakini gösterdi.


        country.put("TR", "Türkiye");
        country.put("TR", "TürkiyeYeni");  //şimdi çağırdığımız da bu gelicek key(anahtar kelime) yazınca neden? çünkü en son
        //girilen değer olduğu için set'e gerek olmamış oluyor.
        country.put("GR", "Almanya");
        country.put("EN", "İngiltere");
        country.replace("GR","Alamanya"); //değiştirdik

        
        // country.remove("GR"); //siliyorz. hem key hem value verebiliyoruz.
        System.out.println(country.get("GR")); //null değeri veriyor

        System.out.println(country.size());  //boyutunu da öğrenebilioruz (2 sildik yukarda ondan)
        System.out.println(country.get("TR"));
        //country.clear();

        //maplarda itr yok for veya forech ile gezebilirsin
        //bunlarda bir sıralama yok nasıl girdiyse o sırada çıkar mantığı yok
        for (String countryKey : country.keySet()) {  //keySet olmasının nedeni country kümesini getir demek istiyoruz.
            System.out.println(countryKey);                 //burda TR GR
           // System.out.println(country.get(countryKey));   //burda da Türkiye Almanya diye vericek
        }
        System.out.println("----------------------------------------------------------");
        //burda valuelarını yazdırdık
        for (String countryValue : country.values())   //bunda da values kullanılmakta
        {
            System.out.println(countryValue);
        }
        System.out.println( country.containsKey ( "TR"));

    }
}