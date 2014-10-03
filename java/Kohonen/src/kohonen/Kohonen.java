package kohonen;

import java.util.Scanner;

class Neuron{
    public double[] Wagi;
        public double Alfa;
        public String Znak;
        public int numer;
        private static int liczbaObiektow = 0;
        
        public void losujWagi()
        {
        for(int i = 0; i<Wagi.length; i++)
            {
                Wagi[i] = Math.random();
            }
        }
        
        public Neuron() { }
        public Neuron(int liczbaWejsc, double alfa)
        {
            Wagi = new double[liczbaWejsc];
            Alfa = alfa;
            Znak = "";
            liczbaObiektow++;
            numer = liczbaObiektow;
        }

        public void ZmienWagi(int[] wejscie)
        {
            for (int i = 0; i < wejscie.length; i++)
            {
                Wagi[i] += Alfa * (wejscie[i] - Wagi[i]);
            }
        }

        public double PoliczOdleglosc(int[] wejscie)
        {
            double suma = 0.0;
            for(int i = 0; i<Wagi.length; i++)
            {
                suma += Math.pow(wejscie[i]-Wagi[i],2);
            }
            return Math.sqrt(suma);
        }
}

class Study{
    public int LiczbaWejsc, LiczbaNeuronow;
        public Neuron[] Neurony;
        private Neuron zwyciezca;

        public Study(int lwejsc, int lneuronow, double alfa)
        {
            LiczbaWejsc = lwejsc;
            LiczbaNeuronow = lneuronow;
            Neurony = new Neuron[LiczbaNeuronow];
            for (int i = 0; i < Neurony.length; i++)
            {
                Neurony[i] = new Neuron(LiczbaWejsc, alfa);
            }
            
        }
        
        public void losujWagi()
        { 
            for (Neuron n : Neurony)
            {
                n.losujWagi();
            }
        }

        public void Uczenie(int[] wektor, String znak )
        {

            double min_odleglosc = Neurony[0].PoliczOdleglosc(wektor) ;
            for (int i = 1; i < Neurony.length; i++)
            {
                if (zwyciezca != Neurony[i])
                {
                    double odleglosc = Neurony[i].PoliczOdleglosc(wektor);
                    if (min_odleglosc > odleglosc)
                    {
                        min_odleglosc = odleglosc;
                        zwyciezca = Neurony[i];
                    }
                }
            }
            zwyciezca.ZmienWagi(wektor);
            zwyciezca.Znak = znak;
        }

        public String Testowanie(int[] wektor)
        {
            
            double min_odleglosc = 10000;
            for (int i = 0; i < Neurony.length; i++)
            {
                double odleglosc = Neurony[i].PoliczOdleglosc(wektor);
                if (min_odleglosc > odleglosc)
                {
                    min_odleglosc = odleglosc;
                    zwyciezca = Neurony[i];
                }
            }
            return zwyciezca.Znak;
        }
}

