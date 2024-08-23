public class Main {
    public static void main(String[] args)
    //Boxing
    //Unboxing
    {
        //AutoBoxing
        int a=10;
        Integer b=a;    //java5 ile gelen bir özellik önceden --> Integer.valueOf(a);

        //Boxing
        Integer c=Integer.valueOf(a);  //yukardaki ile aynı işlem ama artık java senin yerine yapıyorum diyor.
        System.out.println(c);


        //AutoUnboxing
        int d=c;  //Integer olanı gene int yapımış olduk türünü  //c.intValue();


        //Unboxing
        int i=c.intValue();
        System.out.println(d);

    }
}