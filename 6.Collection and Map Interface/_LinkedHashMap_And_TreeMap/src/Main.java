import java.rmi.StubNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

       // HashMap<Integer, Student> students = new HashMap<>();
       // LinkedHashMap<Integer, Student> students = new LinkedHashMap<>();  //LinkedSetlerde olduğu gibi LİnkedHashMaplerde girilen sırayla çıkıyor.
        // TreeMap oluşturma, OrderByNoComparator ile sıralama reverse() diyerek tersine
        TreeMap<Integer, Student> students = new TreeMap<>(new OrderByNoComparator().reversed());

        students.put(102, new Student(102, "Aziz", 100));
        students.put(104, new Student(104, "Ahmet", 56));
        students.put(105, new Student(105, "Meryem", 88));
        students.put(103, new Student(103, "Sultan", 83));


        for (Student stu: students.values()){
            System.out.println(stu.getName());
        }

    }}