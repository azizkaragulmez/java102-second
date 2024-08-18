public class Wepon {
    //silah=Wepon
    private String name;
    private int id;
    private int damage;
    private int price;



    public Wepon(String name, int id, int damage, int price) {
        this.name=name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }
    public static Wepon[] weapons (){         //burda bir dizi türünde matot oluşturduk geri bir değer döndürcek dizi şeklinde.
        Wepon [] weponsList=new Wepon[3];
        weponsList[0]=new Wepon("Tabanca",1,2,15);
        weponsList[1]=new Wepon("Kılıç",2,3,35);
        weponsList[2]=new Wepon("Tüfek",3,7,45);
        return weponsList;

    }

    public static Wepon getWeaponObjByID(int id){      //geriye Wepon bir değer döndürmek isteyeceğiz.

        for (Wepon w: Wepon.weapons()){

            if (w.getId()== id)
            {
                return w;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
