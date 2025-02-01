package com.patikadev.Model;


import com.patikadev.Helper.DBConnector;

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


}
