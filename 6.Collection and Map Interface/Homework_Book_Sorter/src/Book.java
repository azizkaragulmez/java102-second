public class Book implements Comparable<Book> {
    String name;
    int SayfaSayisi;
    String author;
    int YayinT;

    public Book(String name, int SayfaSayisi, String author, int YayinT){
        this.name=name;
        this.SayfaSayisi=SayfaSayisi;
        this.author=author;
        this.YayinT=YayinT;
    }

    public int compareTo(Book other) {
        // current (this) nesnesinin name alanını, diğer (other) nesnenin name alanı ile karşılaştır.
        // String.compareTo() metodu, iki String'i karşılaştırır ve aşağıdaki değerleri döner:
        // - Negatif bir değer: Eğer this.name, other.name'den önce geliyorsa.
        // - Sıfır: Eğer this.name ve other.name eşitse.
        // - Pozitif bir değer: Eğer this.name, other.name'den sonra geliyorsa.
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSayfaSayisi() {
        return SayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        SayfaSayisi = sayfaSayisi;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYayinT() {
        return YayinT;
    }

    public void setYayinT(int yayinT) {
        YayinT = yayinT;
    }

    @Override

}
