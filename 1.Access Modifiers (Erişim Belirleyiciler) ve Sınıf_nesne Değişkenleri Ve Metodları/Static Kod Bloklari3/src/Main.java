public class Main {
    public static void main(String[] args)
    {
        User u1=new User("Aziz Karagülmez");   //burda bunu gödüğü için o nesneye ait statickleri çalıştırır.
        User u2=new User("Aziz Karagülmez");   //ikinci bir nesne gördüğünde tekrardan static çalıştırmıyor hafıza almış oluyor zaten
                                                     //sadece counter artırıyor. (Mantığı  anlaşıldı cümlelere takılma)

        System.out.println(User.counter);


    }
}