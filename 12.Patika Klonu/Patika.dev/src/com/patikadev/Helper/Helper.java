package com.patikadev.Helper;

import javax.swing.*;

//Bu yardımcı sınıfımız, uzun uzun olan kodları bura yazarak direk çağrabileceğiz ve kod düzenini sağlıyacağız.
public class Helper {

    public static void setlayout(){   //Bura da yazarak oluşturacağımız diğer tablolarda kolayca çekerek kod düzenini sağlıyabiliyoruz.
        for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }





}
