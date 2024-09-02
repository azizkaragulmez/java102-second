public class Main {
    public static void main(String[] args) {
        System.out.println("Program başladı");
        int a = 0;
        int b = 20;

        try {
            System.out.println("Bölme işlemi");
            System.out.println(b / a);                //buraya bir hata olabilcek yerleri yazıyoruz. Hata varsa direk "catch" içine atıyor.
            System.out.println("Bölme işlemi bitti");
        } catch (Exception e){
            //    System.out.println("Hata Yakalandı!!");   //try ile hatayı yakalıyoruz catch ile bu hatayı napmamız gerektiğini söylüyoruz.
            System.out.println(e.toString());      //farklı yazımlar yapıp farklı hata bildirimi yapabiliriz.
        }
        System.out.println("Program bitti");

    }
}