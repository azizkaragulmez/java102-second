public class OrderMatic implements Runnable{

    private int orderNo;
    private  final Object LOCK = new Object();

    public OrderMatic (){
        this.orderNo=0;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // synchronized (LOCK){
        //     this.orderNo++;
        //     System.out.println(Thread.currentThread().getName()+ " - OrderNo => "+this.orderNo);
        //}
        increaseOrder();
    }

    //YUKARDA YORUM SATIRINA ALDIĞIMIZI BU YOLLADA YAPARIZ AYRI METOD YAZARAK
    public synchronized void increaseOrder (){
        this.orderNo++;
        System.out.println(Thread.currentThread().getName()+ " - OrderNo => "+this.orderNo);

    }


    public void setOrderNo(int orderNo){
        this.orderNo=orderNo;
    }

    public int getOrderNo() {
        return orderNo;
    }
}