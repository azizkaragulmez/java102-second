package nested;

public class Main {
    public static void main(String[] args) {
     /*   Out out=new Out();
        out.run();     //ikiside aynı işlemi yapıyor out sınıfının içindeki run metodunun içine ın nesnesi ürettirip çağırmıştık


        //direk In sınıfına ulaşmak istersek ne yapabiliriz alışılmışın dışında bir ulaşım

        Out out1= new Out();       //dış sınıftan bir nesne ürettik
        Out.In ınNesnesi=out1.new In();    //üretiiğimiz nesneyi kullanarak In sınıfıdan üretebildik.
        ınNesnesi.run();
    //bu kullanım çok sık kullanılmaz ama kullanılan yerler vardır. Bazı frenworkler apiler böyle çalışıyor.*/



        //STATİC İÇİN KULLANIM
      //  staticgösterim.In.run();    //static olduğu için direk ulaşabiliyoruz.


        //LOCAL İÇİN KULLANIM
     // Local local=new Local();
     // local.run();

        //ANANONİM KULLANIMI
        Anonim a= new Anonim(){   //bu kod bloğu arasında değişken ve metod tanımlıyabiliyoruz.
            public int a=20;
        @Override
            public void run(){
            System.out.println(this.a);
            System.out.println("Anonim olarak yazılmış run metodu..!");
            print();
        }
            public void print(){
                System.out.println("Print metodu");
            }
        };

        //özetle bir anonim sınıfını burda tekrar override edebiliyoruz. Ama anonim sınıfında o metodun olması gerek run metodu
        //anonim sınıfında bulunuyor ama print bulunmuyor nesne üzerinden çağramıyoruz ama run metodu üzerinden çağrabiliyoruz.
        //değişken felanda tanımlıyabiliyoruz.
        //Ve programımızı çalıştırınca burda main sınıfında oluşturmuş olduğumuz yerler çalışmakta.

           a.run();
        //a.print();   nesne üzerinden ulaşum sağılıyamıyoruz
    }
}