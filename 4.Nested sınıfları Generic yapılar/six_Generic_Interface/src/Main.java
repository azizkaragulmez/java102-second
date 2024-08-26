public class Main {
    public static void main(String[] args)
    {
        Student<String> std=new Student<>();
        std.insert("ABC");  //String yaptık

        Student<Integer> std2=new Student<>();
        std2.insert(123);

        //biz tipini belirlemek istemediğimizde interface de generic yapı oluşturabiliyoruz.

    }
}