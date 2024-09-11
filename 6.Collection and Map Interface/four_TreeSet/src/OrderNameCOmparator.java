import java.util.Comparator;

public class OrderNameCOmparator implements Comparator<Student> {
    @Override
    public int compare(Student o1,Student o2) {         //compare java içinde bir metod
        return o1.getName().compareTo(o2.getName());
    }
}
