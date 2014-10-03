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
public class Perceptron {
    public Input[] wejscia = new Input[3];
    public Output wyjscie = new Output();
    
    public Perceptron(){
        for(int j=0; j<wejscia.length-1; j++)
            wejscia[j] = new Input();
        wejscia[2] = new Input(1);
    }
    
    public void countY(){
        double S = 0;
        
        for(Input i : wejscia)
            S += i.W * i.X;
                
        wyjscie.Y = 1 / (1 + Math.exp(-S));
    }
    
    public void countE(double e){
        wyjscie.e = e;
        wyjscie.E = e * (wyjscie.Y * (1 - wyjscie.Y));
    }
    
    public void showInp(){
        System.out.print(wejscia[0].X + ", " + wejscia[1].X + ", " + wejscia[2].X);
    }
}
 
