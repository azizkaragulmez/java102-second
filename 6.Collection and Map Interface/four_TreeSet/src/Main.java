import java.util.TreeSet;

public class Main {
    public static void main(String[] args)
    {
        TreeSet<Student> students =new TreeSet<>(new OrderNameCOmparator().reversed());  //reversed tersi işlem yapmaya yarıyor
                                                                                         //TreeSet içini doldurmayınca hata alıyoruz

        students.add(new Student("Mustafa",20));
        students.add(new Student("Aziz",90));
        students.add(new Student("Behlül",45));
        students.add(new Student("Damla",60));
        students.add(new Student("Damla",60));
        students.add(new Student("Cemre",60));

        for (Student stu: students){
            System.out.println(stu.getName());
        }



    }
}