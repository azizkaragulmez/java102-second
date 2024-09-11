public class Main {

    public static void main(String[] args)
    {


       /*  BU STATİC DEĞİŞKENLER İÇİN
        System.out.println(Player.count);


        Player p1=new Player("Aziz KARAGÜLMEZ",1);
        System.out.println(p1.count);

        Player p2=new Player("Aziz KARAGÜLMEZ",1);
        Player p3=new Player("Aziz KARAGÜLMEZ",1);
        System.out.println(Player.count);  //countu direk sınıf üzerindende çağrabiliyoruz nasıl static olduğu için.
    */

     //BUNLAR DA METODLAR İÇİN

        Course Mat =new Course("Matematik","MAT-101",70);
        Course Fizik =new Course("Fizik","FZK-101",20);
        Course kimya =new Course("Kimya","KMY-101",100);

        int [] notlar={29,34,56};
        Calculate.calcAvarage(notlar);
       // Mat.calcAvarage(notlar);  //burda code düzen hız eklemek gibi düşünebiliriz yani fazladan nesne kullandık Mat Fizik vs.
                                     //direk görmek için başka class açtım şimdi calculate classı içinde nesne tanımlamakla uğraşcaktım.






    }

}