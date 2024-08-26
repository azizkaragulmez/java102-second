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
            myArray[size] = data;
            setSize(++size);  //artır sonra setSize ekle demek
        } else {
            this.capacity *= 2;
            setCapacity(this.capacity);
            myArray = Arrays.copyOf(myArray, this.capacity);
            myArray[size] = data;
            setSize(++size);
        }
    }

    //2.etap -------------------------------------------------------------
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
                myArray[myArray.length - 1] = null;  //dizinin boyutu bir azalat demek
                size--;  //dizinin boyutunu bir azalat demek
            }
        }
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
