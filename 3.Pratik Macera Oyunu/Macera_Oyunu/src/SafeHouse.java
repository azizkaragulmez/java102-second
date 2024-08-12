public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player){
        super(player,"Güvenli Ev");   //namei kullanıcıdan almamıza gerek yok adı güvenli ev zaten.
    }

    @Override
    public boolean onLocation() {   //Normal loc'da override ettiğimiz için burda override etmemize gerek yok ama biz etmek istedik.
        System.out.println("Güvenli Evdesiniz !");
        System.out.println("Canınız Yenilendi !");
        return true;
    }
}
