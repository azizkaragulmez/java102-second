public class Main {
    public static void main(String[] args) {

        //undefined  hafızada var ama s ye karşılık bir değer yok tanımlanmamış
        String s;

        //null  bir değer yok demek
        String s1 = null;

        //empty bir değer var ama içi boş demek
        String s2 = "";

        System.out.println("----------------------------------------------------------------------");

        String str = null;
        Nullable n = new Nullable(str);
        n.run();

        System.out.println("-----------------------------------------------------------------------");

        Integer a = 123123;
        NullableInteger ı = new NullableInteger(a);
        ı.run();


        System.out.println("-----------------------------------------------------------------------");

        Integer x1 = 12;
        String xstr = "abc";

        Nullable_final<Integer> x = new Nullable_final<>(10);
        Nullable_final<String>  y=new Nullable_final<>(xstr);
        x.run();
        y.run();

        System.out.println("-----------------------------------------------------------------------");
        //birden fazla generic yapı alabileceğini gösteriyor.
        Integer kk=10;
        String  yy="Patika";
        Double  ll=3.14;
        String dd="dev";

        test_son_final<Integer,String,Double> tst=new test_son_final<>(kk,yy,ll);
        tst.setObj2(dd);
        tst.showInfo();

    }
}