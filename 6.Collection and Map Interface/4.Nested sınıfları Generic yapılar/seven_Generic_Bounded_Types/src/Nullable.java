//public class Nullable<T extends Number> {  //extends diyerek Number dersek bir sınırlandırma yapmış olduk sayısal değer alabilir demek

public class Nullable<T extends B> {    //ikinci örnek
    private final T value;

    public Nullable(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }


    public boolean isNull() {
        return this.getValue() == null;
    }

    public void run() {
        if (isNull()) {
            System.out.println("Bu değişkene değer atanmamış");
        } else {
            System.out.println(this.getValue());
        }
    }


}

