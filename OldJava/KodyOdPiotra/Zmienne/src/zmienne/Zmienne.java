package zmienne;

class Wyrazenie {
    Wyrazenie tab[];
    public double oblicz();
}

class Dodawanie extends Wyrazenie {
    private final Wyrazenie wyr1;
    private final Wyrazenie wyr2;
    
    public Dodawanie(Wyrazenie w1, Wyrazenie w2) {
        wyr1 = w1;
        wyr2 = w2;
    }
    
    @Override
    public double oblicz() {
        return wyr1.oblicz() + wyr2.oblicz();
    }    
}

class Zmienna extends Wyrazenie{
    String nazwa;
    Liczba wart;
    //boolean test;
    
    public Zmienna(String n,Liczba w){
        nazwa = n;
        wart = w;
       /* Srodowisko start=new Srodowisko();
        Zmienna o = new Zmienna(n,w);
        start.Dodaj(o);*/
    }
    
    public Zmienna(String n){
        nazwa = n;
    }
    
    @Override
    public double oblicz() {
        return Liczba.wart;
    }
}

class Liczba{
    protected static double wart;
    
    public Liczba(double w) {
        wart = w;
    }

    public double oblicz() {
        return wart;
    }    
}

public class Zmienne {
    public static void main(String[] args) {
        Wyrazenie tab[] = {new Zmienna("x", new Liczba(12)),
        new Zmienna("y", new Liczba(14)), new Dodawanie(new Zmienna("x"),new Zmienna("y"))};
        
        Srodowisko start=new Srodowisko();
        start.Wyciagnij();
        /*Wyrazenie tab2[] = {new Zmienna("x", new Liczba(12)),
        new Zmienna("y", new Liczba(14)), new Dodawanie(new Zmienna("z"),new Zmienna("y"))};
        
        Program program1 = new Program(tab);
        program1.obliczWszystkie();
        //Powinno wypisać 12, 14 i 26.*/

        /*Program program2 = new Program(tab2);
        program2.obliczWszystkie();
        //Powinno zwrócić wyjątek*/
    }  
}
