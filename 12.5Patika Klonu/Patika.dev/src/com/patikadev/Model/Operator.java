package com.patikadev.Model;


import javax.swing.*;

//Bura da veritabanında oluşturduğumuz kullanıcı yönetici için ayrı kod yazarak karışıklığı önlüyoruz ve bunların
//ata sınıfı User olduğu için extends ediyoruz
public class Operator extends User{

    public Operator(){

    }

    public Operator (int id, String name, String uname, String pass, String type){
        super(id, name, uname, pass, type);
    }


}
