import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program başladı");
        Scanner input = new Scanner(System.in);
        int a = 1;
        int b = 20;


        try {
            System.out.println("Bölme işlemi");
            System.out.println(b / a);                //buraya bir hata olabilcek yerleri yazıyoruz. Hata varsa direk "catch" içine atıyor.
            System.out.println("Bölme işlemi bitti");
        } catch (ArithmeticException e) {
            //    System.out.println("Hata Yakalandı!!");   //try ile hatayı yakalıyoruz catch ile bu hatayı napmamız gerektiğini söylüyoruz.
            System.out.println(e.toString());      //farklı yazımlar yapıp farklı hata bildirimi yapabiliriz.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {                                           //finally kesin çalışır hata alsan da almasan da.
            System.out.println("Bu kısım kesinlikle çalışacak");
        }

        System.out.println("Program bitti");

    }


}