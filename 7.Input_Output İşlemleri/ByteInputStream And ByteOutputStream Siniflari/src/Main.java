import java.io.ByteArrayInputStream;
import java.io.IOException;

import  java.io.ByteArrayOutputStream;

public class Main {
    public static void main(String[] args)
    {
        //AMAÇ:  Bir arrayimiz var bunların içinde de bytelar var, bunları okuyan bir stream sağlıyor
        //     bize. bunlar ne işimize yarar derseniz güvenlik işlemlerinde kripto, kriptolojide kullanılan
        //     yapılar. Programımız da güvenlik için kullanabiliriz.
        //genelde kriptolojide kullanılıyor ama kullanmamız gereken yerler olabilir byte çevirmemiz gereken yerler felan.

       byte [] dizi = {1,2,3,4,5};
        ByteArrayInputStream input = new ByteArrayInputStream(dizi,2,3); //offset başlıcağı yer, length'de kaç tanesini alacağı
        System.out.println("Kullanılabilen Byte sayısı :"+input.available());


        // input.skip(2); //atlama işini yapıyordu artık 3,4,5 yazacak
        int i=input.read();
        while (i!=-1){
            System.out.println(i);
            i=input.read();  //bunu yazmazsak sürekli 1 yazdırır bu bir sonraki byte atamamıza yarıyor.
        }
        try {
            input.close();  //bunda try catch kullandık bir sorun olursa kapatamıcanı söylüyor.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("----------");
        //BYTEOUTPUTSTREAM
        //Stringleri byte çevirdik ve güvenlik açısından

        String data =("Java ogreniyorum");

        ByteArrayOutputStream output= new ByteArrayOutputStream();
        byte [] dataByteArray = data.getBytes();  //String'i byte çevirdik.

        try {  //neden istedi belki metin olmıcak yazımda sorun olucak hata bilgisi vericek.
            output.write(dataByteArray);//biz bura kadar Stringi byte çevirdik
            String newdata=output.toString(); //geri stringe çevirmiş oluyoruz.
            System.out.println("çıktı akışı :"+newdata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}