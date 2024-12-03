import java.io.Serializable;

public class Car implements Serializable {

    //burayı implements etmeseydik Seralizable demezsek, main kısmındaki işlemleri yapmamıza izin vermicekti java

    private String Brand;
    private String Model;

    public Car (String Brand,String Model){
       this.Brand=Brand;
       this.Model=Model;
    }

    public String getBrand() {
        return Brand;
    }
    public void setBrand(String Brand){
       this.Brand=Brand;
    }


    public String getModel() {
        return Model;
    }
    public void setModel(String Model){
        this.Model=Model;
    }
}
