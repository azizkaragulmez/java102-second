package nested;
//Outter class (dış sınıf)
public class Out {
    public int a=5;

    //Inner class (iç sınıf)
    public class In{   //bu bir metod deği sıınıf iç içe sınıf kullanımını öğreniyoruz.

        public int a=10;
        public static void run(){   //içiteki sınıfın bir metodu
            //In sınıfına ait run metodu
            System.out.println("In sınıfına ait run metodu..!");
            int a=1;
            System.out.println(a);     //1
        //    System.out.println(this.a); //10 bu sınıftaki a anlamına geliyor this ile.
         //   System.out.println(Out.this.a);  //Out sınıfındaki a ya erişmek için bu yöntem kullanılıyor.
            //bu sınıfa ait bir dış sınıf var ise ondaki değişkene ulaşabilmek için o sınıfın ismi "."+this+ değişkenin adı yazılır.
            //metodda aynı şekilde dış sınıfa öyle ulaşabiliriz
        }
     //içteki dıştakine ulaşması için yukarda söyledik
     //dıştakinin içe ulaşması için nesne üretmesi gerektiğini biliyoruz.
    }
    public void run(){
        //Out sınıfına ait run metodu
        In in=new In();   //bir sınıftan nesne oluşturmak için onu çağırmamız gerekiyor bildiğimiz gibi
        in.run();

    }
}
