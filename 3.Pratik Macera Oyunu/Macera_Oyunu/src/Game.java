import java.io.BufferedReader;
import java.util.Scanner;

public class Game {


   private Scanner input =new Scanner(System.in);  //sadece bu sınıf içinde kullanıcağımız için private tanımladık.
    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz.");
        System.out.print("Lütfen bir isim giriniz : ");
        //String playerName=input.nextLine();  //kullanıcdan isim aldıktan sonra player nesnesi üretmemiz lazım
        Player player = new Player("Aziz Karagülmez");
        System.out.println("Sayın " + player.getName() + " Bu karanlık ve sisli adaya  hoşgeldiniz. Burda yaşananların hepsi gerçek");
        System.out.println("Lütfen bir karekter seçiniz !");
        player.selectChar();


        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            //bu null atarız başlangıçta sonra bu sonra oyuncunun seçtiği bölgeyi tutacaktır.
            System.out.println("//////////////// Bölgeler ////////////////");
            System.out.println();
            System.out.println("0- Çıkış Yap --> Oyunu sonlandır.");
            System.out.println("1-Güvenli Ev--> Burası sizin için güvenli bir ev, düşman yoktur.");
            System.out.println("2-Mağaza--> Silah veya zırh satın alabilirsiniz.");
            System.out.println("3-mağara--> Mağraya gir, Dikkat canavar çıkabilir.");

            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz :");
            int selectLoc = input.nextInt();     //bu sınıfta Scanner tanımlamıştık.

            switch (selectLoc) {
                case 0:
                    location=null;
                    break;

                case 1:
                    location = new SafeHouse(player);     //hangi oyuncuyla çalışmak istiyorsak bilgilerini buraya atıyoruz. gücü canı vs.
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location==null)
            {
                System.out.println("GAME OVER GUYS");
                break;
            }
            if (!location.onLocation())   //false dönerse ölmüşüz demektir.
            {
                System.out.println("GAME OVER");
                break;
            }
        }




    }

}
