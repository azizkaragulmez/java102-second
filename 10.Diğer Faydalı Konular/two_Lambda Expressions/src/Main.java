public class Main {
    public static void main(String[] args) {

        Runnable r1= new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Sınıfı");
            }
        };
        r1.run();


        //İkisinin kullanımı aynı
        //işte buna Lambda Expressions diyoruz
        Runnable r2=() -> System.out.println("r2 sınıfı");
        /*Runnable r2=() -> {
            System.out.println("r2 sınıfı");
        };*/

        r2.run();



        //--------------------------------------------------------------


        Matematik toplama=new Matematik() {
            @Override
            public int transaction(int a, int b) {
                return a+b;
            }
        };

        Matematik çıkarma =new Matematik() {
            @Override
            public int transaction(int a, int b) {
                return a-b;
            }
        };
        System.out.println(toplama.transaction(10,2));


        //yukardakilere gerek yok diyor java ikisinin kullanımı aynı
        Matematik toplama2= (a,b) -> a+b;
        Matematik çıkarma2= (a,b)-> a-b;
        Matematik çarpma2= (a,b)-> a*b;

        System.out.println(toplama2.transaction(10,2));
        System.out.println(çıkarma2.transaction(10,2));
        System.out.println(çarpma2.transaction(10,2));


        //bu kullanımlar sadece Functional Interfaceler için geçerli olduğunu unutma





    }


}