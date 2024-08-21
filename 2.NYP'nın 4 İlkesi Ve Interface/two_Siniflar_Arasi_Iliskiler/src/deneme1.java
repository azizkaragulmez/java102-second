public class deneme1 {
    private String courseName;
    private deneme2 Deneme2;  //kursun eğitmeninin bilgilerinin saklandığı



    public deneme1 (String courseName, deneme2 Deneme2){
        this.courseName=courseName;
        this.Deneme2=Deneme2;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public deneme2 getDeneme2() {
        return Deneme2;
    }

    public void setDeneme2(deneme2 deneme2) {
        Deneme2 = deneme2;
    }
}
