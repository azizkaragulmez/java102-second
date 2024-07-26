public class Main {
    public static void main(String[] args)
    {
        Player p1=new Player("Aziz KARAGÜLMEZ",1);
        System.out.println(p1.count);

        Player p2=new Player("Aziz KARAGÜLMEZ",1);
        Player p3=new Player("Aziz KARAGÜLMEZ",1);
        System.out.println(Player.count);  //countu direk sınıf üzerindende çağrabiliyoruz nasıl static olduğu için.
    }
}