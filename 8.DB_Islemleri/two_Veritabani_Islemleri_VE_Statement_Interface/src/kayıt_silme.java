import java.sql.*;

public class kayıt_silme {

    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "05399454909krglmz";

    public static void main(String [] args) {

        Connection connect =null;

        String stSql="DELETE FROM student WHERE student_id = 4";
        String prSql="DELETE FROM student WHERE student_id=?";

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st=connect.createStatement();
            st.executeUpdate(stSql);
            st.close();


            //2.Yol en iyi yol ama çok silme yapıcaksan Batch'ler daha iyi ama ınsertlerde kayıt eklemekte daha iyi
            PreparedStatement pr =connect.prepareStatement(prSql);
            pr.setInt(1,3);
            pr.executeUpdate();
            st.close();



        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}



