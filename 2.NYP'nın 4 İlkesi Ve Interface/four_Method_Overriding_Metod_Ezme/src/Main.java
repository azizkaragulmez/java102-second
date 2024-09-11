public class Main {
    public static void main(String[] args)
    {
        Akademisyen a1=new Akademisyen("Patika dev","123","patikadev@gmail.com","Ceng","Prof");
        OgretimGorevlesi o1=new OgretimGorevlesi("Aziz K","12345","ak@gmail.com","Ceng","DOÇ. DR","116");
        Calisan c1=new Calisan("Sultan","123456","sulti@gmail.com");


        //Method Overriding (Metotlarda Geçersiz kılma)
        o1.giris();  //bura ve       //burdada olmasının sebebi biz kodu ezmeyi akademisyende yaptık ve ogretim g. akademisyenin alt sınıfı
        a1.giris();  //burada overriding yaptık atasınıftaki metodu geçersiz kıldık.
        c1.giris(); //burda ise atasınıftaki metodu çağırdık.

    }
}