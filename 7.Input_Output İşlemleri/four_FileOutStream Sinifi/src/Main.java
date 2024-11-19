import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
            String yazi="FileOutputStream öğreniyorum !";
        try {
            File dosya =new File("patika.txt");
            FileOutputStream out= new FileOutputStream(dosya,true);  //iki kullanımıda bilelim istedik
          //  FileOutputStream out= new FileOutputStream("patika.txt",true);  //olmayan bir dosya ismi yazarsak o dosyayı oluşturuyor.
                                                //true dememizde ki amaç out içi boş olduğu için patika siliyordu. True sayesinde silmez devamına yazar.
            byte [] yaziByte = yazi.getBytes();  //burda değerleri byte çevirerek bir diziye atıyoruz.
            out.write(yaziByte);  //Burada byte çevirdiğimiz diziyi yazmış olduk direk yazi yazsak yani String değeri kabul etmez!!!
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}