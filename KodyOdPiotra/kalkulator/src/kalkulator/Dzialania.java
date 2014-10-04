/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kalkulator;

/**
 *
 * @author Samael
 */
public class Dzialania{
    double wynik;
  public double Dodawanie(int l,double liczba,double tablica[])
  {
      for(int i=1;i<l+1;i++){
       liczba = liczba + tablica[i];   
      }
      return liczba;
  }
  public double Różnica(double liczba,double tablica[])
  { 
      return  wynik = liczba - tablica[1];   
  }
  public double Mnożenie(double liczba,double tablica[])
  { 
      return  wynik = liczba * tablica[1];   
  }
  public double Dzielenie(double liczba,double tablica[])
  { 
      return  wynik = liczba / tablica[1];   
  }
}
