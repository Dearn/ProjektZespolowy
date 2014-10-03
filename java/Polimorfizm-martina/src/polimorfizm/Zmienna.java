package polimorfizm;

import java.io.IOException;
import java.util.ArrayList;


class Zmienna extends Wyrazenie {
    private String nazwa;
    private Wyrazenie wyraz;
    private boolean inicjowana;
    private static Srodowisko srod = new Srodowisko();
    
    public Zmienna(){
        nazwa = "Brak";
        inicjowana = false;
    }
    
    public Zmienna(String n, Wyrazenie w){
        nazwa = n;
        wyraz = w;
        inicjowana = true;
        srod.add(this);
    }
    
    public Zmienna(String n){
        nazwa = n;
        inicjowana = false;
    }
    
    @Override
    public double oblicz() throws RuntimeException{
        double wynik = 0.0;
        try{
            if(inicjowana)
                wynik = wyraz.oblicz();
            else
                wynik = srod.get(nazwa).oblicz();
        }
        catch(MojWyjatek exc){
            throw new RuntimeException();
        }
        return wynik;
    }
    
    public String nazwa(){
        return nazwa;
    }
}


class Srodowisko{
    ArrayList <Zmienna> struktura;
    
    {
        struktura = new ArrayList<>();
        System.out.println("Srodowisko utworzone.");
    }
    
    public void add(Zmienna z){
        struktura.add(z);
    }
    
    public Zmienna get(String n) throws MojWyjatek{
        Zmienna m = new Zmienna();
        boolean znaleziono = false;
        for(Zmienna z : struktura)
            if(n.matches(z.nazwa())){
                    m = z;
                    znaleziono = true;
            }
        if(!znaleziono)
            throw new MojWyjatek("Nie znaleziono definicji zmiennej");
        return m;
    }
}


class MojWyjatek extends Exception {
    public MojWyjatek(String s){
        super(s);
    }
}




