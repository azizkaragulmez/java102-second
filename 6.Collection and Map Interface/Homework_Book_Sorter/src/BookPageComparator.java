import java.util.Comparator;
// Book nesnelerini sayfa sayısına göre karşılaştırmak için Comparator arayüzünü implement eden bir sınıf.
public class BookPageComparator implements Comparator<Book> {
    // compare metodu, iki Book nesnesini karşılaştırır.
    public int compare(Book o1, Book o2){
        // o1 ve o2'nin sayfa sayıları arasındaki farkı döndürür.
        // Eğer o1'in sayfa sayısı o2'den küçükse negatif bir değer döner.
        // Eğer o1'in sayfa sayısı o2'ye eşitse sıfır döner.
        // Eğer o1'in sayfa sayısı o2'den büyükse pozitif bir değer döner.
        return o1.getSayfaSayisi()-o2.getSayfaSayisi();
    }
}
