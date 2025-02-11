package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Patika;

import javax.swing.*;


public class UpdatePatikaGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_patika_name;
    private JButton btn_update;
    private Patika patika; //manuel kendimiz oluşturduk çünkü patika bölümüyle bağlantılı olucak

    public UpdatePatikaGUI(Patika patika){      //constroctor oluşturduk
        this.patika= patika;
        add(wrapper); //wrapper bizim Jpanel zaten
        setSize(300,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TİTLE);
        setVisible(true);
        setResizable(false);
        fld_patika_name.setText(patika.getName());


        //güncelle penceresindeki güncelle butonu
        btn_update.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_patika_name)){
                Helper.showMsg("fill");
            }else {
                if (Patika.update(patika.getId(), fld_patika_name.getText())){
                    Helper.showMsg("done");
                }
                dispose();  //hata varsada kapatsın istedik pencereyi
            }
        });
    }



}
