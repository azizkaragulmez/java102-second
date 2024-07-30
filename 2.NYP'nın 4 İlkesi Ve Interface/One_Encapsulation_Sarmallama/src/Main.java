public class Main {
    public static void main(String[] args)
    {
        Book k1= new Book("Ali Tatilde",100);   //böyle nesne oluşturuyoruz.(biliyoruz zaten)
        Book k2 =new Book("Aziz Mühendis Oluyor",222);  //eksi girdik hata almadık almayabiliriz program engellemiyor bizi

        //System.out.println(k2.pageNumber);  //bir kitabın sayfa sayısı eksi olamaz mantık hatası. Gidip get set uygulayalım.
        System.out.println(k2.getPageNumber());
        k2.setPageNumber(300);
        k2.setPageNumber(-2);
        System.out.println(k2.getPageNumber()); //ne yaptık set ettik değeri değiştirdik.


        System.out.println(k2.getName());
        k2.setName("Computer Engineer");
        System.out.println(k2.getName());   //name de yanlış değer girmeyiz yani int değer ama Jargona uymamız gerekmektedir.

        


    }
}