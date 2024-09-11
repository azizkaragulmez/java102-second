public class Calisan {
    private String adSoyad;
    private String telefon;
    private String eposta;

    // public Calisan(){}  yaparsak aşırı yükleme overloading yapıp akademsyen sınıfında constructor çağırmaya biliriz
    // veya superin içi boş kalabilir ama bunu kullanmıyoruz şuan görürsek diye anlatıldı.
    public Calisan (String adSoyad, String telefon, String eposta)
    {
        this.adSoyad=adSoyad;
        this.telefon=telefon;
        this.eposta=eposta;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEposta() {
        return this.eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }


    public void  giris(){
        System.out.println(this.adSoyad+" üniversiteye giriş yaptı.");
    }

    public void cikis(){
        System.out.println(this.adSoyad+" üniversiteden çıkış yaptı.");
    }

    public void yemekhane(){
        System.out.println(this.adSoyad+" yemekhaneye girdi.");
    }

    public static void girisYapanlar(Calisan [] loginUsers){
        for (Calisan c :  loginUsers) {
            c.giris();
        }
    }


}
