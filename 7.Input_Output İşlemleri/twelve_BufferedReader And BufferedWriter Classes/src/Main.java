import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {




        String data ="Aziz Karagülmez";
        File dosya =new File("patika.txt") ; //farklı bir yol öğrenelim diye yaptık
                                                      //dosya ekliyebildiğimi görelim şart değil yani bu
        try {
            FileWriter filewrt= new FileWriter(dosya, Charset.forName("Big5")); //Charsette ekliyebiliyoruz
            BufferedWriter wrt=new BufferedWriter(filewrt);
            wrt.write(data);
            wrt.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }










        /*
        try {
            FileReader readFile=new FileReader("patika.txt");
            BufferedReader readBuf=new BufferedReader(readFile);

            //Burda yeni bir şey görüyoruz karekter karekter değil satır satır okumamıza olanak tanıyor.
            //Diğer kullanımıda kullanabilirsizin ama bu daha yaygın bir kullanım

         /*   String line= readBuf.readLine();
            while (line != null){
                System.out.println(line);
                line=readBuf.readLine();
            }
//------>İKİ KULLANIM'DA DOĞRU YAZILIMCIYA KALMIŞ
            String line;
            while ((line=readBuf.readLine())!= null){
                System.out.println(line);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

    }
}