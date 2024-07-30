public class MyClass {
    // Statik değişkenler
    static int a = 10;
    static int b = 20;

    // Statik blok
    static {
        System.out.println("Statik blok çalışıyor.");
        a = 30;
        b = 40;
    }

    // Statik metot
    public static void printValues() {
        System.out.println("a: " + a + ", b: " + b);
    }
}
