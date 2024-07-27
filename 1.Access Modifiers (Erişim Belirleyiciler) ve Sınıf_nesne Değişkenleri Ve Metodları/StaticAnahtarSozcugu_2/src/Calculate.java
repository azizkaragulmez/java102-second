public class Calculate {


    public  static void calcAvarage(int [] notes){  //public ve void arasında static yazarsak direk erişim sağlıyacağız
    double total=0;
    for (int i=0; i<notes.length; i++)
    {
        total+=notes[i];
    }
    double avarage=total/notes.length;
    System.out.println("ortalamanız"+ avarage);

}
}
