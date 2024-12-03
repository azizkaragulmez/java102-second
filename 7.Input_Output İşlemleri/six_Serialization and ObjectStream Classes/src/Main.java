
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class Main {
    public static void main(String[] args) {



        Car c1= new Car("Audi","A5");
        try {
            FileInputStream  fileinput= new FileInputStream("araba.txt");
            ObjectInputStream objinput=new ObjectInputStream(fileinput);
            Car newCar= (Car) objinput.readObject();
            System.out.println(newCar.getBrand());
            System.out.println(newCar.getModel());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }












 /* İLK YAPILANLAR
        try {
            // Dosya açılır → Nesne dönüştürülür → Dosyaya yazılır → Kapatılır.
           FileOutputStream in=new FileOutputStream("araba.txt");
            ObjectOutputStream out= new ObjectOutputStream(in);
            out.writeObject(c1);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


    }
}