package polimorfizm;

import java.util.ArrayList;
import java.util.Collections;


class Program {
    ArrayList<Wyrazenie> tab = new ArrayList<>();
    
    public Program(Wyrazenie[] t){
        Collections.addAll(tab, t);
    }
    
    public void obliczWszystkie(){
        ArrayList<Double> wynik = new ArrayList<>();
        
        try{
            for(Wyrazenie i : tab)
                wynik.add(i.oblicz());
            for(Double i : wynik)
                System.out.println(i);
        }
        catch(RuntimeException exc){
            System.out.println("Nie wszystkie zmienne zostały zdefiniowane");
        }
    }
}
