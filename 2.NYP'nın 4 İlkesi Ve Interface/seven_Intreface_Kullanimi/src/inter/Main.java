package inter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);


        System.out.print("Tutar giriniz :");
        double price= input.nextDouble();

        System.out.print("Kart No giriniz :");
        String cardNumber= input.next();

        System.out.print("Son Kullanım Tarihi giriniz :");
        String date= input.next();

        System.out.print("Güvenlik Kodu Giriniz :");
        String cvc=input.next();

        System.out.println("1. A Bankası");
        System.out.println("2. B Bankası");
        System.out.println("3. C Bankası");
        System.out.println("Banka Seçimi Yapınız Lütfen");
        int selectBank= input.nextInt();

        switch (selectBank)
        {
            case 1:
                    ABankasi aPos=new ABankasi("A Bankası","123123123","123123");
                    aPos.connect("127.1.1.1");
                    aPos.payment(price,cardNumber,date,cvc);
                break;

            case 2:
                BBankasi BPos=new BBankasi("B   Bankası","123123","123456");
                BPos.connect("127.1.1.1");
                BPos.payment(100,"3242","21 ağustos","233");
                break;





            default:
                System.out.println("Yanlış Tuşlama Yaptınız.");
        }


    }
}