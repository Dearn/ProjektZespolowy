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
public class PerceptronLayers {

    public static void main(String[] args) {
        PerceptronSet set = new PerceptronSet();    // Modelowany układ
        
        double[][] ciag = new double[4][];          // Ciąg uczący
        for(int i=0; i<ciag.length; i++)
            ciag[i] = new double[3];
        
        ciag[0][0] = 0.0; ciag[0][1] = 0.0; ciag[0][2] = 0.1;
        ciag[1][0] = 0.0; ciag[1][1] = 1.0; ciag[1][2] = 0.9;
        ciag[2][0] = 1.0; ciag[2][1] = 0.0; ciag[2][2] = 0.9;
        ciag[3][0] = 1.1; ciag[3][1] = 1.0; ciag[3][2] = 0.1;
        
        set.teach(ciag);
        //set.show();
        set.checkPoint(1.0, 0.0);
    }
}
