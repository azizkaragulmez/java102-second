public class LabAsistan extends Asistan{

    public LabAsistan(String adSoyad, String telefon, String eposta,String bolum,String unvan, String ofisSaati)
    {
        super(adSoyad,telefon,eposta,bolum,unvan,ofisSaati);

    }
    public void lablaraGir(){
        System.out.println("laboratuvara girildi...");
    }
    public void DerseGir(String saat){
        System.out.println("Derslere girildi...");   //burda yapmak zorunda değiliz override boş bırakabiliriz
    }
}
