import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {

        //file dosyasında dikkat etmemiz gereken mevcut dosyayla ilgilenmiyoruz olmayan dosyayla işlem yapıyoruz.

        File dosya = new File("patika.txt");  //yol belirtmedik




        //DOSYA OLUŞUTURMA
       /*
        try {
           // dosya.createNewFile();   // burda hata aldık enden metoda bakınca, throws IOException miş yada
                                     // try-cath içine alıcaz veya maine throws ekliyebiliriz ama sınıfa throws eklemek mantıksız.
            if (dosya.createNewFile()){
                System.out.println(dosya.getName()+ " Dosyası Oluşturuldu !");
            }
            else {
                System.out.println(dosya.getName()+" Dosyası zaten mevcuttur !");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } */





        //DOSYA SİLME
       // System.out.println(dosya.delete());     //dosyanın silme işlemi yapıldı


        //YOL DİZİMİ EKLEMEK İSTERSEK

        File dizin=new File("test");
        dizin.mkdir(); //dosya oluşturuyor.

        File dosya2 = new File("test/patika.txt");
        try {
            System.out.println(dosya2.createNewFile());  //dosya oluşunca true varsa false dönüyor
        } catch (IOException e) {
            e.printStackTrace();
        }





        //DOSYA YOLU OLUŞTURMA
        File dizin2= new File("patika/dev");
        System.out.println(dizin2.mkdirs());   //Altda demiş olduğum gibi oluşuturdu.
        //System.out.println(dizin2.mkdir());   Burda bize false verdi çünkü mkdir bize en son dosya oluşturur. patika
                                               //patika dosyamız mevcut değil o yüzden "mkdirs()" kullanmamız gereklidir.




        //DİZİNDEKİ ELEMANLARI LİSTELEME
        File dizinList = new File("test"); //hangi dosyanın dizine bakıcaksan onu yazıyorsun
        String [] FileList= dizinList.list();     //dosya isimlerini String türünde Dizi olarak listeliyoruz.
        for (String str: FileList){
            System.out.print(str+ "  ");
        }


    }
}