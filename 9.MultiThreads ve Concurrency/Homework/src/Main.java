import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Ana listeyi oluştur
        ArrayList<Integer> mainList = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            mainList.add(i);
        }

        // 2. Listeyi 2500 elemanlık 4 parçaya böl
        int partSize = mainList.size() / 4;
        List<Integer> part1 = mainList.subList(0, partSize);
        List<Integer> part2 = mainList.subList(partSize, partSize * 2);
        List<Integer> part3 = mainList.subList(partSize * 2, partSize * 3);
        List<Integer> part4 = mainList.subList(partSize * 3, mainList.size());

        // 3. Tek ve çift sayıları tutacak ortak listeler
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        // 4. Thread tanımla ve başlat
        Thread t1 = new Thread(new NumberProcessor(part1, oddNumbers, evenNumbers));
        Thread t2 = new Thread(new NumberProcessor(part2, oddNumbers, evenNumbers));
        Thread t3 = new Thread(new NumberProcessor(part3, oddNumbers, evenNumbers));
        Thread t4 = new Thread(new NumberProcessor(part4, oddNumbers, evenNumbers));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // 5. Thread'lerin tamamlanmasını bekle
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 6. Sonuçları yazdır
        System.out.println("Toplam Tek Sayı: " + oddNumbers.size());
        System.out.println("Toplam Çift Sayı: " + evenNumbers.size());
    }
}