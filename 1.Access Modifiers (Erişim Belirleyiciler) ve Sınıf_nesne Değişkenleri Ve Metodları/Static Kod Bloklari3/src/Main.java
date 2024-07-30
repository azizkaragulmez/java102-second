public class Main {
    public static void main(String[] args)
    {
       /* User u1=new User("Aziz Karagülmez");   //burda bunu gödüğü için o nesneye ait statickleri çalıştırır.
        User u2=new User("Aziz Karagülmez");   //ikinci bir nesne gördüğünde tekrardan static çalıştırmıyor hafıza almış oluyor zaten
                                                     //sadece counter artırıyor. (Mantığı  anlaşıldı cümlelere takılma)

        System.out.println(User.counter);*/




        //ÖRNEK CHATGBT ALINDI
        System.out.println("Main metodu başladı.");

        // Statik metot çağrısı
        MyClass.printValues(); // Çıktı: a: 30, b: 40

        // Değerleri değiştir
        MyClass.a = 50;
        MyClass.b = 60;

        // Statik metot çağrısı
        MyClass.printValues(); // Çıktı: a: 50, b: 60

        // Statik metot tekrar çağrısı
        MyClass.printValues(); // Çıktı: a: 50, b: 60


    }
}