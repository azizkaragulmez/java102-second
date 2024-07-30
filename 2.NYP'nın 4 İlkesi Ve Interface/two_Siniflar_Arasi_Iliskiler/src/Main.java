public class Main {
    public static void main(String[] args)
    {
       Student st1 = new Student("Aziz ","Karagülmez","123","AA",100);
       Student st2 = new Student("Patika ","Dev","111","BB",80);
       Student st3 = new Student("Kodluyoruz","Java102", "12312","CC",90);

       Instructor teacher = new Instructor("Mahmut","Kel","CENG");

       //kalıtım (Inheritance) is a (sonraki konuda görücez.
     //Composition, Aggregation
    //Course has a Instructor (Sınıfın bir öğretmeni vardır.)
    Course mat=new Course("Mat101","Mat",teacher);

        System.out.println(mat.getInstructor().getName());
        System.out.println(teacher.getName());       //yukardaki ile ikisi de aynı işlemi yapıyor.
    //Student[] stu= {st1,st2,st3};
    //System.out.println("Ortalama="+mat.calcAvarage(stu));

    }
}