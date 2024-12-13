import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection connect=null;
        String url = "jdbc:mysql://localhost/university?user=root&password=05399454909krglmz";

        try {

            connect = DriverManager.getConnection(url);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}