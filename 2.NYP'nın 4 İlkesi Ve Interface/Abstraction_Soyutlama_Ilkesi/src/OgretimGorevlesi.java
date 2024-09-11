public class OgretimGorevlesi extends Akademisyen{
    private String KapiNo;

    public OgretimGorevlesi(String adSoyad,String telefon, String eposta,String bolum,String unvan,String KapiNo)
    {
        super(adSoyad, telefon, eposta, bolum, unvan);
        this.KapiNo=KapiNo;
    }

    public String getKapiNo()
    {
        return this.KapiNo;
    }
    public void setKapiNo(String kapiNo)
    {
        this.KapiNo=kapiNo;
    }


    public void senatoToplanti(){
        System.out.println("Senato toplantısını "+getAdSoyad()+" başlattı");
    }

    public void sinavYap(){
        System.out.println("Sınav Başladı...");
    }

    @Override
    public void derseGir(String saat){        //biz akademisyen sınıfında derseGir metodunu abstract
                                              // tanımladoğımız için alt sınıfta Override yapmak zorundayız.
        System.out.println(this.getAdSoyad()+" öğretim görevlisi derse "+saat+ " giriş yaptı.");
    }


    }
