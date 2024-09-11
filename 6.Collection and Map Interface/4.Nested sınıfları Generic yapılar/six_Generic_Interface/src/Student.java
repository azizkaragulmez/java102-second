public class Student<T>implements IDatabase<T>{//ben burdan ne gönderirisen ona göre şekilenicekIDatabase<> yerine
    //diğer bir aşama yapıyorum ve Studentuda generic yapabiliyorum.
    @Override
    public boolean insert(T data) {
        System.out.println(data);
        System.out.println("Veri eklendi");
        return true;
    }

    @Override
    public boolean delete(T data) {
        System.out.println("Veri silindi");
        return true;
    }

    @Override
    public boolean update(T data) {
        System.out.println("veri güncellendi");
        return true;
    }

    @Override
    public T select() {
        System.out.println("Veri çekildi");
        return null;
    }




}
