public class Student {
    int no;
    String name;
    int note;


    public Student(int no, String name, int note){
        this.no=no;
        this.name=name;
        this.note=note;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        if (no<=0)
        {
            System.out.println("Yanlış No girdiniz");
        }
        else { this.no = no;}

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        if (no<=0)
        {
            System.out.println("Yanlış Not girdiniz");
        }
        else { this.note = note;}


    }



}
