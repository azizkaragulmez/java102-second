import java.util.Scanner;

public class Player {
    private int damage;  //zarar
    private int health;   //sağlık


    private int money;  //paraa
    private String charName;  //karekter adı
    private String name;  //oyuncu adı
    private Scanner input = new Scanner(System.in);    //bu sınıfta kullanılsın diye priavete tanımladık, başka yerdede kullanırız
    private Inventory inventory;   //playerimıza ınvertory atadık


    public Player(String name) {   //sadece oyuncu adını dışarıdan alıcağımız için constractora diğerlerini yazmaya gerek yok
        this.name = name;
        this.inventory = new Inventory();  //otomatik olarak invertory oluşsun dedik silah vs. olmazsa yumruk atsın gibi
    }


    public void selectChar() {
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};   //Bu, diziyi başlatır ve üç yeni nesne oluşturur: Samurai, Knight ve Archer.
        // new Samurai(), new Knight(), ve new Archer() ifadeleri, bu sınıfların her biri için yeni bir nesne oluşturur.//Bu nesneler, sırayla charList dizisine eklenir.
        System.out.println("KARAKTER");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        for (GameChar gameChar : charList) {
            System.out.println(
                    "id :" + gameChar.getId() +
                            "\tkarakter: " + gameChar.getName() +
                            "\t Hasar: " + gameChar.getDamage() +
                            "\t Sağlık:" + gameChar.getHealth() +
                            "\t para: " + gameChar.getMoney());
        }

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Lütfen Bir Karakter Seçiniz :");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
       /* System.out.println("Karakter: "+this.getCharName()+
                ", Hasar: "+this.getDamage()+
                ", Sağlık :"+this.getHealth()+
                ", Para: "+this.getMoney());*/
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }

    public void printInfo() {
        System.out.println("Silahınız: " + this.getInventory().getWepon().getName() +
                ", Zırh :" + this.getInventory().getArmor().getName() +
                ", Bloklama :" + this.getInventory().getArmor().getBlock() +
                ", Hasarınız: " + this.getTotalDamage() +
                ", Sağlık :" + this.getHealth() +
                ", Para: " + this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWepon().getDamage();
    }
    public int getDamage() {
        return damage ;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }




    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wepon getWepon(){
        return this.getInventory().getWepon();
    }
}
