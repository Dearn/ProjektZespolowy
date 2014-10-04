/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perceptronlayers;

/**
 *
 * @author Martin
 */
public class PerceptronSet {
    private final Perceptron[][] tab;
    boolean prog = false;
    
    public PerceptronSet(){
        tab = new Perceptron[2][];
        
        tab[0] = new Perceptron[2];
        tab[1] = new Perceptron[1];
            
        for(Perceptron[] i : tab)
            for(int j=0; j<i.length; j++)
                i[j] = new Perceptron();
    }
    
    public void teach(double[][] ciag){
        
        for(int x=0; x<5000; x++)
            for(double[] n : ciag){

                for(int i=0; i<tab.length; i++)             // ustawienie wejść i liczY
                    for(int j=0; j<tab[i].length; j++){
                        if(i==0){
                            tab[i][j].wejscia[0].X = n[0];
                            tab[i][j].wejscia[1].X = n[1];
                            tab[i][j].countY();
                        }
                        else{
                            tab[i][j].wejscia[0].X = tab[i-1][0].wyjscie.Y;
                            tab[i][j].wejscia[1].X = tab[i-1][1].wyjscie.Y;
                            tab[i][j].countY();
                        }
                    }

                for(int i=tab.length-1; i>-1; i--)          // liczE
                    for(int j=0; j<tab[i].length; j++){
                        if(i==tab.length-1){
                            tab[i][j].countE(n[2] - tab[i][j].wyjscie.Y);
                        }
                        else{
                            tab[i][j].countE(tab[i+1][0].wyjscie.E * tab[i+1][0].wejscia[j].W);
                        }
                    }

                for(int i=tab.length-1; i>-1; i--)          // korekcja wag  
                    for(Perceptron j : tab[i])
                        for(Input k : j.wejscia){
                            k.W = k.W + 2 * 0.2 * j.wyjscie.E * k.X;
                    }
            }
    }
    
    public void checkPoint(double x1, double x2){
        for(int i=0; i<tab.length; i++)             // liczY
                for(int j=0; j<tab[i].length; j++){
                    if(i==0){
                        tab[i][j].wejscia[0].X = x1;
                        tab[i][j].wejscia[1].X = x2;
                        tab[i][j].countY();
                    }
                    else{
                        tab[i][j].wejscia[0].X = tab[i-1][0].wyjscie.Y;
                        tab[i][j].wejscia[1].X = tab[i-1][1].wyjscie.Y;
                        tab[i][j].countY();
                    }
                }
        
        System.out.println("Dla punktu o współrzędnych " + x1 +", " + x2);
        System.out.println("Wyjście układu przyjęło wartość: " + tab[1][0].wyjscie.Y);
    }
    
    public void show(){
        for(Perceptron[] i : tab)
            for(Perceptron j : i){
                System.out.println("Wejścia perceptronu: ");
                j.showInp();
                System.out.println("\nBłąd wyjścia perceptronu:\n" + tab[1][0].wyjscie.e);
                System.out.println("Wyjście perceptronu:\n" + j.wyjscie.Y + "\n");
            }
        System.out.println();
    }
}