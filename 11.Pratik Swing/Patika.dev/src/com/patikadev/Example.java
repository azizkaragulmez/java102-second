package com.patikadev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame { //Example sınıfı, JFrame sınıfının tüm özelliklerini ve metodlarını miras alır.
    // (buranın çalışması için kod parçacığı var onu yazıp kalabalık olmasın diye extends yaptık)
    private JPanel wrapper;
    private JPanel Wbottom;
    private JPanel wtop;
    private JTextField fld_username;
    private JLabel lbl_kullanıcıadı;
    private JPasswordField fld_password;
    private JButton btn_login;

    public Example() {                          //bir constroctor
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            // System.out.println(info.getName() + "->"+ info.getClassName());     //Burda hazır temaları görmek için yazdık. consolda yazar
            if ("Nimbus".equals(info.getName()))  //burda if alıp olası hatanın önüne geçmiş oluyoruz
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");   //tasarımı değiştir diyoruz. Try catch almamızı istiyor
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }

        }


        setContentPane(wrapper);                //altakide olur bu kullanımda olur.
        // this.add(wrapper);
        setSize(400, 300);          //oluşacak pencerenin boyutu
        setTitle("Uygulama Adı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //Var olan uygulamanın kapatılmasını sağlar. Biz çarpı yapınca durmuyor ya işte çarpıya basınca dursun diye
        setResizable(false);                      //Bu pencerenin boyutunun yeniden ayarlanmasını engeller
        setLocationRelativeTo(null);             //Ekranın ortasında açalmasını sağlar
        setVisible(true);                        //pencereyi görünür hale getirir



        //actionlistenera tıkladığımızda otomatik kodumuzu oluşturuyor, biz lamda çevirdik daha kısa olsun diye çok gerekli değil
        btn_login.addActionListener(e -> {
           // System.out.println(fld_username.getText());  //içine yazılan değeri butona tıklayınca consolda görebiliyoruz
            if (fld_username.getText().length() == 0 || fld_password.getText().length() == 0){  //direk boyutundan anlıyoruz
                JOptionPane.showMessageDialog(null,"Tüm Alanları Doldurun","HATA",JOptionPane.INFORMATION_MESSAGE);
                //Burda kullanıcı ile etkileşime girdik bütün alanlar dolu olmadığı için hata mesejı vericez butona basıldığında
            }

        });
    }
}
