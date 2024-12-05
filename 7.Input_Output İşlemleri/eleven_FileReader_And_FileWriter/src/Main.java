import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Diğer patikalarda öğrendiklerimizi hepsini bunda uygulamış oluyoruz orda temel mantığını anladık

        String data ="JAVA 102 ÖĞRENİYORUM...";

        try {
            FileWriter fileWriter=new FileWriter("out.txt");
            fileWriter.write("sdfsdfs"+data);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
















   /*     try {
            FileReader file =new FileReader("patika.txt");
            file.skip(1);  //bir tanesi atla diyoruz A yı okumıcak
            int i=file.read();
            while (i != -1)
            {
                System.out.print((char)i);
                i=file.read();
            }
            file.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}