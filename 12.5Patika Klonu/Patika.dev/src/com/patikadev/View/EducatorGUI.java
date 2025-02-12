package com.patikadev.View;

import com.patikadev.Helper.Config;

import javax.swing.*;

public class EducatorGUI  extends JFrame{
    private JPanel wrapper;

    public EducatorGUI (){
        add(wrapper);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TİTLE);
        setResizable(false);            //Pencerenin boyutunun kullanıcı tarafından değiştirilmesini engeller. Eğer true olursa, kullanıcı pencerenin boyutunu değiştirebilir.
        setVisible(true);                //setVisible(true); Pencereyi görünür hale getirir.
    }
}
