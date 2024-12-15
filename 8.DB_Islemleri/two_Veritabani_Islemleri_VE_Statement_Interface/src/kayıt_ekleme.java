import java.sql.*;

public class kayıt_ekleme {


    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "05399454909krglmz";

    public static void main(String [] args) {

        Connection connect =null;
     //1.yol: String insertsql="  INSERT INTO  student (student_name, student_class) VALUES ('Ela Naz',6)";
                          //Burda tablo adı yazıp sonra sütınisimlerini yazarız, id yazmadık çünkü Id eklemiyoruz sonra sırayla değerleri gireriz.
                          //DİKKAT-->String değer olduğu için tek tırnaka ekledik.

        String prSql="  INSERT INTO  student (student_name, student_class) VALUES (?,?)";

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st=connect.createStatement();     //BUNSUZDA OLUYOR BUNU 1. YOL VE VERİ GETİRMEDE KULLANABİLİYORUZ
            //System.out.println(st.executeUpdate(insertsql));


            //2.YOL BU KULLANIM DAHA İYİ, GÜVENLİ VE HIZLI BİR KULLANIM GENELDE BUNU KULLANIRIM DİĞERİ DAHA BASİC.
            PreparedStatement prSt= connect.prepareStatement(prSql);
            prSt.setString(1,"Aslan");
            prSt.setInt(2,99);
            prSt.executeUpdate();   //Update veri güncelleme ve verieklemede de kullanılır. Satır satır ekleme için gereklidir

            prSt.setString(1,"Naz");
            prSt.setInt(2,8);
            prSt.executeUpdate();

           //pst.addBatch(); // Sorguyu toplu işleme ekle,executeUpdate() yerine kullanılır ve (bunları chatgpt söyledi)
            // Toplu sorguları çalıştır
           // int[] affectedRows = pst.executeBatch();  // eklenen toplu işlemleri burda çalıştırır ve sürekli veritabanının çalışımasına gerek olmaz.değerleri döndürmek istersek affectedRows kullanırız.
            prSt.close();



            }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

