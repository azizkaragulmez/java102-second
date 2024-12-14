import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "05399454909krglmz";

    public static void main(String [] args) {

        Connection connect =null;
       // Statement st=null;   aşağı eklemek istedik
        String sql="SELECT * FROM student";    //SQL sorguları Java'da metin (string) olarak temsil edilir.

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement st=connect.createStatement();  //ifadesi, veritabanına bağlanmış olan connect nesnesi üzerinden SQL sorgularını
                                                      //  çalıştırmaya olanak sağlayan bir Statement nesnesi (st) oluşturur.

            ResultSet data= st.executeQuery(sql);   //executeQuery, SQL sorgusunu çalıştırır.
                                                   //ResultSet, sorgudan dönen veriyi saklar.

        /*  SIFIRINCI DEEĞERDEN BAŞLIYOR VE 1 DEĞERE SONRA 2. DEĞERE GEÇİYOR. VE EKRANA YAZMASI İÇİN HANGİ SÜTÜNDAKİ DEĞERİ YAZMASINI İSTİYORSAN ONU YAZIYORUZ ID DE OLABİLİRDİ
            data.next();
            data.next();
            System.out.println(data.getString("student_name"));
        */

          //  data.absolute(2); burdada direk çağrabiliyoruz next demeden,kullanılan yöntm değil çünkü biz collectionlara aktarıcaz zaten



            System.out.println("---------");
            while (data.next()){   //ResulSetin bir sonraki elemınanıa ulaş demek
                System.out.println("ID :"+ data.getInt("student_id"));  //dataya aktarılanı getInt çekiyoruz çünkü int değer ve sütunun adını yazıyoruz.
                System.out.println("NAME :"+data.getString("student_name"));
                System.out.println("Sınıf :"+data.getInt("student_class"));
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
