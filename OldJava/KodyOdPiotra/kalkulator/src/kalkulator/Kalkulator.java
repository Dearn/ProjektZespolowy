/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kalkulator;
import java.util.Scanner;
/**
 *
 * @author Samael
 */
public class Kalkulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true){
        Scanner mrp = new Scanner(System.in);
        double l1,wynik;
        int l;
        double tablica[];
        String dzialanie,wybor;
        System.out.println("Chcesz wyjść ?(tak,nie)");
        wybor = mrp.nextLine();
        if(wybor.matches("tak")){
            break;
        }
        System.out.println("Jakie działanie chcesz wykonać (suma,roznica,dzielenie,mnozenie) : ");
        dzialanie = mrp.nextLine();
        
        System.out.println("Podaj pierwszą liczbę : ");
        l1 = mrp.nextDouble();
        System.out.println("Ile liczb jeszcze będziesz potrzebował do obliczeń ? : ");
        l = mrp.nextInt();
        tablica = new double[l+1];
        for(int i=1;i<l+1;i++){
        System.out.println("Podaj kolejną liczbę : ");
        tablica[i] = mrp.nextDouble();
        }
        Dzialania start=new Dzialania();
        switch(dzialanie){
            case "suma" :
             wynik=start.Dodawanie(l, l1, tablica);
             System.out.println("Wynik wynosi : " + wynik); 
                break;
            case "roznica" :
              wynik=start.Różnica( l1, tablica); 
                System.out.println("Wynik wynosi : " + wynik); 
                break;
            case "dzielenie" : 
                wynik=start.Dzielenie( l1, tablica);
                System.out.println("Wynik wynosi : " + wynik); 
                break;
            case "mnozenie" :
              wynik=start.Mnożenie( l1, tablica);
                System.out.println("Wynik wynosi : " + wynik); 
                break;
            default :
                System.out.println("Podałeś nieistniejące działanie !");
                break;
        }
        }
    }
}
