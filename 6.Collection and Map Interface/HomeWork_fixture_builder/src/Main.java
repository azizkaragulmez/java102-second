import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayList<String> teams = new ArrayList<>();

        System.out.print("Kaç Takım Gireceksiniz ?-->");
        int input=scanner.nextInt();
        while (true)
        {
            if (2>input){
                System.out.print("2 den takım giremezsiniz, Kaç Takım Gireceksiniz?-->");
                input=scanner.nextInt();
            }
            else {
                break;
            }
        }


        for (int i=1; i<=input;i++){
            System.out.println(i+". takım ismini giriniz :");
            String teamName=scanner.next();
             teams.add(teamName);
        }

        System.out.println("---------------------------------");

        if (teams.size()%2 !=0){
            teams.add("Bay");
        }

        int RoundNum=(teams.size()-1)*2;
        int MatchRound= teams.size()/2;


        ArrayList<String> tempTeams = new ArrayList<>(teams);
        //Bu, teams listesinin içeriğini kopyalar ve tempTeams adındaki yeni listeye atar.

        for (int round=1; round<=RoundNum/2; round++){
            System.out.println("#################################");
            System.out.println("ROUND"+round);
            System.out.println("#################################");

            for (int y=0; y<MatchRound;y++){
                String home= tempTeams.get(y);
                // 'tempTeams' listesinin son elemanından başlayarak 'i' kadar geriye gidip 'away' olarak al
                String away=tempTeams.get(tempTeams.size()-y-1);
                // 'home' ve 'away' takımlarını 'vs' ile yan yana yazdır
                System.out.printf("%-15s %-4s %-15s\n", home, "vs", away);
                //%-15s ifadesi, home değişkeninin sol tarafta hizalanarak 15 karakterlik bir alan kaplamasını sağlar. Yani, metin 15 karakterlik bir alanda yazdırılır.
                //%-4s ifadesi, "vs" metnini 4 karakterlik bir alanda hizalar.
                //%-15s ifadesi ise away değişkenini 15 karakterlik bir alanda yazdırır.
            }

            Collections.rotate(tempTeams.subList(1, tempTeams.size()), 1);
             /*Collections.rotate metodu, belirtilen listeyi döndürür (kaydırır).
             İkinci parametre 1 olduğu için, alt listeyi sağa doğru 1 pozisyon döndürür. Bu, listenin son elemanını başa alır.
             Yani, ["Takım B", "Takım C", "Takım D"] listesini 1 pozisyon döndürdüğümüzde sonuç ["Takım D", "Takım B", "Takım C"] olacaktır.
             subList metodu, belirtilen başlangıç ve bitiş indeksleri arasında yeni bir alt liste oluşturur.
             1 başlangıç indeksi, yani alt liste tempTeams listesinin 1. indeksinden (ikinci elemanı) başlar.
             tempTeams.size() ise alt listenin sonunu belirtir. Yani, bu ifade tempTeams listesinin tamamını kapsar, ama 1. indeksten başlayarak.
             Örneğin, eğer tempTeams listesi ["Takım A", "Takım B", "Takım C", "Takım D"] ise, subList(1, tempTeams.size()) ifadesi ["Takım B", "Takım C", "Takım D"] alt listesini oluşturur.*/
            System.out.println();
        }

        for (int round = RoundNum/2 + 1; round <= RoundNum; round++){

            System.out.println("#################################");
            System.out.println("Round " + round);
            System.out.println("#################################");

            for (int i = 0; i < MatchRound; i++){
                String home = tempTeams.get(tempTeams.size() - i - 1);
                String away = tempTeams.get(i);
                System.out.printf("%-15s %-4s %-15s\n",home, "vs", away);
            }

            Collections.rotate(tempTeams.subList(1, tempTeams.size()), 1);
            System.out.println();
        }


    }
}