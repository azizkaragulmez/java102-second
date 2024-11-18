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

            int i= input.read();
            while (i != -1){
                System.out.println(input.read());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}