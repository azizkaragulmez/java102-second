public class Player {
    public String name;
    public int id;
    public static String game="cs";
    public static int count=0;

    public Player(String name,int id)
    {
        this.id=id;
        this.name=name;
        count++;
    }
}
