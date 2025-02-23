package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_uname;
    private JPasswordField fld_user_pass;
    private JButton btn_login;

    public LoginGUI() { //constractır
        add(wrapper);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TİTLE);
        setResizable(false);            //Pencerenin boyutunun kullanıcı tarafından değiştirilmesini engeller. Eğer true olursa, kullanıcı pencerenin boyutunu değiştirebilir.
        setVisible(true);                //setVisible(true); Pencereyi görünür hale getirir.

        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)) {
                Helper.showMsg("fill");
            } else {
                User u = User.getFetchByUname(fld_user_uname.getText(), fld_user_pass.getText());   //burda aldığımız değerleri getFetchByUname gönderdik, iki parametreli
                if (u == null) {
                    Helper.showMsg("Kullanıcı Bulunamadı !");
                } else {
                    switch (u.getType()) {
                        case "operator":
                            OperatorGUI opGUI = new OperatorGUI((Operator) u);  //Operator türün de istediği için
                            break;
                        case "educator":
                            EducatorGUI edGUI = new EducatorGUI();
                            break;
                        case "student":
                            StudentGUI stGUI = new StudentGUI();
                            break;
                    }
                    dispose();  //ekranı kapatmaya yarar
                }
            }

        });
    }


    public static void main(String[] args) {
        Helper.setlayout();
        LoginGUI loginGUI = new LoginGUI();
    }
}
