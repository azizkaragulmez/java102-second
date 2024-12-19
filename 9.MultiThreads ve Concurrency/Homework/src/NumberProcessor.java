import java.util.List;

// NumberProcessor sınıfı (Runnable ile thread oluşturuyoruz)
class NumberProcessor implements Runnable {
    private List<Integer> subList; // İşlenecek kısmi liste
    private List<Integer> oddNumbers; // Ortak tek sayılar listesi
    private List<Integer> evenNumbers; // Ortak çift sayılar listesi

    public NumberProcessor(List<Integer> subList, List<Integer> oddNumbers, List<Integer> evenNumbers) {
        this.subList = subList;
        this.oddNumbers = oddNumbers;
        this.evenNumbers = evenNumbers;
    }

    @Override
    public void run() {
        for (int number : subList) {
            if (number % 2 == 0) {
                synchronized (evenNumbers) {
                    evenNumbers.add(number); // Çift sayıları ekle
                }
            } else {
                synchronized (oddNumbers) {
                    oddNumbers.add(number); // Tek sayıları ekle
                }
            }
        }
    }
}