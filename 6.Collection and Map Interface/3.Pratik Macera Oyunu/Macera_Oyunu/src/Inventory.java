public class Inventory {
    //ınvetroy=envanter

    Wepon wepon;  //direk nesyeni atmak anlamına gelir
    Armor armor;


    public Inventory() {
        this.wepon = new Wepon("yumruk", -1, 0, 0); //varsayılan olarak yumruk atamış olduk.
        this.armor = new Armor(-1, "Paçavra", 0, 0);   //zırh işlemlerinde varsayılan

    }

    public Wepon getWepon() {
        return wepon;
    }

    public void setWepon(Wepon wepon) {
        this.wepon = wepon;
    }


    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}