public class Güvenlik_Görevlisi extends Memur{
    private String Belge;

    public Güvenlik_Görevlisi (String adSoyad,String telefon, String eposta,String departman,String mesai,String Belge)
    {
        super(adSoyad, telefon, eposta, departman, mesai);
        this.Belge=Belge;
    }
    public String getBelge(){
        return this.Belge;
    }
    public void setBelge(String Belge)
    {
        this.Belge=Belge;
    }

    public void nobet()
    {
        System.out.println("Nobet yerine geçildiiii..");
    }
}
