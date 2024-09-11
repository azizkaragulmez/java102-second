public abstract class GameChar {
    private int id;



    private String name;  //karekterlerin isimleri
    private int damage;  //hasar
    private  int health;  //sağlık

    private  int money;     //para

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameChar(int id,String name, int damage, int health, int money)
    {
        this.id=id;
        this.damage=damage;
        this.health=health;
        this.money=money;
        this.name=name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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







}
