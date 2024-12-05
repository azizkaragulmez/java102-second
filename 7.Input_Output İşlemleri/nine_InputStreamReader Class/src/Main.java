import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("patika.txt");
            InputStreamReader ınputReader = new InputStreamReader(input);   //Bu olmadan kullandığımız da Türkçe kelimeleri okuyamıyorud bu saye de okuyabildi
                                                                            //input yanına, Charsetler ekliyebiliyoruz, çrneğim çince için vs.
            int i = ınputReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = ınputReader.read();  //burda imiz yeni değerini atıyoruz
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}