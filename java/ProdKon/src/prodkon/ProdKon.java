/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prodkon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Samael
 */
public class ProdKon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bufor b=new Bufor();
        /*Producent p[]=new Producent[5];
        Konsument k[] =new Konsument[5];*/
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for(int i=0;i<4;i++)
        {
        exec.execute(new Producent(b));
        exec.execute(new Konsument(b));
        }
        exec.shutdown();
    }
    
}

class Bufor extends Thread{
    int wartosc=0;
    public void put(int a){
        if(wartosc==0)
            wartosc=a;
    }
    public int get(){
        int tmp=0;
        if(wartosc>0)
        {
            tmp=wartosc;
            wartosc=0;
        }
        return tmp;
    }
}

class Producent extends Thread{
    Bufor B;
    int s=0;
    static int licznik=0;
    int id=licznik++;
    public Producent(Bufor B)
    {
        this.B=B;
    }
    
    public void run(){
        for(int i=0;i<10;i++)
        {
            s+=i;
            B.put(i);
            System.out.println("Producent "+id+" napisał !"+i);
            try{
                sleep((int)Math.ceil(Math.random()*100));
            }
            catch(Exception e){
                
            }
        }
    }
}

class Konsument extends Thread{
    Bufor B;
    int s=0;
    static int licznik=0;
    int id=licznik++;
    public Konsument(Bufor B)
    {
        this.B=B;
    }
    
    public void run(){
        for(int i=0;i<10;i++)
        {
            s+=i;
            B.get();
            System.out.println("Konsument "+id+" odczytał !"+i);
            try{
                sleep((int)Math.ceil(Math.random()*200));
            }
            catch(Exception e){
                
            }
        }
    }
}