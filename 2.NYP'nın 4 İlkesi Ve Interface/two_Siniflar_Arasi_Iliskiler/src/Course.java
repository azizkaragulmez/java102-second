public class Course {
    private String courseName;
    private String code;
    private Instructor instructor;  //Bir sınıfa ait değişkenlerden biri bir sınıfı temsil ediyorsa bu sınıf o sınıfı içerir anlamı katar.
                                    //ve buna Composition veya Aggregation denir.

    public Course(String courseName,String code,Instructor instructor)
    {
        this.courseName=courseName;
        this.code=code;
        this.instructor=instructor;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getCourseName(){
        return this.courseName;
    }
    public void setCourseName(String courseName)
    {
        this.courseName=courseName;
    }


    public String getCode(){
        return this.getCode();
    }
    public void setCode(){
        this.code=code;
    }


    //Course uses a Student (Course sınıfı Student sınıfına bağlı)
    public double calcAvarage (Student[] students){
        Student  st4 = new  Student("","","","",123);
        double avarage =0.0;
        for (int i = 0; i < students.length; i++) {
            avarage += students[i].getNote();
        }
        return avarage/students.length;
    }
}
