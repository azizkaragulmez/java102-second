package com.patikadev.View;

import com.patikadev.Helper.*;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OperatorGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;

    //Altakileri veri tabanında ki verileri GUI ye aktarmak için kullanıcaz
    private DefaultTableModel mdl_user_list; /*DefaultTableModel: Bu, Swing'in JTable bileşeniyle verileri yönetmek için kullanılan
                                            bir model sınıfıdır. JTable'de gösterilen veriler, genellikle bir model aracılığıyla
                                            yönetilir. DefaultTableModel, JTable için verilerin saklanmasını, düzenlenmesini ve
                                            güncellenmesini sağlayan varsayılan bir sınıftır.*/
    private  Object[] row_user_list;   //veritabanı işlemleri ne atarsa Onject türünde atıcam demek
    //Object[]: Bu, Java'daki dizi (array) yapısının bir örneğidir. Burada Object[], JTable'e eklenecek bir satırdaki verileri
    // tutmak için kullanılır. Object tipi, herhangi bir veri türünü tutabilen bir türdür.



    private final Operator operator;   //bu ekranı sadece operator işlemi için kullanıcağımız için oluşturuduk

    public OperatorGUI(Operator operator) {  //Bura da operator atmadan buranın çalışmayacağını belirtik
        this.operator=operator;             //Bura da constroctorını oluşturuduk


        add(wrapper);            //JPanel i eklememiz gerekli
        setSize(1000, 500);  //Büyüklüğü
        setLocationRelativeTo(null);      //ortada açılması
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //çarpı işlemi ile ilgiliydi
        setTitle(Config.PROJECT_TİTLE);   //Config sınıfı yaptık direk çağırdık direk ordan değiştirerek heryerde değiştirebiliriz.
        setVisible(true);  //pencerenin görünür olmasını sağlar
        setResizable(false);  //pencerenin küçülüp büyümesini engeller


        lbl_welcome.setText("Hoşgeldin : "+ operator.getName());   //Oluşturduğumuz lable ı Textine operator sınıfının ismini atadık

        //ModelUserList (yukarda oluşturduğumuz defaultModel ve object devamı olarak tablonun sütunlarının adları)
        mdl_user_list = new DefaultTableModel();
        Object [] col_user_list = {"ID","Ad Soyad","Kullanıcı Adı","Şifre","Üyelik Tipi"};//colon isimlerini atıcaz GUI de ki tabloya
        mdl_user_list.setColumnIdentifiers(col_user_list);  //sütunları bura attık

        //tabloları oluşturduk sütunlarını şimdi içini dolduralım
        /*Object [] firstRow={"1","Aziz Karagülmez", "krglmz","123","operator"};
        mdl_user_list.addRow(firstRow);  //addRow metodunu kullanarak eklemiş olduk */

        //yukarda manuel olarak gösterik veritabanından çekerekte ekliyebiliyoruz
        for (User obj : User.getList()){
            Object [] row =new  Object[col_user_list.length];  //sütunlarla aynı olması için direk öyle dedik biz veritabanındakileri çekicez
            row[0] = obj.getId();
            row[1] = obj.getName();
            row[2] = obj.getUname();
            row[3] = obj.getPass();
            row[4] = obj.getType();
            mdl_user_list.addRow(row);
        }
        tbl_user_list.setModel(mdl_user_list);  //attığımız sütunları tablea aktardık
        tbl_user_list.getTableHeader().setReorderingAllowed(false);   //burda sütunların kaymasını oynamasını engelledik


       //Butona basınca ekleme işlemi yapma
        btn_user_add.addActionListener(e -> {   //lamda şeklinde yaptık
            if (fld_user_name.getText().length() == 0 || fld_user_uname.getText().length()==0 || fld_user_pass.getText().length()==0) {  //ekliceğimiz değerler sıfırsa ekleme işlemi yapalım yoksa hata alırız
               Helper.showMsg("fill");
            }else {
               String name= fld_user_name.getText();
               String uname=fld_user_uname.getText();
               String pass= fld_user_pass.getText();
               String type=cmb_user_type.getSelectedItem().toString(); //Comboboxı bu şekilde okuyabiliyoruz.
                if (User.add(name,uname,pass,type)){
                    Helper.showMsg("done");
                }else {
                    Helper.showMsg("error");   //burlarda Helper daki oluşturduğumuz metodları kullanıyoruz kod okunurluğu için
                }
            }
        });
    }

    public static void main(String [] args){
        Helper.setlayout();  //UI burda çağırabildik kolay ve okunur bir kod şeklinde, try catch iekilde yazarsak GUI de çalıştırabiliriz

        Operator op = new Operator();
        op.setId(1);
        op.setName("Aziz Karagülmez");
        op.setPass("1234");
        op.setType("Operator");
        op.setUname("krglmz");
        OperatorGUI opGUI = new OperatorGUI(op);


    }
}
