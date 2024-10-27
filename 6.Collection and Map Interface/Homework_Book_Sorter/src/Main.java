import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        List<Book> sıralama= new LinkedList<>() {
        };

        sıralama.add(new Book("Aziz konuşuyor",120,"AK",2000));
        sıralama.add(new Book("Sultan konuşuyor",123,"SK",2001));
        sıralama.add(new Book("Meryem konuşuyor",122,"MK",1964));
        sıralama.add(new Book("Ahmet konuşuyor",121,"AK2",1961));
        sıralama.add(new Book("Aslan konuşuyor",124,"AK3",2026));
        Collections.sort(sıralama);

        for (Book b: sıralama){
            System.out.println(b.getName());
        }

        System.out.println("------------");

        TreeSet<Book> set2 = new TreeSet<>(new BookPageComparator());

        set2.add(new Book("Aziz konuşuyor",120,"AK",2000));
        set2.add(new Book("Sultan konuşuyor",123,"SK",2001));
        set2.add(new Book("Meryem konuşuyor",122,"MK",1964));
        set2.add(new Book("Ahmet konuşuyor",121,"AK2",1961));
        set2.add(new Book("Aslan konuşuyor",124,"AK3",2026));

        for (Book book : set2){
            System.out.println(book.getName());
        }
    }
}