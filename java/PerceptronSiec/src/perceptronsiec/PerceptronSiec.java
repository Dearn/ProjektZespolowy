package perceptronsiec;

import java.util.Scanner;

 class Input {
    public double X, W;
    
    public Input(){
        X = 0;
        W = Math.random();
    }
    
    public Input(double x){
        X = x;
        W = Math.random();
    }
}

class Output {
    public double Y, E, e;
    
    public Output(){
        Y = -1.0;
        E = -1.0;
        e = -1.0;        
    }
}

 class Pojperceptron {
    Input[] wejscia = new Input[3];
    Output wyjscie = new Output();
    
    public Pojperceptron(){
        for(int j=0; j<wejscia.length-1; j++)
            wejscia[j] = new Input();
        wejscia[2] = new Input(1);
    }
    
    public void liczY(){
        double S = 0;
        
        for(Input i : wejscia)
            S += i.W * i.X;
                
        wyjscie.Y = 1 / (1 + Math.exp(-S));
    }
    
    public void liczE(double e){
        wyjscie.e = e;
        wyjscie.E = e * (wyjscie.Y * (1 - wyjscie.Y));
    }
    
    public void showInp(){
        System.out.print(wejscia[0].X + ", " + wejscia[1].X + ", " + wejscia[2].X);
    }
}

 class MainPerceptron {
    private final Pojperceptron[][] pomocniczatab;
    
    public MainPerceptron (){
        pomocniczatab = new Pojperceptron[2][];
        
        pomocniczatab[0] = new Pojperceptron[2];
        pomocniczatab[1] = new Pojperceptron[1];
            
        for(Pojperceptron[] i : pomocniczatab)
            for(int j=0; j<i.length; j++)
                i[j] = new Pojperceptron();
    }
    
    public void Uczenie(double[][] ciag){
        
        for(int x=0; x<5000; x++)
            for(double[] n : ciag){

                for(int i=0; i<pomocniczatab.length; i++)
                    for(int j=0; j<pomocniczatab[i].length; j++){
                        if(i==0){
                            pomocniczatab[i][j].wejscia[0].X = n[0];
                            pomocniczatab[i][j].wejscia[1].X = n[1];
                            pomocniczatab[i][j].liczY();
                        }
                        else{
                            pomocniczatab[i][j].wejscia[0].X = pomocniczatab[i-1][0].wyjscie.Y;
                            pomocniczatab[i][j].wejscia[1].X = pomocniczatab[i-1][1].wyjscie.Y;
                            pomocniczatab[i][j].liczY();
                        }
                    }

                for(int i=pomocniczatab.length-1; i>-1; i--)
                    for(int j=0; j<pomocniczatab[i].length; j++){
                        if(i==pomocniczatab.length-1){
                            pomocniczatab[i][j].liczE(n[2] - pomocniczatab[i][j].wyjscie.Y);
                        }
                        else{
                            pomocniczatab[i][j].liczE(pomocniczatab[i+1][0].wyjscie.E * pomocniczatab[i+1][0].wejscia[j].W);
                        }
                    }

                for(int i=pomocniczatab.length-1; i>-1; i--)
                    for(Pojperceptron j : pomocniczatab[i])
                        for(Input k : j.wejscia){
                            k.W = k.W + 2 * 0.2 * j.wyjscie.E * k.X;
                    }
            }
    }
    
    public void PunktDoTestowania(double x1, double x2){
        for(int i=0; i<pomocniczatab.length; i++)
                for(int j=0; j<pomocniczatab[i].length; j++){
                    if(i==0){
                        pomocniczatab[i][j].wejscia[0].X = x1;
                        pomocniczatab[i][j].wejscia[1].X = x2;
                        pomocniczatab[i][j].liczY();
                    }
                    else{
                        pomocniczatab[i][j].wejscia[0].X = pomocniczatab[i-1][0].wyjscie.Y;
                        pomocniczatab[i][j].wejscia[1].X = pomocniczatab[i-1][1].wyjscie.Y;
                        pomocniczatab[i][j].liczY();
                    }
                }
        System.out.println("Wyjście wynosi: " + pomocniczatab[1][0].wyjscie.Y);
    }
}


public class PerceptronSiec {
    public static void main(String[] args) {
        while(true){
       MainPerceptron ust = new MainPerceptron();
       Scanner mrp = new Scanner(System.in);
       
       String wybor;
        System.out.println("Chcesz wyjść ?(tak,nie)");
        wybor = mrp.nextLine();
        if(wybor.matches("tak")){
            break;
        }
       
        double[][] Wartpocz = new double[4][];
        for(int i=0; i<Wartpocz.length; i++)
            Wartpocz[i] = new double[3];
        
        Wartpocz[0][0] = 0.0;
        Wartpocz[0][1] = 0.0; 
        Wartpocz[0][2] = 0.1;
        Wartpocz[1][0] = 0.0; 
        Wartpocz[1][1] = 1.0; 
        Wartpocz[1][2] = 0.9;
        Wartpocz[2][0] = 1.0; 
        Wartpocz[2][1] = 0.0; 
        Wartpocz[2][2] = 0.9;
        Wartpocz[3][0] = 1.1; 
        Wartpocz[3][1] = 1.0; 
        Wartpocz[3][2] = 0.1;
        
        double l1,l2;
        System.out.println("Podaj wejście nr1 : ");
        l1 = mrp.nextDouble();
        System.out.println("Podaj wejście nr2 : ");
        l2 = mrp.nextDouble();
        
        ust.Uczenie(Wartpocz);
        ust.PunktDoTestowania(l1, l2);
        }
}
}
    
