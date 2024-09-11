package inter;

public class BBankasi implements IBanka{

    private String bankaAdi;
    private String terminalID;
    private String password;

   public BBankasi (String bankaAdi, String terminalID, String password)
   {
       this.bankaAdi=bankaAdi;
       this.terminalID=terminalID;
       this.password=password;
   }


   //   POS GİBİ DÜŞÜNÜYORUZ A BANKASININ BAĞLANTISINI BAŞKA BİR YAZILIMCI, B BANKASINI BAŞKA BİR YAZILIMCI YAPABİLİR
    // A BANKASINDA Kİ METOD OLUŞUMLARI VE B BANKASI FARKLI YANİ FARKLI OLUŞUMLADA YAPILABİLİYORUZ.
   public boolean connect(String ipAddress){
       System.out.println("kullanıcı ip"+ipAddress);
       System.out.println("makina ip: "+this.hostIpAdress);
       System.out.println(this.bankaAdi+"Bağlanıldı!");
       return true;
    }

    public boolean  payment (double price,String cardNumber,String date,String cvc){
        //Banka ödeme işlemleri
        System.out.println("Bankadan Cevap Bekleniyor !");
        System.out.println("İşlem Başarılı Oldu!");
        return true;
    }




    public String getBankaAdi() {
        return bankaAdi;
    }

    public void setBankaAdi(String bankaAdi) {
        this.bankaAdi = bankaAdi;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
