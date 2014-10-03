package libeczka;
import java.util.Scanner;

class Ksiazka{
    static String text="text";
    boolean i=false;
    public synchronized String pisz(int wypociny){
        while(i == true){
        try{
            text+=wypociny;
            wait(10);
        }
        catch(InterruptedException e){}
        }
        i=true;
        notify();
        return text;
    }
    public synchronized String czytaj(){
        try{
            wait(10);
        }
        catch(InterruptedException e){}
        i=false;
        notify();
        return text;
    }
}

class Pisarz extends Thread{
    Ksiazka k;
    static int licznik=0;
    int id=licznik++;
    public Pisarz(Ksiazka x){
        /*this.*/k=x;
    }
    @Override
    public void run(){
        for(int i=0;i<101;i++)
        {
        try{
        sleep((int)Math.random()*100);
        }
        catch(InterruptedException e){}
        System.out.println("Pisarz o id :"+id+" Napisał : "+k.pisz(id));
        }
    }
}

class Czytelnik extends Thread{
    Ksiazka k;
    static int licznik=0;
    int id=licznik++;
    public Czytelnik(Ksiazka x){
        this.k=x;
    }
    @Override
    public void run(){
        for(int i=0;i<101;i++)
        {
            try{
                sleep((int)Math.random()*100);
            }
            catch(InterruptedException e){}
            System.out.println("Czytelnik o id :"+id+" Wyczytał : "+k.czytaj());
        }
    }
}

public class Libeczka {
    public static void main(String[] args) {
        int l,n;
        Scanner mrp = new Scanner(System.in);
        System.out.println("Ilu chcesz czytelników ? : ");
        l = mrp.nextInt();
        System.out.println("Ilu chcesz pisarzy ? : ");
        n = mrp.nextInt();
        Ksiazka k;
        Czytelnik cz[];
        Pisarz p[];
            k = new Ksiazka();
            cz = new Czytelnik[l];
            p = new Pisarz[n];
        
        for(int i=0;i<l;i++)
        {
            cz[i]=new Czytelnik(k);
            cz[i].start();
        }
        for(int i=0;i<n;i++)
        {
            p[i]=new Pisarz(k);
            p[i].start();
        }
        
    }
    
}
