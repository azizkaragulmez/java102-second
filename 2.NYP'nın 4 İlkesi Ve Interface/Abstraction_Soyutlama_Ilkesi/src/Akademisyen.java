public  abstract class Akademisyen extends Calisan{

        private String bolum;
        private String unvan;

        //bir sınıf bir sınıfı kalıtım yapıyorsa yani sub class super classtan kaltım
        //yapıyorsa constructorsını yazmak zorunda dır.



    //Eğer böyle bir kalıtım yapılacaksaa üst sınıfın costurctorını eklemek ŞART.
        public Akademisyen(String adSoyad,String telefon, String eposta,String bolum,String unvan){
            super(adSoyad,telefon,eposta);   //super bir anahtar kelimedir. Sadece constructorlarda çalışır
                                             //super classtan (yani Calisan) kalıtım yapılır.
                                            //sırası önemli superı ilk yazmak gereklidir.
            this.bolum=bolum;
            this.unvan=unvan;
        }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public abstract void  derseGir(String dersSaati);       //abstract yazddığımzda hata aldık neden sınıfta abstract olmalı
                                                           //abstract'da kod blokları bulunmaz
                                                          //istersen parametre ekliyebilirsin
                                                         //abstractlarda alt sınfta override edilmesi yani bulunma şartı vardır.



}
