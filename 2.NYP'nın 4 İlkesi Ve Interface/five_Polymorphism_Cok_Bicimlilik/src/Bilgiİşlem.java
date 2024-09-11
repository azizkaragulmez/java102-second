public class Bilgiİşlem extends Memur{
    private String gorev;

    public Bilgiİşlem (String adSoyad,String telefon, String eposta,String departman,String mesai,String gorev)
    {
        super(adSoyad, telefon, eposta, departman, mesai);
        this.gorev=gorev;
    }
    public void networkKurulum(){
        System.out.println("Network Kurulumu Başarıllı.");
    }
}
