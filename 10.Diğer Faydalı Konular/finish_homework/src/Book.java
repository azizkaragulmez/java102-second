public class Book {
    String bookname;
    int numpages;

    String authorname;
    int pubdate;

    public Book ( String bookname, int numpages, String authorname,  int pubdate){
        this.bookname=bookname;
        this.numpages=numpages;
        this.authorname= authorname;
        this.pubdate=pubdate;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getNumpages() {
        return numpages;
    }

    public void setNumpages(int numpages) {
        this.numpages = numpages;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public int getPubdate() {
        return pubdate;
    }

    public void setPubdate(int pubdate) {
        this.pubdate = pubdate;
    }
}
