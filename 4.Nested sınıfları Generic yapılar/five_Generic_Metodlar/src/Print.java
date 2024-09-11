public class Print {  //sınıfı generic yapmaya gerek yok metod yapabilirsin sadece


   public static <T> void printArray(T[] arr){   //sıralaması dikkat //T yazmak zoorundayız generic olduğunu anlamak için
        for (T i:arr){
            System.out.println(i);
        }
    }

    public static <T,U> void printArray(T[] arr,U[]arr2){   //Birden fazla tanımlama yapabiliyorsun
        for (T i:arr){
            System.out.println(i);
        }
        for (U i:arr2){
            System.out.println(i);
        }
    }

}
