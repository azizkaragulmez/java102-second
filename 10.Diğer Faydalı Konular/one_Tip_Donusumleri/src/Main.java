public class Main {
    public static void main(String[] args) {
       //Widening Casting (Otomatik)
        int a=10;
        double b=a;
        System.out.println(b);  //otomatik gerçekleşebiliyor int double küçük zaten.


       //Narrowing Casting (Manuel)
       double pi=3.14;
       int c= (int) pi;  //hata aldık,büyüğü küçüğe ekliyemedik o yüzden (int) ekledik. Sen hep int ol dedik.
        System.out.println(c);

        byte d=80;
        System.out.println((char) d);


        //Integer => String Dönüşümü
        int num=20;
        System.out.println("Integer değer :"+num);

        String str = String.valueOf(num);
        System.out.println("String değer :"+str);  //gene 20 dicek ama artık bu String türünde bir değer.


        //String => Integer Dönüşümü
        int z=Integer.parseInt(str);
        System.out.println(z+num); //dönüşüm yapmasam 2020 yazıyor
    }
}