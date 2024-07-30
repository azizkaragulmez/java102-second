public class Book {
    private String name;
    private int pageNumber;

    public Book (String name,int pageNumber)
    {
        this.name=name;
        this.pageNumber=pageNumber;
    }

    public int getPageNumber()
    {
        if (pageNumber<0)   //ifimizi constrocter (kurucu metodu) da yazabilirdik o yazılımcıya kalmış ben bunu tercih ediyorum.
        {
            this.pageNumber=0;
        }
       return this.pageNumber;
    }

    public void setPageNumber(int pageNumber)
    {
        if (pageNumber<0)   //if settede koyduk çünkü güncelleme yaparken - değer girilmesin diye
        {
           // this.pageNumber=0;
            System.out.println("- bir değer ile değiştiremezisiniz");  //böyle açıklama da ekleyebiliriz.
        }
        this.pageNumber=pageNumber;

    }

    public String getName()
    {
       return this.name;
    }
    public void setName(String name)
    {
        this.name=name;
    }


}
