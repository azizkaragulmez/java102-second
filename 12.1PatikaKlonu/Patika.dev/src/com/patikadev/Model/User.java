package com.patikadev.Model;


import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        if (findUser != null){   //aktarılan değer null değilse daha önce o kullanıcı adı eklenmiş olduğunu anlıyoruz
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiş. Lütfen farklı bir kullanıcı adı giriniz.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);
            int response  = pr.executeUpdate();
            if (response == -1){
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


}
