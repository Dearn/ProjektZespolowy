package perceptronset;

public class PerceptronSet {
    
    public static void main(String[] args) {
        double [][]dU = new double[4][];
        for(int i=0; i<dU.length; i++)
            dU[i] = new double[2];
        
        dU[0][0] = 0.0; dU[0][1] = 0.0;
        dU[1][0] = 0.0; dU[1][1] = 1.0;
        dU[2][0] = 1.0; dU[2][1] = 0.0;
        dU[3][0] = 1.1; dU[3][1] = 1.0;
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double iMi = 0.1;
        //System.out.println("Podaj liczbę warstw: ");
        
        int iLiczbaWarstw = 2;// scanner.nextInt();
        int []iN = new int[iLiczbaWarstw];
        
        /*for(int i=0; i<iN.length; i++){
            System.out.println("Podaj liczbę perceptronów warstwy "+(i+1)+": ");
            iN[i] = scanner.nextInt();
        }*/
        iN[0] = 2;
        iN[1] = 1;
        
        Perceptron [][]uklad = new Perceptron[iLiczbaWarstw][];
        
        for(int i=0; i<uklad.length; i++)
        {
            uklad[i] = new Perceptron[iN[i]];
            for(int j=0; j<uklad[i].length; j++)
                if(j==0)
                    uklad[i][j] = new Perceptron(i,j,dU[0].length);
                else
                    uklad[i][j] = new Perceptron(i,j,uklad[j-1].length);
        }
        
        //double []dX = new double [2];
        
        double [][]dY = new double[iLiczbaWarstw][];
        for(int i=0; i<dY.length; i++)
            dY[i] = new double[uklad[i].length];  // liczba wejść
        
        double [][]dE = new double[iLiczbaWarstw][]; // Errorz
        for(int i=0; i<dY.length; i++)
            dE[i] = new double[uklad[i].length];
        
        double [] dD = new double[4];
        dD[0] = 0.1;
        dD[1] = 0.9;
        dD[2] = 0.9;
        dD[3] = 0.1;
        
        for(int n=0; n<dU.length; n++){
            //Licz Y
            for(int k=0; k<uklad.length; k++)
                for(int j=0; j<uklad[k].length; j++){
                    if(k == 0)
                        dY[k][j] = uklad[k][j].liczY(dU[n]);
                    else{
                        dY[k][j] = uklad[k][j].liczY(dY[k-1]);
                    }
                }
        }
        double S;
        for(int n=dU.length-1; n>-1; n--){
            for(int k=uklad.length-1; k>-1; k--){
                for(int i=0; i<uklad[k].length; i++){
                    if(k == uklad.length-1)
                        dE[k][i] = uklad[k][i].liczE(dD[n] - dY[k][i]);
                    else{
                        S = 0;
                        for(int j=0; j<uklad[k+1].length; j++){
                          //  S += 
                        }
                            
                        //    dE[k][i] = uklad[k][i].liczE(
                    }
                }
            }
        }
    }
}
