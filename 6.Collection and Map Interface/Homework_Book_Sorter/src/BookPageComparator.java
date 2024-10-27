import java.util.Comparator;
public class BookPageComparator implements Comparator<Book> {

    public int compare(Book o1, Book o2){
        return o1.getSayfaSayisi()-o2.getSayfaSayisi();
    }
}
