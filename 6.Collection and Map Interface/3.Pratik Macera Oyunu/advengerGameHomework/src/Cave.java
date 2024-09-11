public class Cave extends BattleLoc{
    static int number=0;

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Cave.number = number;
    }

    public Cave (Player player){
        super(player,"Mağara",new Zombie(),"food",3);
    }
}
