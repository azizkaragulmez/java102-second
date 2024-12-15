import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static final String DB_URL="jdbc:mysql://localhost/university";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="05399454909krglmz";

    public static void main(String[] args) {

            Connection conn=null;
            try  {
               conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                // Otomatik commit özelliğini kapatıyoruz
                conn.setAutoCommit(false);

                // İlk işlem: Hesaptan para çekme
                String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
                try (PreparedStatement withdrawStmt = conn.prepareStatement(withdrawSQL)) {
                    withdrawStmt.setDouble(1, 100); // 100 TL çek
                    withdrawStmt.setInt(2, 1);      // Hesap ID: 1
                    withdrawStmt.executeUpdate();
                }

                // İkinci işlem: Başka hesaba para yatırma
                String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
                try (PreparedStatement depositStmt = conn.prepareStatement(depositSQL)) {
                    depositStmt.setDouble(1, 100); // 100 TL yatır
                    depositStmt.setInt(2, 2);      // Hesap ID: 2
                    depositStmt.executeUpdate();
                }

                // Eğer buraya kadar hata yoksa işlemleri kalıcı yapıyoruz
                conn.commit();
                System.out.println("Transaction başarıyla tamamlandı!");

            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    // Hata durumunda işlemleri geri al
                    if (conn != null) {
                        conn.rollback();
                        System.out.println("Transaction geri alındı!");
                    }
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }}}
