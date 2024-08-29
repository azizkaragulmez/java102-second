import java.util.Arrays;

public class MyList<T> {
    private int capacity;
    private int size = 0;
    private Object[] myArray;


    public MyList() {
        this.capacity = 10;
        this.myArray = (T[]) new Object[this.capacity];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.myArray = (T[]) new Object[this.capacity];


    }

    //size dizide ki eleman sayısı
    public void add(T data) {
        if (this.capacity > size) {
            this.myArray[size] = data;
            setSize(++size);  //artır sonra setSize ekle demek
        } else {
            this.capacity *= 2;
            setCapacity(this.capacity);
            myArray = Arrays.copyOf(myArray, this.capacity);
            myArray[size] = data;
            setSize(++size);
        }
    }

    //2.etap -----------------------------------------------------------------------------------------------------------
    public Object get(int index) {  //Object yaptık çünkü arrayın tipi o
        if (myArray[index] != null) {
            return this.myArray[index];
        }
        return null;
    }

    public void remove(int index) {
        if (myArray[index] != null) {
            for (int i = 0; i < myArray.length - 1; i++) {
                if (index == i) {
                    myArray[i] = myArray[i + 1];
                }

            }
            myArray[myArray.length - 1] = null;  //dizinin boyutu bir azalat demek
            size--;  //dizinin boyutunu bir azalat demek
        }
    }

    public Object set(int index, T data) {
        if (myArray[index] != null) {
            myArray[index] = data;
        }
        return null;
    }
    
    //listelemeye yarar ben yapıtğımda null değerleride çıkıyorud bunda çıktı->[10, 20, 223, 40, 50, 60, 70, 80, 90, 100, 110]
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] != null) {
                result.append(myArray[i]);
                // Eğer son eleman değilse, bir virgül ve boşluk ekle
                if (i < myArray.length - 1) {
                    result.append(", ");
                }
            }
        }
        // Dizinin sonunda boşluk ve virgül var mı kontrol et
        if (result.length() > 1 && result.substring(result.length() - 2).equals(", ")) { //It doesn't matter much, it solves the comma problem at the end.
            result.setLength(result.length() - 2);
        }
        result.append("]");
        return result.toString();
    }

    //3. ETAP ----------------------------------------------------------------------------------------------------------

    public int indexOf(T data) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {  //size bulunan elemanların boyutu yani içinde kaç tane olduğu bildiğimiz.
        for (int i = this.size; i > 0; i--) {
            if (myArray[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf(myArray, size);

    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            myArray[i] = null;
        }
        this.size = 0;
    }

    public MyList<Object> sublist(int start, int finish) {  //tür farklıyken ekliyemedim bende aynı tür yaptım<T> yerine Object yaptım.
        MyList<Object> temp = new MyList<>();
        for (int i = start; i < finish; i++) {
            temp.add(myArray[i]);
        }
        return temp;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (myArray[i] == data) {
                return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getMyArray() {
        return myArray;
    }

    public void setMyArray(T[] myArray) {
        this.myArray = myArray;
    }
}
