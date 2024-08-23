package nested;

public class Local {

    public void run() {
        class Yerel {    //buna local sınıf deniliyor
            private int a;

            public Yerel(int a) {
                this.a = a;
            }

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }
        }
        Yerel y=new Yerel(15);
        System.out.println("Local sınıfı çalıştı");
        System.out.println(y.getA());
    }
    public void print(){
      //  Yerel y=new Yerel(16);     yerel sınıfından nesne üretilmedi çünkü yerel run metodu içerisinde çalıştı tanımlandı
    }
}
