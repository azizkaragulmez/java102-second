import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] args) {

        String data = "Aziz Karagülmezzz xwadsf23";

        try {
            FileOutputStream file = new FileOutputStream("Patika.txt");

            OutputStreamWriter wrt = new OutputStreamWriter(file);

            wrt.write(data);  //OutputStreamWriter sayesinde dönüşümlerle uğraşmadık altakiler önceki metod
            wrt.close();

            file.write(data.getBytes());   //write içine neler yazılcağını baktık ve datayı byte çevirdik
            file.close();

        } catch (Exception e) {
            e.getMessage();
        }


    }
}