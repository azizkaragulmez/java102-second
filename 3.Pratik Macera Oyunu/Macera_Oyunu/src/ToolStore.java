import java.lang.runtime.SwitchBootstraps;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");  //gene kullanıcıdan almamıza gerek yok bir paremetreye ihtiyaç yok kendimiz ekliyoruz ismi
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Mağazaya Hoşgeldiniz ! -------");  //gene aynı mantık override etmemize gerek yok ama etmek istedik.
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış Yap");
        System.out.print("Seçiminiz:");
        int selectCase = Location.input.nextInt();

        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Geçersiz değer tekrar giriniz :");
            selectCase = Location.input.nextInt();      //bir kere hafızda yer alıp yerden tasaruf etmemizi sağlar.

        }
        switch (selectCase) {
            case 1:
                printWepon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleriz ");
                return true;

        }
        return true;

    }

    public void printWepon() {
        System.out.println("-------Silahlar-------");

        for (Wepon w : Wepon.weapons()) {  //böyle çağrabiliyoruz çünkü array bu
            System.out.println(w.getId() + "-" + w.getName() + " para :" + w.getPrice() + " Hasar :" + w.getDamage());
        }
    }


    public void buyWeapon() {
        System.out.print("Bir Silah Seçiniz :");
        int selectWeponID = input.nextInt();

        while (selectWeponID < 1 || selectWeponID > Wepon.weapons().length) {
            System.out.println("Geçersiz değer tekrar giriniz :");
            selectWeponID = input.nextInt();      //bir kere hafızda yer alıp yerden tasaruf etmemizi sağlar.
        }
            Wepon selectedWeapon = Wepon.getWeaponObjByID(selectWeponID);

            if (selectedWeapon != null)  //getID null değilse
            {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız Yoktur.");
                } else {
                    //satın almanın gerçekleştii alan
                    System.out.println(selectedWeapon.getName() + " Silahınızı satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız :" + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız  :" + this.getPlayer().getInventory().getWepon().getName());
                    this.getPlayer().getInventory().setWepon(selectedWeapon);                                     //set edildiğini gör
                    System.out.println("Yeni Silahımız :"+this.getPlayer().getInventory().getWepon().getName());
                }
            }
        }


    public void printArmor() {
        System.out.println("Zırhlar :");
    }
}
