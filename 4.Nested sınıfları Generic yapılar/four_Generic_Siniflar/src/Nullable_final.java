public class Nullable_final <T>{ //bu ifade bunun generic tip olduğunu gösterir. "T" verdik genelde T verilir ama istediğimizi verebiliriz.

        private final T value;

        public Nullable_final(T value){
            this.value=value;
        }

        public T getValue(){
            return this.value;
        }


        public boolean isNull(){
            return this.getValue()==null;
        }

        public void run(){
            if (isNull()){
                System.out.println("Bu değişkene değer atanmamış");
            }
            else {
                System.out.println(this.getValue());
            }
        }





}
