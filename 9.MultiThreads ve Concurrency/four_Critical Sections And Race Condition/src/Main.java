import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {


            OrderMatic or= new OrderMatic();
            List<Thread> islemler =new ArrayList<>();
            for (int i=0; i<100; i++){
                Thread t=new Thread(or);
                islemler.add(t);
                t.start();
            }














        /*İLK DENEME
        OrderMatic orderMatic = new OrderMatic(1);

        Thread th= new Thread(orderMatic);
        th.start();
        th.join();

        Thread th2= new Thread(orderMatic);
        th2.start();
        th.join();
        */




    }
}