public interface IDatabase <T> {  //burda öğrenci gelmiş olursa o öğrencinin insert delete update değerleri sağlanmış  oluyor.

    public boolean insert(T data);
    public boolean delete(T data);
    public boolean update(T data);
    public T select();    //bunda geri bir değer döndürücemiz için türü belirleyemyiz (void)

}
