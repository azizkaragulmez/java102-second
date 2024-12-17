public class SimpleThread
        extends Thread {

    @Override
    public void run() {
        // o an çalışan Thread'in ismini alıyoruz.
        String threadName = Thread.currentThread().getName();

        System.out.println("My summation " + threadName + " is started!");

        int total = 0;
        for(int i=0; i < 1000; i++)
        {
            total += i;
        }

        System.out.println("Total: " + total);
    }
}
