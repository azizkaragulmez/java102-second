public class User {
    public String name;
    public static int counter;  //bura bir değer atamazsak varsayılan değer 0 sayar ama bu yanlış kullanım bir değer atanmalı.
                                //değeri silme nedenim alta randomla bir değer atadığım için.

     static {    //biz counture direk değer atayamıyoruz yani şartlı ama static kod blokları sayesinde atayabiliyoruz.
                //burda static kelimesi olmasa sadece kod blokları olsa main sınıfında kaç kere çağrısak tekrarlardı burda bir kere
                //hafızaya atıyoruz. dğru kullanım static yazılmasıdır.
        int random=(int)(Math.random()*10);
        System.out.println("Random Sayı  :"+random);
        counter=random;
    }

    public User (String name){
        this.name=name;
        counter++;
    }
}
