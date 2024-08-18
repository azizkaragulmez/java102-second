import java.util.Scanner;

public abstract class Location {

    private Player player;      //bu kullanım Player türündeki nesnemizi locationa atmamız gerekiyor.
    private String name;    //lokasyonun ismi

    public static Scanner input=new Scanner(System.in);   //alt  sınıflardan erişebilmek için protected dedik.

    public Location(Player player, String name){
        this.player=player;
        this.name=name;
    }

    public abstract boolean onLocation();      //bunu tüm alt sınıfları bunu kullansın.



    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
