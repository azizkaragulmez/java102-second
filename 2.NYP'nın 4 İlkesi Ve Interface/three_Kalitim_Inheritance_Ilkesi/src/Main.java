public class Main {
    public static void main(String[] args)
    {
        Calisan c1=new Calisan("Aziz Karagülmez","05552223312","karagulmez.aziz@icloud.com");
        Akademisyen a1=new Akademisyen("Ali Veli","1234567890","ak07@gmail.com","CENG","Prof");
        Memur memur=new Memur("Aziz K","05311454909","azizkaragulmez@gmail.com","CENG2","09:00");

        OgretimGorevlesi ogrG=new OgretimGorevlesi("Ali Demiröz ","054939423","alidemiröz@gmail.com","CENG","Prof","12");
        System.out.println(ogrG.getKapiNo());
        ogrG.senatoToplanti();
    }
}