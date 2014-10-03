/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package polimorfizm;

import java.io.IOException;

interface Figura {
    double oblicz();
}



class Trojkat implements Figura{
    private final double atr1, atr2;
    
    public Trojkat(double w1, double w2){
        atr1 = w1;
        atr2 = w2;
    }
    
    @Override
    public double oblicz(){
        return atr1 * atr2 / 2;
    }
}

class Prostokat implements Figura{
    private final double atr1, atr2;
    
    public Prostokat(double w1, double w2){
        atr1 = w1;
        atr2 = w2;
    }
    
    @Override
    public double oblicz(){
        return atr1 * atr2;
    }
}

class Kwadrat implements Figura{
    private final double atr1;
    
    public Kwadrat(double w1){
        atr1 = w1;
    }
    
    @Override
    public double oblicz(){
        return Math.pow(atr1, 2);
    }
}

class Kolo implements Figura{
    private final double atr1;
    
    public Kolo(double w1){
        atr1 = w1;
    }
    
    @Override
    public double oblicz(){
        return Math.pow(atr1, 2) * Math.PI; 
    }
}

class Pole extends Wyrazenie{
    private final Figura atr;
    
    public Pole(Figura w1){
        atr = w1;
    }
    
    @Override
    public double oblicz(){
        return atr.oblicz();
    }
}

abstract class Wyrazenie  {
    abstract public double oblicz();
}

//(1 + 2) + 3 * 4
//3 + 4
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

class Odejmowanie extends Wyrazenie {
    private final Wyrazenie wyr1;
    private final Wyrazenie wyr2;
    
    public Odejmowanie(Wyrazenie w1, Wyrazenie w2) {
        wyr1 = w1;
        wyr2 = w2;
    }
    
    @Override
    public double oblicz() {
        return wyr1.oblicz() - wyr2.oblicz();
    }    
}

class Mnozenie extends Wyrazenie {
    private final Wyrazenie wyr1;
    private final Wyrazenie wyr2;
    
    public Mnozenie(Wyrazenie w1, Wyrazenie w2) {
        wyr1 = w1;
        wyr2 = w2;
    }
    
    @Override
    public double oblicz() {
        return wyr1.oblicz() * wyr2.oblicz();
    }    
}

class Liczba extends Wyrazenie {
    private final double wart;
    
    public Liczba(double w) {
        wart = w;
    }

    @Override
    public double oblicz() {
        return wart;
    }    
}

class Dzielenie extends Wyrazenie {
    final Wyrazenie wyr1;
    final Wyrazenie wyr2;
    
    public Dzielenie(Wyrazenie w1, Wyrazenie w2) {
        wyr1 = w1;
        wyr2 = w2;
    }

    @Override
    public double oblicz() {
        return wyr1.oblicz() / wyr2.oblicz();
    }
}

/**
 *
 * @author Andrzej Grosser <agrosser@icis.pcz.pl>
 */
public class Polimorfizm {

    void f(int x) throws IOException, ArithmeticException {
try {
   if(x > 0)
       throw new IOException();
  else
      throw new ArithmeticException();
}
catch(Exception e) {}
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*//Liczba 0.0
        //0.0
        Wyrazenie w0 = new Liczba(0.0);
        // Dodawanie |- Liczba 12.0
        //          |- Liczba 10.0
        // 12.0 + 10.0
        Wyrazenie w1 = new Dodawanie(new Liczba(12.0), new Liczba(10.0));
        // Dodawanie |---- Mnozenie |-- Liczba 10.0
        //           |              |-- Odejmowanie |- Liczba 4.0
        //           |                              |- Liczba 3.0
        //           |---- Liczba 11.0
        // 10.0 * (4.0 - 3.0) + 11.0
        Wyrazenie w2 = new Dodawanie(
                            new Mnozenie(
                                    new Liczba(10.0), 
                                    new Odejmowanie (new Liczba(4.0), new Liczba(3.0))),
                            new Liczba(11.0));
        Wyrazenie w3 = new Dzielenie(new Liczba(10.0), new Liczba(5.0));
        System.out.println(w0.oblicz());
        System.out.println(w1.oblicz());
        System.out.println(w2.oblicz());
        System.out.println(w3.oblicz());
        System.out.println("Obliczenia do zadania");
        System.out.println((new Pole(new Trojkat(2,4))).oblicz()); // Wynik - 4.0
        System.out.println((new Pole(new Prostokat(2,4))).oblicz());//Wynik - 8.0
        System.out.println((new Pole(new Kwadrat(2.0))).oblicz());//Wynik - 4.0
        System.out.println((new Pole(new Kolo(1.0))).oblicz()); //Wynik ~ 3.14
        //Nieco bardziej skomplikowane wyrażenie:
        System.out.println((new Dodawanie
                                ((new Pole(new Kwadrat(3.0))), 
                                 new Liczba(1.0))).oblicz());//Wynik - 10.0*/
        
        Wyrazenie tab[] = {new Zmienna("x", new Liczba(12)),
        new Zmienna("y", new Liczba(14)), new Dodawanie(new Zmienna("x"),new Zmienna("y"))};

        Wyrazenie tab2[] = {new Zmienna("x", new Liczba(12)),
        new Zmienna("y", new Liczba(14)), new Dodawanie(new Zmienna("z"),new Zmienna("y"))};

        Program program1 = new Program(tab);
        program1.obliczWszystkie();
        //Powinno wypisać 12, 14 i 26.

        Program program2 = new Program(tab2);
        program2.obliczWszystkie();
        //Powinno zwrócić wyjątek
    }
    
}