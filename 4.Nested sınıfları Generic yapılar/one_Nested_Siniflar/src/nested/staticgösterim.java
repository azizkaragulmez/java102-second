package nested;
//DİĞER BİR ALT BAŞLIĞI STATİC OLAN
public class staticgösterim {
    public int a=5;
    public static int b=12;

    //Inner class (iç sınıf)
    public static class In{   //biz önceki kullanımda biliyoruz ki outtan bir nesne üretip ulaşabiliyorduk.
                              // Static tanımlayınca  direk erişim sağlıyabiliyoruz.
        public static int a=10;   //buna ulaşmak için static yaptık sonra altta
        public static void run(){   //içindeki metoduda static yapmamız gerekli
            //içiteki sınıfın bir metodu
            //In sınıfına ait run metodu
            System.out.println("In sınıfına ait run metodu..!");
            int a=1;
            System.out.println(a);     //1
            System.out.println(In.a); //10 bu sınıftaki a anlamına geliyor this ile. diğerinde this ti şimdi farklı
            System.out.println(staticgösterim.b);  // (sadece bunda sorun çıktı static yapınca)
                                                   //ama ulaşmak için value static yaptık ve onu çağırmak için this kullanmadık.
        }

    }
    public void run(){
        //Out sınıfına ait run metodu

        In.run();

    }
}


