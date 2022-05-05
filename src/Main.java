import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException, FileNotFoundException {


       String islem1= "_________________BACKGOMMAN CHALLENGE HOSGELDINIZ_________________\n"
                +"..........1-OYUNA BASLA.......\n"
                +"..........2-CIKIS.......\n";
       String islem2="_________________BACKGOMMAN CHALLENGE HOSGELDINIZ_________________\n"
                +"..........1-OYUNA BASLA........\n"
                +"..........2-KAYITLI OYUN.......\n"
                +"..........3-CIKIS........\n";

       System.out.println(islem1);
        System.out.print("Islem Giriniz:");
        Scanner scanner=new Scanner(System.in);
        String islem=scanner.nextLine();
       while(true){
           if (islem.equals("2")) {
               System.out.println("Uygulamadan Cikiliyor");
               break;
           }
           else if(islem.equals("1")){

               Operations operations=new Operations();
               operations.Oyun();
               Thread.sleep(3000);
               operations.BaslangicZari();

           break;}
       }




    }
}
