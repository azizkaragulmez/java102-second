import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {

        try {
           // File dosya = new File("patika.txt");
           // FileInputStream input= new FileInputStream(dosya);
            FileInputStream input= new FileInputStream("patika.txt");  //(bu kullanım daha mantıklı okunur kod için
            //neden try içine aldık FileInputStream doğru adres vermezse hata vericeği için
            //System.out.println(input.read());  //P nin  80 e eşit olduğunu söylüyor. Ve bittiğinde en son -1 döndürür
            input.skip(10); //nerdeyse ordan 10 karekter atlar 10 byte atlar.
            int i= input.read();
            while (i != -1){
                System.out.print((char)i);
                i=input.read();  //bu sayede bir sonraki karekteri okuyoruz
            }
            input.close(); //diyerekte işi bitince kapatmakta yarar var.



           /* System.out.println("Kullanılabilir byte sayısı :"+input.available());  //kaçtane karekter olduğunu söyler
            input.read();
            input.read(); //read okuyunca onu alıyor ordan siliyor gibi düşünebiliriz.
            System.out.println("Kullanılabilir byte sayısı :"+input.available());
        */
       } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}