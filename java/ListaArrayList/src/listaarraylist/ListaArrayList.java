package listaarraylist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class ListaArrayList {
    public static void main(String[] args) {
       ArrayList<String> tablica = new ArrayList<>();
       Scanner mrp = new Scanner(System.in);
       String wybor1,wybor2,zmienna1,zmienna2;
       tablica.add("Piotrek");
       tablica.add("Rafał");
       tablica.add("Martin");
       while(true){        
        System.out.println("Chcesz coś dodać ?(tak,nie)");
        wybor2 = mrp.nextLine();
        if(wybor2.matches("tak")){
           System.out.println("Wpisz frazę (jakikolwiek string).");
           zmienna1 = mrp.nextLine();
           tablica.add(zmienna1);
        }
        System.out.println("Chcesz coś usunąć ?(tak,nie)");
        wybor2 = mrp.nextLine();
        if(wybor2.matches("tak")){
           System.out.println("Wpisz frazę (jakikolwiek string).");
           zmienna2 = mrp.nextLine();
           tablica.remove(zmienna2);
        }
        System.out.println("Stan tablicy na teraz :)");
        Iterator<String>iter=tablica.iterator();
        while(iter.hasNext()){
           System.out.println(iter.next());
        }
        System.out.println("Chcesz wyjść ?(tak,nie)");
        wybor1 = mrp.nextLine();
        if(wybor1.matches("tak")){
            break;
        }
       }
    }
}
