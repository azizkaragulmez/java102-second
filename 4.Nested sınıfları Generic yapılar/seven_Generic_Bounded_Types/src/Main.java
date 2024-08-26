public class Main {
    public static void main(String[] args)
    {
        //wrapperlar Integer, Double, Float extends Number sınıfından geliyorlar.

    /*    Integer a=null;
        Nullable<Integer> n=new Nullable<>(a);
        n.run();
        //  Nullable<String> n1=new Nullable<String>("sadf");   String yazdığımız yerde hata aldık çünkü sınırlama yapmıştık.*/


        //İKİNCİ GÖSTERİM
        A object=null;  //A sınıfından object ürettik o da null
        Nullable<A> n=new Nullable<>(object);   //artık bunun türü o
        n.run();

        B bobject=null;
        Nullable<B> n1=new Nullable<>(bobject); //böyle şeylerden yapılıyor fazla kafa karıştırmana gerek yok sınırlama yapabilabiliyor kısaca
        n1.run();
    }
}