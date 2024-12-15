import java.sql.*;

public class kayıt_güncelleme {
    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "05399454909krglmz";

    public static void main(String [] args) {

        Connection connect =null;
        String stSql="UPDATE student SET student_name='Mahmut K' WHERE student_id=1 ";
        String prSql="UPDATE student SET  student_name=? WHERE student_id=?";

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st=connect.createStatement();
            st.executeUpdate(stSql);

            //2.YOL
            PreparedStatement pr= connect.prepareStatement(prSql);
            pr.setString(1,"Kral");
            pr.setInt(2,9);
            pr.executeUpdate();







        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
