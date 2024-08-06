package inter;

public interface IBanka {


    //String str="asd";    //interface abstractla farkı bir değişken tanımlayamıyoruz ancak varsayılan bir değer verirsek tanımlayabiliyoruz.


    final String hostIpAdress="127.0.0.1";  //interfacede genelde final yani değişmicek tanımlamalar yapılır.
     boolean connect(String ipAddress);   //abstractlarda olduğu gibi süslü parantez içine bişey yazamıyoruz interface'de.
                                            //bu demek oluyor ki bu interface kullanan sınıf bu connect metodunu oluşturmak ZORUNDA.

     boolean  payment (double price,String cardNumber,String date,String cvc);
}
