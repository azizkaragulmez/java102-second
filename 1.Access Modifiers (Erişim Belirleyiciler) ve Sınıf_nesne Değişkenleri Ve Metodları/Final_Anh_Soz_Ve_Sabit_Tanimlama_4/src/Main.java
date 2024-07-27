public class Main {
    public static void main(String[] args)
    {

        Daire d=new Daire(10);
        // d.pi=100;    pi değişemez aslında mantıken ama burda değiştirebiliyoruz işte burda final anh. kelimesini öğreneceğiz.
        // d.pi=30;  yazarsakta hata alıcaz.
        d.CalcArea();
    }
}