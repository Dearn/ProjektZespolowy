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
public class Output {
    public double Y, E, e;     // Y = sygnał generowany przez wyjście, E = błąd
    
    public Output(){
        Y = -1.0;
        E = -1.0;
        e = -1.0;        
    }
}
