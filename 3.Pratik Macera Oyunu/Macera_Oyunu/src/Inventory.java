public class Inventory {
    //ınvetroy=envanter

   Wepon wepon;  //direk nesyeni atmak anlamına gelir
    public Inventory() {
        this.wepon=new Wepon("yumruk",0,0,0); //varsayılan olarak yumruk atamış olduk.

    }

    public Wepon getWepon() {
        return wepon;
    }

    public void setWepon(Wepon wepon) {
        this.wepon = wepon;
    }


}
