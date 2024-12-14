import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {




        String data = "Aziz Karagülmez 2";
        File dosya = new File("patika.txt"); // Dosya nesnesi oluşturuldu
        try {
            // FileWriter oluşturulurken aynı dosya ismini kullanın
            FileWriter filewrt = new FileWriter(dosya, Charset.forName("UTF-8"));
            // BufferedWriter kullanımı
            BufferedWriter wrt = new BufferedWriter(filewrt);
            wrt.write(data); // Veri yazılır
            wrt.close(); // Kaynak kapatılır
            System.out.println("Dosya başarıyla yazıldı: " + dosya.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Dosya oluşturulamadı veya yazılamadı", e);
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