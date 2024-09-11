package exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //her dilde karşımıza çıkıcak bir konu önemli bir konu


        System.out.println("Program Başladı !");
        Scanner input = new Scanner(System.in);
        System.out.print("A sayısını giriniz :");
        int a = input.nextInt();
        int b = 10;
        if (a == 0) {
            System.out.println("Bir sayı sıfıra bölünemez !");
        } else {
            System.out.println(b / a);
        }
        System.out.println("Program Bitti !");


    }
}