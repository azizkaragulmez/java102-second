import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        //Herşeyi stringe çeviren stream diyebiliriz
        String data = "Java 102 Dersleri.";
        try {
            PrintWriter output = new PrintWriter("output.txt");
            output.print(123);
            output.print(data);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}