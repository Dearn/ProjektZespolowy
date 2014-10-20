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
public class Input {
    public double X, W;  // X = sygnał wejściowy, W = waga wejścia
    
    public Input(){
        X = 0;
        W = Math.random();
    }
    
    public Input(double x){
        X = x;
        W = Math.random();
    }
}
