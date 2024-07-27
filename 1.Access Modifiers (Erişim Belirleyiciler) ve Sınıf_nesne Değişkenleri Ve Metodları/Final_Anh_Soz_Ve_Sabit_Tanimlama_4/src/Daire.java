public class Daire {
    public  int r;
    // public double pi=3.14;
    public final double PI_SAYISI=3.14;   //final anahtar kelimesini ekledik ve sabitledik pi değeri değiştirilemez.
                                          //bir sabit büyük yazılır diğer yazılımcı bunu bir sabit olduğunu anlasın
                                          // diye bir jargon aslında kural değil.
    public Daire(int r)
    {
        this.r=r;
    }
    public void CalcArea()
    {
        double area= PI_SAYISI*this.r*this.r;
        System.out.println("Alanı="+area);
    }
}
