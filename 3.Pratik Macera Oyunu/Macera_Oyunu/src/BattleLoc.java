import java.util.Random;

public class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;     //award=ödül
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }


    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor");
        System.out.println("<S>avaş veya <K>aç  :");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();   //küçük büyük ne girerse girsin büyük harf yapıyor.
        if (selectCase.equals("S")&& combat(obsNumber))  //Striinglerde equals kulanılıyor.
        {

                System.out.println(this.getName() + " tüm düşmanları yendiniz !");
                return true;

        }
        if (this.getPlayer().getHealth() <= 0) {   //öldüysen false döndürcek demek
            System.out.println("ÖLDÜNÜZ");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {       //parametre içine obsNumber atma nedeni kaç adet canavarla savaşacağımızı yazıyoruz.
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());

            playerStatas();      //karekterin değerlerini bastırdığımız metod
            obstacleStats(i);    //burda canavarımızın değerini çağırdığımız yer
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<V>ur veya <K>aç : ");
                String selectCombat = input.nextLine().toUpperCase();    //toUpperCase küçük harfi büyük büyükse büyük olarak bırakıyor.
                if (selectCombat.equals("V")) {
                    System.out.println("Siz vurdunuz !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Canavar Size Vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }
                else {
                    return false;
                }

            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı Yendiniz !");
                System.out.println(this.getObstacle().getAward()+" Para kazandınız !");
                this.getPlayer().setMoney(getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel Paranız :"+this.getPlayer().getMoney());
            }
            else {
                return false;
            }

        }

        return true;
    }



    public void afterHit() {
        System.out.println("Canınız :" + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "  Canı : " + this.getObstacle().getHealth());
        System.out.println("----------------------------------------");
    }

    public void playerStatas() {    //oyuncunun değerlerini bura bastırmış olduk
        System.out.println("Oyuncunun Değerleri");
        System.out.println("-------------------");
        System.out.println("Sağlık :" + this.getPlayer().getHealth());
        System.out.println("Silah :" + this.getPlayer().getInventory().getWepon().getName());
        System.out.println("Hasar :" + this.getPlayer().getTotalDamage());
        System.out.println("Zırh :" + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blockala :" + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para :" + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.obstacle.getName() + " Değerleri");
        System.out.println("-------------------");
        System.out.println("Sağlık :" + this.obstacle.getHealth());
        System.out.println("Hasar :" + this.obstacle.getDamage());
        System.out.println("Ödül :" + this.obstacle.getAward());


    }

    public int randomObstacleNumber() {   //burda ormanda nehirde dağda oluşacak canavalarların sayısını burda üretiyoruz rastgele
        Random r = new Random();
        return r.nextInt(getMaxObstacle()) + 1;     //burda yaptığımız random üretirken içine 3 yazarsak 0 ve 2 dahil sayı üreticek ama biz 1-3 istediğimiz için yanına +1 yazdık.
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}
