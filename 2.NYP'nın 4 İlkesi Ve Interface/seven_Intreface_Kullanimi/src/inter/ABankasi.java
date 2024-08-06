package inter;

public class ABankasi  implements IBanka,IDeneme{


   // public class ABankasi extends Main implements IBanka,IDeneme
    //iki interface ekliyebiliyoruz abstractlarda o kullanım yok.
    //Kalıtımın yanınada interface ekliyebiliyoruz, hepsi bir arada eklenebilmekte.
    //abstract ve interface ayıran bir özellikte birden fazla interface kalıbı bir sınıfa dahil edebiliyoruz.
    private String bankaAdi;
    private String terminalID;
    private String password;

    public ABankasi (String bankaAdi,String terminal_id, String password)
    {
        this.bankaAdi=bankaAdi;
        this.terminalID =terminalID;
        this.password=password;
    }

    @Override
    public boolean connect(String ipAddress){
        System.out.println("kullanıcı ip"+ipAddress);
        System.out.println("makina ip: "+this.hostIpAdress);
        System.out.println(this.bankaAdi+"Bağlanıldı!");
        return true;
    }

    @Override
    public boolean payment (double price,String cardNumber,String date,String cvc){
        //Banka ödeme işlemleri
        System.out.println("Bankadan Cevap Bekleniyor !");
        System.out.println("İşlem Başarılı Oldu!");
        return true;
    }




    public String getBankaAdi()
    {
        return this.bankaAdi;
    }
    public void setBankaAdi(String bankaAdi)
    {
        this.bankaAdi=bankaAdi;
    }

    public String getTerminal_id(){
        return this.terminalID;
    }
    public void setTerminal_id(String terminal_id)
    {
        this.terminalID =terminalID;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }

}
