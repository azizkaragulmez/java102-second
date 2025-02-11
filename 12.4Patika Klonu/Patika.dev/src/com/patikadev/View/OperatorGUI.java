package com.patikadev.View;

import com.patikadev.Helper.*;
import com.patikadev.Model.Course;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Patika;
import com.patikadev.Model.User;


import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JTextField fld_sh_user_name;
    private JTextField fld_sh_user_uname;
    private JComboBox cmb_sh_user_type;
    private JButton btn_user_sh;
    private JPanel pnl_patika_list;
    private JScrollPane scrl_patika_list;
    private JTable tbl_patika_list;
    private JTextField fld_patika_name;
    private JButton btn_patika_add;
    private JPanel pnl_user_top;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField fld_course_name;
    private JTextField fld_course_lang;
    private JComboBox cmb_course_patika;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;


    private DefaultTableModel mdl_course_list; //bunu da course için model oluşturduk tabloya atmak için
    private Object[] row_course_list;  //course bölümü için bir obje oluşturduk

    private JPopupMenu patikaMenu;  //patika bölümünde sağ tık yapınca açılan bir menü için manuel olarak oluşturduk


    private Object[] row_patika_List;   //buna benim bir rowlarımı temsileden Objelerimiz (Patika bölümü için bu da) (gene biz manuel oluşturduk.
    //Patika için bir model oluşturuyoruz verilerimiz atmak için öğrenmiştik
    private DefaultTableModel mdl_patika_list;   //bunu kendimiz oluşturuyoruz patika bölümümüz için, kullanıcılar için oluşturduğumuz gibi


    //Altakileri veri tabanında ki verileri GUI ye aktarmak için kullanıcaz
    private DefaultTableModel mdl_user_list; /*DefaultTableModel: Bu, Swing'in JTable bileşeniyle verileri yönetmek için kullanılan
                                            bir model sınıfıdır. JTable'de gösterilen veriler, genellikle bir model aracılığıyla
                                            yönetilir. DefaultTableModel, JTable için verilerin saklanmasını, düzenlenmesini ve
                                            güncellenmesini sağlayan varsayılan bir sınıftır.*/
    private Object[] row_user_list;   //veritabanı işlemleri ne atarsa Object türünde atıcam demek
    //Object[]: Bu, Java'daki dizi (array) yapısının bir örneğidir. Burada Object[], JTable'e eklenecek bir satırdaki verileri
    // tutmak için kullanılır. Object tipi, herhangi bir veri türünü tutabilen bir türdür.


    private final Operator operator;   //bu ekranı sadece operator işlemi için kullanıcağımız için oluşturuduk

    public OperatorGUI(Operator operator) {  //Bura da operator atmadan buranın çalışmayacağını belirtik
        this.operator = operator;             //Bura da constroctorını oluşturuduk


        add(wrapper);            //JPanel i eklememiz gerekli
        setSize(1000, 500);  //Büyüklüğü
        setLocationRelativeTo(null);      //ortada açılması
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //çarpı işlemi ile ilgiliydi
        setTitle(Config.PROJECT_TİTLE);   //Config sınıfı yaptık direk çağırdık direk ordan değiştirerek heryerde değiştirebiliriz.
        setVisible(true);  //pencerenin görünür olmasını sağlar
        setResizable(false);  //pencerenin küçülüp büyümesini engeller


        lbl_welcome.setText("Hoşgeldin : " + operator.getName());   //Oluşturduğumuz lable ı Textine operator sınıfının ismini atadık


        //ModelUserList (yukarda oluşturduğumuz defaultModel ve object devamı olarak tablonun sütunlarının adları)
        mdl_user_list = new DefaultTableModel() {    //normalde bunu metot gibi yazmamıştık ama id diğer sütünlardaki değerei tıklıyarak değiştirilebiliyor o yüzden değiştirilmemesi için özellikle id
            public boolean isCellEditable(int row, int column) {
                if (column == 0)  //diğerlerin değişmemesinide ayarlıyabiliriz burda sadece 0.sütun seçildi
                    return false;           //bu 0. sütunun düzenlenebiir olmasını engelliyor ama diğer sütunların düzenlenebilceğini sağlıyor
                return super.isCellEditable(row, column);  //Eğer 0. sütun dışında bir sütun seçildiyse, super.isCellEditable(row, column); çağrılarak üst sınıftaki varsayılan düzenlenebilirlik davranışı korunuyor.
            }
        };
        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};//colon isimlerini atıcaz GUI de ki tabloya
        mdl_user_list.setColumnIdentifiers(col_user_list);  //sütunları bura attık
        row_user_list = new Object[col_user_list.length]; //daha sonra ne kadar ekleniceni sayısını tutuyoruz
        loadUserModel();  //burda çağırdık listeledi tabloda bilgilerin hepsini


        //tabloları oluşturduk sütunlarını şimdi içini dolduralım
        /*Object [] firstRow={"1","Aziz Karagülmez", "krglmz","123","operator"};
        mdl_user_list.addRow(firstRow);  //addRow metodunu kullanarak eklemiş olduk */

        //yukarda manuel olarak gösterik veritabanından çekerekte ekliyebiliyoruz
       /* for (User obj : User.getList()) { Bunu burda iptal ettik çünkü  kod düzeni için metoda entegre etik yukarda loadUserModel(); e ekledik
            Object[] row = new Object[col_user_list.length];  //sütunlarla aynı olması için direk öyle dedik biz veritabanındakileri çekicez
            row[0] = obj.getId();
            row[1] = obj.getName();
            row[2] = obj.getUname();
            row[3] = obj.getPass();
            row[4] = obj.getType();
            mdl_user_list.addRow(row);
        }*/
        tbl_user_list.setModel(mdl_user_list);  //attığımız sütunları tablea aktardık
        tbl_user_list.getTableHeader().setReorderingAllowed(false);   //burda sütunların kaymasını oynamasını engelledik

        for (int i = 0; i < col_user_list.length; i++) {    //sütunalrın oynaklığını kapattım (me)
            tbl_user_list.getColumnModel().getColumn(i).setResizable(false); // Sütunun genişliğini değiştirmeyi engelle
            tbl_user_list.getColumnModel().getColumn(i).setPreferredWidth(160); // Sabit genişlik belirle
        }


        //Silme işleminde id yardımıylasiliyorduk ama string değerlerde yazılabiliyor ve bu hataya yol açıyor . Bizde tablodan seçerek tıklıyarak seçmek için model oluşturduk
        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {   //Bu şu demek seçilen değer üzerinde işlem yapmaya yarayan bir bölüm yani listener(dinleyici).(new ListSelectionListener())
            try {            //try catch içine almamızda ki neden seçerek yaptığımız silme işleminde seçili kaldığı için refresh edince hata veriyor
                String select_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();    //Value et bize seçim yapılan konumu verir yani 0 sütun 1 satır gibi
                //tbl_user_list den satırı aldık neere seçildiyse id 0 da olduğu için 0. sütunu aldık ve toString yani object döndürdük
                fld_user_id.setText(select_user_id);
            } catch (Exception exception) {

            }
        });

        //Güncelleme işlemi için, yukarda silme işlemi içinde kullandık bu yöntemi  (veritabanın da güncelleme için)
        tbl_user_list.getModel().addTableModelListener(e -> {    //new TableModelListener(), bu yukarda olduğu gibi bir listenir (dinleyici)
            if (e.getType() == TableModelEvent.UPDATE) {
                int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());  //Integer.parseInt(): Bu metot, bir String değeri int türüne dönüştürür. Yani, alınan user_id'yi String'den int'e çevirir.
                String user_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString();
                String user_uname = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString();
                String user_pass = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString();
                String user_type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 4).toString();
                //yukarda ki değerleri biz aldık tıklıyarak ve bu değerleri Usera gönderiyoruz.
                if (User.update(user_id, user_name, user_uname, user_pass, user_type)) {
                    Helper.showMsg("done");
                }
                loadUserModel();   //Bildiğimiz üzere refresh etmesi için yeniden yüklüyor listeleri değişince
            }
        });

        //##ModelUserList


        //PatikaList
        //PATİKA İÇİN YAZICAMIZ BÖLÜM YUKARDA TBL_USER_LİST İŞİMİZ OLMADIĞI İÇİN ONLARIN ALTINA GEÇTİK
        patikaMenu = new JPopupMenu();  //patikaMenu yukarda tanımladık  //Sağ tıklama menüsünü (JPopupMenu) oluşturur.  //(bu sağa tıklama için yazılan kodlar)
        JMenuItem updateMenu = new JMenuItem("Güncelle");  //"Güncelle" adlı bir menü öğesi oluşturur.
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);          // "Güncelle" öğesini menüye ekler.
        patikaMenu.add(deleteMenu);          // Sağ tıklama ile açılan bir menü (JPopupMenu) oluşturduk ve içine menü öğeleri (JMenuItem) ekledik. (yukardakilerin tamamının açıklaması)


        //GUIleri bağlıyoruz
        updateMenu.addActionListener(new ActionListener() {  //(lambda yapabiliriz diğerlerinde unutmayak diye burda yapmadım)
            @Override
            //addActionListener tıklandığnda dinliyoruz. Burada biz bu sayfadan güncelleme sayfasına geçişi burada yapıyoruz önce biz güncelleme yaptık UpdateGuıde çalıştı burda bağlantısını yapıcaz
            public void actionPerformed(ActionEvent e) {
                int select_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());     //Seçili satırın ilk sütunundaki (id) değeri alıyoruz. // tbl_patika_list.getSelectedRow() → Kullanıcının seçtiği satırı alır. //tbl_patika_list.getValueAt(row, 0) → Seçili satırın ilk sütunundaki (id) değeri alır.//.toString() → Metin (String) formatına çevirir.//Integer.parseInt(...) → Tam sayı (int) formatına çevirir.
                UpdatePatikaGUI updateGUI = new UpdatePatikaGUI(Patika.getFetch(select_id)); //Patika.getFetch(select_id) → Seçilen ID’ye göre veritabanından ilgili "patika" kaydını çeker.  new UpdatePatikaGUI(...) → Güncelleme penceresini oluşturur ve açar.
                updateGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {   //burda da dinliyoruz pencere kapanınca yapılacak işlemi giricez, biz kapanınca güncelle diyoruz
                        loadPatikaModel();  //sayfayı güncelliyor veritabanından hemen çekiyor
                        loadPatikaCombo();
                    }
                });
            }
        });

        deleteMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.confirm("sure")) {
                    int select_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
                    if (Patika.delete(select_id)) {
                        Helper.showMsg("done");
                        loadPatikaModel();
                        loadPatikaCombo();   // cursor için oluşturulan otomatik güncellensin diye
                    } else {
                        Helper.showMsg("error");
                    }
                }
            }
        });

        mdl_patika_list = new DefaultTableModel();   //sütunları oluşturmak için model oluşturduk
        Object[] col_patika_list = {"ID", "Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);   //tablo başlıklarını atadık
        row_patika_List = new Object[col_patika_list.length];
        loadPatikaModel();
        tbl_patika_list.setModel(mdl_patika_list);   //oluşanı tabela atarak aktarmış oluruz
        tbl_patika_list.setComponentPopupMenu(patikaMenu);    //Yukarda oluşturduğumuz menuyü setComponenetPopupMenu yardımıyla ekledik
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(75);    //biz yaratmadık ama bunlarında bir modeli olduğunu unutma

        tbl_patika_list.addMouseListener(new MouseAdapter() {   //PopMenu için seçilenin sol tıkta sil ve güncelle çıkınca o seçilen satırın mavi olup hangisini seçtiğimizi bilmek istiyoruz
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();     //Point x ve y tutan kordinatları tutuyor, e.getPointle kordinat değerlerini atıyoruz
                int selected_row = tbl_patika_list.rowAtPoint(point);    //bizim bir metodumuz rowAtPointimiz var bunun içine pointi atarsak hangi row olduğunu bize söylüyor
                tbl_patika_list.setRowSelectionInterval(selected_row, selected_row);
            }
        });
        //##PatikaList


        //Butona basınca ekleme işlemi yapma
        btn_user_add.addActionListener(e -> {   //lamda şeklinde yaptık
            if (fld_user_name.getText().length() == 0 || fld_user_uname.getText().length() == 0 || fld_user_pass.getText().length() == 0) {  //ekliceğimiz değerler sıfırsa ekleme işlemi yapalım yoksa hata alırız
                Helper.showMsg("fill");
            } else {
                String name = fld_user_name.getText();
                String uname = fld_user_uname.getText();
                String pass = fld_user_pass.getText();
                String type = cmb_user_type.getSelectedItem().toString(); //Comboboxı bu şekilde okuyabiliyoruz.
                if (User.add(name, uname, pass, type)) {
                    Helper.showMsg("done");
                    loadUserModel();  //Burda da çağırdık çünkü eklediğimizde o an liste de gözüksün liste güncellensin diye

                    fld_user_name.setText(null); //Burada da ekleme işlemi başarılı ise textfieldların içini boşaltıyoruz.
                    fld_user_uname.setText(null);
                    fld_user_pass.setText(null);
                }
            }
        });


        //CourseList     ( burda modelimizi oluşturuyoruz yukarda user ve patika modelleri var)
        mdl_course_list = new DefaultTableModel();
        Object[] col_courseList = {"ID", "Ders Adı", "Proglamlama Dili", "Patika", "Eğitmen"};   //burda tablo da bulunan sütunların isimlerini belirtiyoruz
        mdl_course_list.setColumnIdentifiers(col_courseList);               //Tüm sütunları sıfırlayıp yenilerini ekler. Baştan tanımlamak ->addColumn() Var olan sütunlara yeni sütun ekler Sonradan sütun eklemek
        row_course_list = new Object[col_courseList.length];               //row=dizi
        loadCourseList(); //burda veritabanı bağlıyalım
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        loadPatikaCombo();

        //##CoureseList


        //Silme işlemleri işlemlerinin yapıldığı buton işlemleri
        btn_user_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_id)) {   //Butona basılınca kullanıcı id yazdığımız yer boş ise bir mesaj döndürmesini istiyoruz
                Helper.showMsg("fill");
            } else {
                if (Helper.confirm("sure")) {   //eminmisin diye sorması için if oluşturduk
                    int user_id = Integer.parseInt(fld_user_id.getText());  //Burda bir integer değer dönmesi gerektiği için wrapper sınıflardaki taktiği kullanarak dönüştürdük çünkü textfield String bir değer
                    if (User.delete(user_id)) {
                        Helper.showMsg("done");
                        loadUserModel();      //sildikten sonra tabloyu o an güncellemesi için
                    } else {
                        Helper.showMsg("error");
                    }
                }
            }
        });


        //Arama yapma işlemi butonu
        btn_user_sh.addActionListener(e -> {
            String name = fld_sh_user_name.getText();
            String uname = fld_sh_user_uname.getText();
            String type = cmb_sh_user_type.getSelectedItem().toString();   //combobox taki değeri böyle okuyup alabiliyoruz
            String query = User.searchQuery(name, uname, type);           //Bunu searchquery göndererek bir query oluşturmuş olduk
            loadUserModel(User.searchUserList(query));          //oluşan queryi biz de searchUserListe atmış olduk
        });


        //Çıkış butonu işlemi
        btn_logout.addActionListener(e -> {
            dispose();
        });


        //Patika bölümünde ekle butonu
        btn_patika_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_patika_name)) {
                Helper.showMsg("fill");
            } else {
                if (Patika.add(fld_patika_name.getText())) {
                    Helper.showMsg("done");
                    loadPatikaModel();
                    loadPatikaCombo(); //bunu cursorun combocı için ekledik otomatik program kapanmasında orda da görünsün diye
                    fld_patika_name.setText(null);
                } else {
                    Helper.showMsg("error");
                }

            }
        });


    }

    private void loadCourseList() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();   //JTable'in modelini alır ve üzerinde işlem yapabilmek için DefaultTableModel türüne dönüştürür.
        clearModel.setRowCount(0);                      // Bu metot, tablodaki satır sayısını belirler. 0 olarak ayarlandığında, tablodaki tüm satırlar silinir ve tablo boş olur.
        int i = 0;
        for (Course obj : Course.getList()) {
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPatika().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }


    //Kullanıcılar için oluşturduğum şeyi bu kez patika için oluşutruyoruz
    private void loadPatikaModel() {  //bu metod tabloyu temizleyip geri ona aktarma işlemi  yarıyor diyebiliriz
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();   //tbl_patika_list → Tablonun modelini alıyoruz.DefaultTableModel, JTable'ın içindeki verileri yöneten modeldir.clearModel, bu tablo modeline referans olur.
        clearModel.setRowCount(0);  //temizle
        int i = 0;
        for (Patika obj : Patika.getlist()) {
            i = 0;
            row_patika_List[i++] = obj.getId();
            row_patika_List[i++] = obj.getName();
            mdl_patika_list.addRow(row_patika_List);
        }                                                       //Tabloyu (tbl_patika_list) temizler.
        //Güncel Patika listesini (Patika.getList()) alır.
        //Yeni verileri tabloya ekler.
//🔥 Sonuç: loadPatikaModel() her çağrıldığında, tablo güncellenmiş verileri gösterir!

    }

    //bizim bir loadUserModelimiz vardı aynısından yaptık ve overloading yaptık ve bir geri liste var ise bunu döndürsün diye BUDA ARAMA İŞLEMİ YUKARDAKİ İÇİN
    public void loadUserModel(ArrayList<User> list) {
        //o an güncellemesi için
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();  //bir tane clearModel türünde model üretiyoruz
        clearModel.setRowCount(0);   //bu tablodaki bütün değerleri sıfırlıyor böylelikle aynı şeyleri tekrarlamıyor
        //Yeniden burda eklememizin sebebi butona bastığımız anda listenin o an güncellenmesi için diğer türlü programı yaptığımızda güncellenmez açıp kapayınca gözükür.
        for (User obj : list) {    //gönderidiğimiz listeyi aktarmış oluyor tabloya biz oluşan listeyi gönderdik
            row_user_list[0] = obj.getId();
            row_user_list[1] = obj.getName();
            row_user_list[2] = obj.getUname();
            row_user_list[3] = obj.getPass();
            row_user_list[4] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }


    //Kod tekrarını  önlemek için ekleme işlemi yapınca liste o an güncellenmediği için biz bura ekledik heryerde kullandık kod düzeni sağladık
    public void loadUserModel() {
        //o an güncellemesi için
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();  //bir tane clearModel türünde model üretiyoruz
        clearModel.setRowCount(0);   //bu tablodaki bütün değerleri sıfırlıyor böylelikle aynı şeyleri tekrarlamıyor
        //Yeniden burda eklememizin sebebi butona bastığımız anda listenin o an güncellenmesi için diğer türlü programı yaptığımızda güncellenmez açıp kapayınca gözükür.
        for (User obj : User.getList()) {
            row_user_list[0] = obj.getId();
            row_user_list[1] = obj.getName();
            row_user_list[2] = obj.getUname();
            row_user_list[3] = obj.getPass();
            row_user_list[4] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }


    //bunu coursetta combobox için yazıyoruz
    public void loadPatikaCombo() {
        cmb_course_patika.removeAllItems();   //burda comboboxın içindekilerin hepsini  siliyoruz,tekrarlanmaması için
        for (Patika obj : Patika.getlist()) {   //Patika.getlist(), veritabanından patika listesini döndüren bir metottur, for döngüsü ile tüm patikalar tek tek gezilir.
                cmb_course_patika.addItem(new Item(obj.getId(),obj.getName()));     //cmb_course_patika.addItem(...) → Oluşturulan Item nesnesini ComboBox’a ekler.
                                                                                    //Ama toString() metodu sayesinde, ComboBox’ta sadece name kısmı görünür.
            //burda patikaları otomatik olarak comboboxta görünsün diye oluşturduk. yukarda da ıd var ama ıd göre isimler görünsün istedik sadece
        }
    }


    //cursor bölümü için 

    public static void main(String[] args) {
        Helper.setlayout();  //UI burda çağırabildik kolay ve okunur bir kod şeklinde, try catch iekilde yazarsak GUI de çalıştırabiliriz

        Operator op = new Operator();  //bunlar manuel olarak görelim diye oluşturmuştuk
        op.setId(1);
        op.setName("Aziz Karagülmez");
        op.setPass("1234");
        op.setType("Operator");
        op.setUname("krglmz");
        OperatorGUI opGUI = new OperatorGUI(op);


    }
}
