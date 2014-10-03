package perceptronset;


public class Perceptron {
    public double []wagi;
    int iWarstwa, iKolej;
    double dX;
    
    public Perceptron(int warstwa, int kolej, int wejsc){
        iWarstwa = warstwa;
        iKolej = kolej;
        wagi = new double[wejsc+1];
        for(int i=0; i<wagi.length; i++)
            wagi[i] = Math.random();
    }
    
    void wagi(){
        for(double i : wagi)
            System.out.println(i);
    }
    
    double liczY(double []dU){
        double dS = 0; 
        for(int i = 0; i<dU.length ;i++){
            dS += wagi[i] * dU[i];
        }
        dS += wagi[dU.length] * 1;

        dX = 1 / (1 + Math.exp(-dS));
        return dX;
    }
    
    double liczE(double d){
        return d * (dX * (1 - dX));
    }
}
