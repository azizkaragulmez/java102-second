import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {


        //System.out.println(); in kullanımın mantığını anlattığımız bölüm gibi
        try {
            PrintStream prt=new PrintStream("patika.txt");  //Stream türünde açmazsak direk ekliyemiyoruz
            prt.print("abc"+123);  //yukarda tanımlayıp String data="sfsadf"; ekliyebilirdik.
            prt.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}