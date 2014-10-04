package zmienne;

import java.util.ArrayList;
import java.util.Iterator;

public class Srodowisko {
    ArrayList<Zmienna> tablica=new ArrayList<>();
    public void Dodaj(Zmienna o){
     tablica.add(o);
    }
    Iterator<Zmienna>iter=tablica.iterator();
    public void Wyciagnij(){
        while(iter.hasNext()){
            Zmienna elem=iter.next();
            System.out.println(elem.wart);
        }
    }
}
