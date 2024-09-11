public class Main {
    public static void main(String[] args)
    {
        int a=20;   //bu ilkel veri tipleri

        Integer b=20;    //bunlar ilkel olmayan veri tipleri
        String str="abc";
        Short s=2;
        System.out.println(a+b);

        System.out.println("-----------------");

        String ax="23";
        int bx=20;
        System.out.println(Integer.parseInt(ax)+bx);
        System.out.println("-----------------");
        System.out.println(Integer.max(10,20));

        System.out.println("----------------");
        System.out.println(Integer.sum(2,3));


        //özetle Wrapper sınıflarını nesne gibi düşünüp bunları kullanabiliyoruz.

    }
}