public enum Day {

    PAZARTESI(1),
    SALI(2),
    CARSAMBA(3),
    PERSEMBE(4),
    CUMA(5),
    CUMARTESI(6),
    PAZAR(7);
    private int day;
    private  Day (int day){    //constrocter private olup olmaması önemli değil
        this.day=day;
    }

    public int getDay(){
        return this.day;
    }


}
