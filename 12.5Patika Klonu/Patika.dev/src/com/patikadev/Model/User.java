package com.patikadev.Model;


import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Model adında bir paket oluşturduk burda amaç kodlama düzeni.
//User adında bir tane sınıf oluşturduk burda veritabanındakileri bura aktarıp nesneleştircez yani modellicez.
public class User {

    //Burda veritabanındaki sütunların adında oluşturduk
    private int id;
    private String name;
    private String uname;
    private String pass;


    public User() {
    }

    public User(int id, String name, String uname, String pass, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.pass = pass;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


    //Veritabanın daki userları alıp bir user nesnesi oluşturup onu br Arrayliste atmasını istiyoruz
    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>(); //Burda bir boş bir ArrayList oluşturduk
        String query = "SELECT * FROM user";
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();   //Direk veritabanı bağlantısını yapıyoruz
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();  //User obj = new User(): Burada, User adında bir nesne oluşturuluyor. Bu nesne veritabanından alınan verileri saklamak için kullanılır.
                obj.setId(rs.getInt("id"));   //rs.getInt("id"): id sütunundaki değeri alır ve bu değeri User nesnesinin setId() metodu ile obj nesnesine atar.
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }


    //Ekle butonu için veri tabanına eklicemiz için bir metod yazıyoruz  //ekleme işlemi burd gerçekleşiyor
    public static boolean add(String name, String uname, String pass, String type) {  //ekle işleminin gerçekleştiyse true döner
        String query = "INSERT INTO user (name, uname, pass, type) VALUES (?,?,?,?)";
        User findUser = User.getFetchByUname(uname);      //Burda Uname aynı olmaması işlemi için eklendi. altıda aynı olmaması için
        if (findUser != null) {   //aktarılan değer null değilse daha önce o kullanıcı adı eklenmiş olduğunu anlıyoruz
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiş. Lütfen farklı bir kullanıcı adı giriniz.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);
            int response = pr.executeUpdate();
            if (response == -1) {
                Helper.showMsg("Error");
            }
            return response != -1;  //executeUpdate başarılı ise 1 değilse -1 yolluyordu
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    //Burda uname aynı olması istemiyoruz
    public static User getFetchByUname(String uname) {
        User obj = null;
        String query = "SELECT * FROM user WHERE uname = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);  //? olan yere uname parametresi yerleştiriliyor. 1 buradaki ilk ve tek parametreyi temsil ediyor.
            ResultSet rs = pr.executeQuery();     //executeQuery(), SELECT sorguları için kullanılır ve sorgu sonucu döndürür.
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));  //ResultSet içindeki kullanıcı bilgileri alınarak User nesnesine atanıyor.
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;    //Eğer kullanıcı bulunduysa, içi dolu bir User nesnesi döndürülüyor. Eğer kullanıcı bulunamazsa, obj hâlâ null olduğu için null döndürülüyor.
    }



    //bunu en son videodan 1öncekinde oluşturduk çünkü Coursede User nesnesine id yoluyla ulaşmak için (aşırı yüklenme işlemi yaptık)overloading
    public static User getFetchByUname(int id) {
        User obj = null;
        String query = "SELECT * FROM user WHERE id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);  //? olan yere uname parametresi yerleştiriliyor. 1 buradaki ilk ve tek parametreyi temsil ediyor.
            ResultSet rs = pr.executeQuery();     //executeQuery(), SELECT sorguları için kullanılır ve sorgu sonucu döndürür.
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));  //ResultSet içindeki kullanıcı bilgileri alınarak User nesnesine atanıyor.
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;    //Eğer kullanıcı bulunduysa, içi dolu bir User nesnesi döndürülüyor. Eğer kullanıcı bulunamazsa, obj hâlâ null olduğu için null döndürülüyor.
    }



    //Login ekranı için oluşturuk
    public static User getFetchByUname(String uname, String pass) {
        User obj = null;
        String query = "SELECT * FROM user WHERE uname = ? AND pass= ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);  //? olan yere uname parametresi yerleştiriliyor. 1 buradaki ilk ve tek parametreyi temsil ediyor.
            pr.setString(2,pass);
            ResultSet rs = pr.executeQuery();     //executeQuery(), SELECT sorguları için kullanılır ve sorgu sonucu döndürür.
            if (rs.next()) {   //Login ekranı için oluşturduk
                switch (rs.getString("type")){
                    case "operator":
                        obj = new Operator();
                        break;
                    default:
                        obj = new User();
                }
                obj.setId(rs.getInt("id"));  //ResultSet içindeki kullanıcı bilgileri alınarak User nesnesine atanıyor.
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;    //Eğer kullanıcı bulunduysa, içi dolu bir User nesnesi döndürülüyor. Eğer kullanıcı bulunamazsa, obj hâlâ null olduğu için null döndürülüyor.
    }



    //silme işlemleri yaparken oluşturduk
    public static boolean delete(int id) {
        String query = "DELETE FROM user WHERE id = ?";
        ArrayList <Course> coursesList= Course.getListByUser(id);  //bunu coursta oluşan ve silinmiş educoatın eğitimin silinmesi için ekledik
        for (Course c : coursesList){
                Course.delete(c.getId());
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean update(int id, String name, String uname, String pass, String type) {
        String query = "UPDATE user SET name=?, uname=?, pass=?, type=? WHERE id=?";
        User findUser = User.getFetchByUname(uname);      //Burda Uname aynı olmaması işlemi için eklendi. altıda aynı olmaması için
        List<String> validTypes = Arrays.asList("educator","student","operator");  //sadece bizim belirlediğimiz şeyler olamsını istiyoruz type kısmı için (ben ekledim)
           if (findUser != null && findUser.getId() != id || !validTypes.contains(type) ) {  //(contains demezsek içini okuyamıyor) //aktarılan değer null değilse daha önce o kullanıcı adı eklenmiş olduğunu anlıyoruz ve
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiş veya üyelik tipiniz yanlış. Lütfen tekrar deneyiniz.");  //Eğer bu kullanıcı adı daha önce eklenmişse, findUser null olmaz.  Ancak güncellenen kullanıcıyla aynı ID'ye sahipse sorun yok, çünkü kendi bilgilerini değiştirebilir
                                                                                                                     //Eğer farklı bir id'ye sahip bir kullanıcı zaten bu adı kullanıyorsa, hata mesajı gösterilir ve işlem engellenir.
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);
            pr.setInt(5, id);  //id int olduğu için
            return pr.executeUpdate() != -1;   //xecuteUpdate() çağrıldığında, SQL komutu çalıştırılır ve etkilenen satır sayısı döndürülür. Eğer 1 dönerse, 1 satır güncellenmiştir.
            //Eğer 0 dönerse, güncellenen satır yoktur (WHERE id=? koşulu eşleşmemiştir). Bazı JDBC sürümlerinde -1 dönebilir, ancak genellikle > 0 kontrolü yapılır.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    //Arama işlemi için
    public static ArrayList<User> searchUserList(String query) {  //(yukardaki getListen aldık sadece sorgusu değiştirdik)
        ArrayList<User> userList = new ArrayList<>(); //Burda bir boş bir ArrayList oluşturduk
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();   //Direk veritabanı bağlantısını yapıyoruz
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();  //User obj = new User(): Burada, User adında bir nesne oluşturuluyor. Bu nesne veritabanından alınan verileri saklamak için kullanılır.
                obj.setId(rs.getInt("id"));   //rs.getInt("id"): id sütunundaki değeri alır ve bu değeri User nesnesinin setId() metodu ile obj nesnesine atar.
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }


    //Bu aramada hepsi dolu olmasada listelesin diye ve dianmik olarak sorgu yaratmak için yazdık yukardaki kod için
    public  static String searchQuery(String name, String uname, String type){
            String query = "SELECT * FROM user WHERE uname LIKE '%%{{uname}}%%' AND name LIKE '%%{{name}}%%' ";
            query= query.replace("{{uname}}",uname);
            query= query.replace("{{name}}",name);
            if (!type.isEmpty()) {
                query += "AND type ='{{type}}'";
                query = query.replace("{{type}}", type);
            }
            return query;

    }


}
