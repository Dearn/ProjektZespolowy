package filozofy;
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Widelec{
    int nr,widek=0;
    boolean podniesione = false;
    public Widelec(int n){
        nr = n;
    }
    public synchronized boolean podnies(){
         while(podniesione == true && widek>=4){
            try{
                wait((int)Math.random()*100);
            }
            catch(Exception e){}
         }
        widek++;
        podniesione = true;
        notify();
        return true;
    }
    public synchronized int odluz(){
        widek--;
            podniesione = false;
        notify();
        return nr;
    }
}

class Filozof implements Runnable{
    Widelec w1 , w2;
    static int licznik=0;
    int id=licznik++;
    public Filozof(Widelec w1 ,Widelec w2){
        this.w1=w1;
        this.w2=w2;
    }
    @Override
    public void run(){
        try{
           sleep((int)Math.random()*100);
        }
        catch(InterruptedException e){}
        for(int i=0;i<101;i++)
        {
            if (w1.podnies()){
            System.out.println("Filozof o id :"+id+" Podniosł : lewy");
            Thread.yield();
            if (w2.podnies()){
            System.out.println("Filozof o id :"+id+" Podniosł : prawy");
            Thread.yield();
            try{
                sleep((int)Math.random()*100);
            }catch(InterruptedException e){}
            w1.odluz();
            w2.odluz();
            }
            System.out.println("Filozof o id :"+id+" Odlozyl : "+w1.odluz()+" , "+w2.odluz());
            Thread.yield();
            }
            }
    }
}

public class Filozofy {
    public static void main(String[] args) {
        int n;
        Scanner mrp = new Scanner(System.in);
        System.out.println("Ilu chcesz filozofow ? : ");
        n = mrp.nextInt();
        Widelec w[]=new Widelec[n];
        Filozof f[]=new Filozof[n];
        for(int i=0;i<n;i++)
        {
            w[i]=new Widelec(i);           
        }
        ExecutorService exec = Executors.newFixedThreadPool(n);
        for(int i=0;i<n;i++)
        {
        exec.execute(new Filozof(w[i],w[(i+1)%n]));
        }
        exec.shutdown();
    }
}
