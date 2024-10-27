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
    public int compareTo(Book other) {
        return this.name.compareTo(other.name);
    }
}
