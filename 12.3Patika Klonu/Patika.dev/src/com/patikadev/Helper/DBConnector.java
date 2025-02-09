package com.patikadev.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Burda sürekli kullanıcağımız veritabanı işlemleri kodlarını bura yazarak kod düzenini koruyoruz
public class DBConnector {

    private Connection connect = null;

    public Connection connectionDB() {  //Burada Connection türünde bir class oluşturuyoruz
        try {
            this.connect = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.connect;
    }


    // getInstance() metodunun amacı, sürekli yeni bağlantılar oluşturmak yerine var olan bağlantıyı tekrar kullanmaktır.
    // Bu, veritabanı bağlantısı gibi sınırlı kaynakları yönetmek için verimli bir yaklaşım sağlar.
    // DBConnector sınıfını ilk oluşturduğunda bir bağlantı açılır.
    // Eğer tekrar getInstance() çağrılırsa, aynı bağlantı geri döndürülür.
    //  Böylece, her seferinde yeni bir bağlantı oluşturmak yerine tek bir bağlantıyı sürekli kullanmış olursun.
    public static Connection getInstance() {
        DBConnector db = new DBConnector();
        return db.connectionDB();
    }

}
