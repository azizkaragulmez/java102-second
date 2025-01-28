import java.util.*;

public class Main {
    public static void main(String[] args) {

        Book k1= new Book("Atomik Alışkanlıklar",320, "James", 2019);
        Book k2= new Book("Müthiş Psikoloji",120, "Mehmet Hamdi", 2012);
        Book k3= new Book("Sınırsız",90, "Jım Kwık", 2011);
        Book k4= new Book("Yaşamak sakinlik istiyor",20, "Özgür Bacaksız", 2024);
        Book k5= new Book("Değişim kitabı",10, "Mikacel ", 2009);
        Book k6= new Book("java101",80, "James", 2019);
        Book k7= new Book("java102",10, "kanty", 2009);
        Book k8= new Book("python101",300, "thor", 2014);
        Book k9= new Book("python103",300, "adison", 2011);
        Book k10= new Book("flutter",100, "Aziz K.", 2010);

        ArrayList <Book> list = new ArrayList<>();
        list.add(k1);
        list.add(k2);
        list.add(k3);
        list.add(k4);
        list.add(k5);
        list.add(k6);
        list.add(k7);
        list.add(k8);
        list.add(k9);
        list.add(k10);

        HashMap <String,String> map = new HashMap<>();
        list.stream().forEach( i-> map.put(i.getBookname(),i.authorname));



        List <Book> books100 = list.stream().filter(i -> i.getNumpages() < 100).toList();
        books100.forEach(i-> System.out.println( i.getBookname()));



    }
}