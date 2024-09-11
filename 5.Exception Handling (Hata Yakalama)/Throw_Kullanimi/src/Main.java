import java.util.Scanner;

public class Main {

    public static void checkAge(int age) throws Exception{    //burda farkı eklemede yapabiliriz ama bunu yazarsak ataları olduğu için en genelli budur.
        if (age < 18) {
            //throw new ArithmeticException("Yaşınız Tutmuyor");   //new den sonra vermek istediğimiz exceptionu yazabiliyoruz sonra hata mesajınıda ekliyebiliriz.
           // throw new IndexOutOfBoundsException("Yaşınız tutmuyor");
            throw new Exception("Yaşınız tutmuyor");    //bu satırda Exception'ı kullanabilmek için metoda "throws" ile Exception eklemek  gerek
        }
        System.out.println("Yaşı uygundur");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Yaşınızı Giriniz : ");
        int age = input.nextInt();
        try {                               //yukarda "thwors" kullanarak eklediğimiz Exceptionı main de eklemek zorundayız AMA try catch kullanmazsak
            checkAge(age);
        } catch (Exception e) {
            System.out.println("Yaşı uymadı");
            System.out.println(e.toString());   //bunu yazarsak throw içindeki mesajı hata ile beraber yazar.
        }
        System.out.println("Program Bitti");


    }
}