public class Kohonen {
    public static void main(String[] args) {
        Scanner mrp = new Scanner(System.in);
        Study ust;
        int[] wektorTestowy = new int[35];
        int[] wektorUczacy0 = {0, 1, 1, 1, 0, 
                                1 ,0 ,0, 0, 1, 
                                1, 0, 0, 0, 1,
                                1, 0, 0, 0, 1,
                                1, 0, 0, 0, 1,
                                1, 0, 0, 0, 1,
                                0, 1, 1, 1, 0};//16

        int[] wektorUczacy1 =  {0, 0, 0, 0, 1 ,
                                0, 0 ,0 ,1, 1 ,
                                0, 0, 1 ,0, 1,
                                0 ,0 ,0 ,0 ,1,
                                0, 0, 0, 0, 1,
                                0, 0 ,0 ,0 ,1,
                                0 ,0, 0, 0, 1};//9

        int[] wektorUczacy2 = {0, 0, 1 ,0, 0 ,
                                0, 1, 0 ,1, 0, 
                                1, 0 ,0 ,0 ,1,
                                0 ,0, 0, 1, 0,
                                0, 0, 1, 0, 0,
                                0, 1, 0, 0, 0,
                                1 ,1, 1, 1, 1};//13

        int[] wektorUczacy3 = {0, 0, 1, 1, 0 ,
                                0 ,0, 0, 0, 1 ,
                                0 ,0 ,0, 0, 1,
                                0, 0, 1, 1 ,1,
                                0, 0, 0 ,0, 1,
                                0 ,0 ,0, 0, 1,
                                0 ,0, 1, 1, 0};//11
       
        int[] wektorUczacy4 = {0, 0 ,0 ,1 ,0 ,
                                0 ,0 ,1, 0, 0 ,
                                0 ,1 ,0, 0, 1,
                                1, 1 ,1, 1, 1,
                                0 ,0, 0, 0, 1,
                                0 ,0, 0, 0, 1,
                                0 ,0, 0 ,0 ,1};//12

        int[] wektorUczacy5 = {0 ,1 ,1, 1, 0 ,
                                0, 1, 0 ,0, 0, 
                                0 ,1, 0 ,0, 0,
                                0 ,1 ,1, 1, 0,
                                0 ,0 ,0, 1, 0,
                                0, 0 ,0, 1 ,0,
                                0, 1, 1, 1, 0 };//13

        int[] wektorUczacy6 = { 0, 1 ,1, 1, 1 ,
                                0, 1, 0, 0, 0, 
                                0, 1, 0, 0, 0,
                                0, 1 ,1, 1, 1,
                                0 ,1, 0 ,0, 1,
                                0 ,1 ,0, 0, 1,
                                0 ,1 ,1, 1, 1};//18

        int[] wektorUczacy7 = {1, 1, 1, 1, 0 ,
                                0, 0, 0, 1, 0, 
                                0 ,0, 0, 1, 0,
                                0 ,0 ,0, 1, 0,
                                0 ,0 ,0, 1, 0,
                                0, 0 ,0, 1, 0,
                                0 ,0 ,0, 1, 0 };//10

        int[] wektorUczacy8 = {0, 1, 1, 1, 0 ,
                                1 ,0, 0 ,0, 1 ,
                                1, 0 ,0 ,0, 1,
                                0 ,1, 1 ,1, 0,
                                1, 0 ,0 ,0, 1,
                                1 ,0, 0, 0, 1,
                                0, 1 ,1, 1, 0 };//17

        int[] wektorUczacy9 = { 0, 1 ,1, 1, 1, 
                                0, 1, 0, 0, 1 ,
                                0 ,1, 0, 0, 1,
                                0 ,1 ,1 ,1, 1,
                                0, 0, 0, 0, 1,
                                0 ,0 ,0 ,0, 1,
                                0 ,1, 1, 1, 1 };//18

        int[] wektorUczacyA = { 0, 1, 1, 1, 0, 
                                1, 0, 0, 0, 1 ,
                                1, 0 ,0 ,0 ,1,
                                1, 1 ,1 ,1, 1,
                                1, 0, 0, 0 ,1,
                                1, 0, 0, 0, 1,
                                1 ,0 ,0, 0, 1 };//18

        int[] wektorUczacyB = {1 ,1 ,1, 1 ,0,
                                1, 0, 0 ,0, 1,
                                1 ,0, 0, 0, 1,
                                1 ,1, 1, 1, 0,
                                1, 0 ,0, 0 ,1,
                                1,0 ,0, 0, 1,
                                1 ,1 ,1, 1, 0 };

        int[] wektorUczacyC = { 0, 1 ,1 ,1, 0,
                                1, 0 ,0, 0, 0,
                                1, 0 ,0, 0 ,0,
                                1, 0, 0 ,0 ,0,
                                1 ,0 ,0, 0, 0,
                                1, 0, 0, 0, 0,
                                0 ,1, 1, 1, 0};

        int[] wektorUczacyD = { 1, 1, 1, 0 ,0,
                                1, 0 ,0, 1, 0,
                                1, 0, 0 ,0, 1,
                                1, 0, 0, 0, 1,
                                1, 0 ,0, 0, 1,
                                1, 0, 0, 1 ,0,
                                1 ,1, 1 ,0, 0};

        int[] wektorUczacyE = {1, 1, 1, 1, 1,
                                1, 0, 0 ,0, 0,
                                1, 0 ,0, 0 ,0,
                                1, 1, 1, 0, 0,
                                1 ,0, 0, 0, 0,
                                1, 0, 0, 0, 0,
                                1 ,1, 1 ,1, 1};

        int[] wektorUczacyF = { 1, 1, 1 ,1, 0,
                                1, 0, 0 ,0, 0,
                                1 ,0 ,0, 0, 0,
                                1 ,1 ,1 ,0, 0,
                                1, 0, 0, 0, 0,
                                1 ,0, 0, 0, 0,
                                1, 0, 0, 0 ,0};
        int liczbaIteracji = 2500;
        double alfa = 0.1;
        ust = new Study(35, 700, alfa);
        ust.losujWagi();
        for (int i = 0; i < liczbaIteracji; i++)
            {
                ust.Uczenie(wektorUczacy0, "0");
                ust.Uczenie(wektorUczacy1, "1");
                ust.Uczenie(wektorUczacy2, "2");
                ust.Uczenie(wektorUczacy3, "3");
                ust.Uczenie(wektorUczacy4, "4");
                ust.Uczenie(wektorUczacy5, "5");
                ust.Uczenie(wektorUczacy6, "6");
                ust.Uczenie(wektorUczacy7, "7");
                ust.Uczenie(wektorUczacy8, "8");
                ust.Uczenie(wektorUczacy9, "9");
                ust.Uczenie(wektorUczacyA, "A");
                ust.Uczenie(wektorUczacyB, "B");
                ust.Uczenie(wektorUczacyC, "C");
                ust.Uczenie(wektorUczacyD, "D");
                ust.Uczenie(wektorUczacyE, "E");
                ust.Uczenie(wektorUczacyF, "F");
            }
        System.out.println("Podaj wektor : ");
        for(int j=0; j<wektorTestowy.length; j++)
        wektorTestowy[j] = mrp.nextInt();
        String symbol;
        symbol=ust.Testowanie(wektorTestowy);
        System.out.println("Próbowałeś podać : "+symbol);
    }   
}
