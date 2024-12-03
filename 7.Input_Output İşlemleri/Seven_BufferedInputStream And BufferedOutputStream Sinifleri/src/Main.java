import java.io.*;

public class Main {
    public static void main(String[] args)


    //Buffer lar daha fazla hızlandırıyor daha hızlı verilerin okunup yazılmasını sağlar.

    {
        String data ="java ogreniyorum hahah";

        try {
            FileOutputStream fileout=new FileOutputStream("patika.txt");
            BufferedOutputStream bffout=new BufferedOutputStream(fileout);

            byte [] ByteDizi= data.getBytes();
            bffout.write(ByteDizi);
            bffout.close();
            fileout.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }











        /* bu okuma işlemi
        try {
            FileInputStream inputstr=new FileInputStream("patika.txt");
            BufferedInputStream bffinput=new BufferedInputStream(inputstr);
            int i=bffinput.read();
            while (i != -1){
                System.out.print((char) i);
                i= bffinput.read();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } */
    }
}