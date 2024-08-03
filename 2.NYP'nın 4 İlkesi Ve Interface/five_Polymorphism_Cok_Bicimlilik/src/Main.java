public class Main {
    public static void main(String[] args) {

        Calisan c1=new Calisan("Aziz Karagülmez","02327423","karagulmez.aziz@icloud.com");

        Akademisyen a1=new Akademisyen("Patika dev","23423423","bilgi@patikadev","CENG","Doeçnt");

        Memur m1=new Memur("Ali veli","134141","a@patikadev","Bilgi İşlem","09:00-18:00");

        OgretimGorevlesi o1=new OgretimGorevlesi("Aziz Karagülmez","0","azizk@gmail.com","CENG","Prof","116");


        //Polimorfizm (Çok Biçimlilik)
   //    Calisan c2=new Akademisyen("Kodluyoruz","23423423","bilgi@patikadev","CENG","Doeçnt");
     //  c2.giris();                            //şimdi burda mantık Calisanda bulunan herşeye erişim var
      // System.out.println(c2.getEposta());    //çağrabiliyoruz kullanabiliyoruz
    // c2.derseGir();                      //derseGir metodu Calışanda  olmadığı için ulaşamıyoruz. Akademisyende var


        System.out.println("---------------------------");


       // Akademisyen [] loginUser={c1,a1,m1,o1,c2}     Akademisyen yazdığımızda hata aldık çünkü akademisyen hepsini kapsamıyor
        Calisan [] loginUser={c1,a1,m1,o1};         //Calisan ata sınıf olduğu ve hepsini kapsadığı için.
                                                       //Calisan türündeki nesneleri saklıcağı anlamına gelir.

        Calisan.girisYapanlar(loginUser);

        //override
       /* o1.giris();
        a1.giris();
        c1.giris();
        m1.giris();
*/


    }
}