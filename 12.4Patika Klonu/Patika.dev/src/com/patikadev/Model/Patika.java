package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class Patika {
    int id;
    String name;

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

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public static ArrayList<Patika> getlist(){  //patika nesnelerini tutuyoruz burada
        ArrayList <Patika> patikaList = new ArrayList<>();
        Patika obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM patika");
            while (rs.next()){  //hepsini gezebiliyoruz
                obj = new Patika(rs.getInt("id"), rs.getString("name"));
                patikaList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patikaList;
    }


    public static boolean add(String name){
        String query= "INSERT INTO patika (name) VALUES (?)";
        try {
            PreparedStatement pr= DBConnector.getInstance().prepareStatement(query);

            pr.setString(1,name);
            return pr.executeUpdate() != -1;
        }catch (SQLException throwables) {
           throwables.printStackTrace();
        }
        return true;
    }


    //patika içinde sağ tık yaparak açtığımız pencerede yapıyoruz güncellemeyi
    public static boolean update (int id, String name){
        String query = "UPDATE patika SET name = ? WHERE id=?";   //idsini verdiğimizin adını güncelle
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setInt(2,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  true;
    }

    public static Patika getFetch(int id) {  //Bu metod, veritabanındaki "patika" tablosundan belirli bir id değerine sahip olan satırı çekip bir Patika nesnesi olarak döndürür.
        Patika obj=null;
        String query = "SELECT * FROM patika WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Patika(rs.getInt("id"), rs.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }


    //bu patika siler ama bir yandanda course da kinide siler silinenin otomatik ordan silinmesinide sağlıyor
    public static boolean delete(int id){
        String query = "DELETE FROM patika WHERE id = ?";
        ArrayList <Course> courseList = Course.getList();  //Course.getList() → Tüm Course nesnelerinin bulunduğu bir ArrayList<Course> döndürülüyor.
        for (Course obj : courseList){                      //for (Course obj : courseList) → courseList içindeki her Course nesnesi tek tek işleniyor.
            if (obj.getPatika().getId() == id){             //obj.getPatika() → Course nesnesinin bağlı olduğu Patika nesnesini alır. .getId() == id → Eğer bu Patika'nın id değeri, verilen id ile aynıysa, bu ders (course) silinecek.
                Course.delete(obj.getId());                 //Course.delete(obj.getId()) → Şart sağlandığında, o Course nesnesi siliniyor.
            }
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

}
