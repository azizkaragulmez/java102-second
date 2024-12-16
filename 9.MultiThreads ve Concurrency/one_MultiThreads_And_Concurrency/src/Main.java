public class Main {
    public static void main(String[] args) {
        SimpleThread simpleThread = new SimpleThread();
        simpleThread.start();

        SimpleThread simpleThread2 = new SimpleThread();
        simpleThread2.start();
    }
}