public class Player {
    public String name;
    public int id;
    public static int count=22;

    public Player(String name,int id)
    {
        this.id=id;
        this.name=name;

    }

    //2.kısım
    public static void showName(){
        Player a=new Player("a",2);
        System.out.println(a.name);
      //System.out.println(this.name);  //bir şeye bağlıyamyız static olduğu için aktif olarak değişir yani fazla takılma
    }
}
