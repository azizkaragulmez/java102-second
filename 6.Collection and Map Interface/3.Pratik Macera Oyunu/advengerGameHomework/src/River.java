public class River extends BattleLoc{
static int number=0;

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        River.number = number;
    }

    public River (Player player)
    {
        super(player,"Nehir",new Bear(),"water",2);


    }
}
