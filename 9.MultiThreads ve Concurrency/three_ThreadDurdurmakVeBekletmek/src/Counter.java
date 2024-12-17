public class Counter implements Runnable{


    private String name;
    private int id;
    private  boolean isRun=true;
    public Counter(String name, int id){
        this.name=name;
        this.id=id;
    }
    @Override
    public void run() {
        System.out.println(this.name+" Çalıştı");
       // while (isRun){
            for (int i=1; i<=10; i++){   //Manuel olarak bekletmek istediğimizde bu for while içinde olmuyor  forun bitmesini bekliyor
                try {
                    Thread.sleep(1000 * this.id);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(this.name+" "+i);
            }
        //}
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public void stop(){
        this.isRun=false;
    }
}
