/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kolo2;

import static java.lang.Thread.sleep;

/**
 *
 * @author Samael
 */
public class Kolo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bufor b=new Bufor(2);
        Producent p1=new Producent(1,b);p1.start();
        Producent p2=new Producent(2,b);p2.start();
        Konsument k=new Konsument(1,b);k.start();
    }
    
}
class Bufor{
    int poj;
    int w1,w2;
    boolean polozone1,polozone2;
    //int wart=0;
    Bufor(int c)
	{
                        poj = c;
                        //arbit1=0;
	}
    public synchronized void put1(int nr, int element)
	{
		while(polozone1){
                    try{
                    wait();
                    }catch(Exception e){}
                }
                w1=element;
                System.out.println("Producent "+nr+" podał "+element);polozone1=true;
                notifyAll();
	}
    public synchronized void put2(int nr, int element)
	{
		while(polozone2){
                    try{
                    wait();
                    }catch(Exception e){}
                }
                w2=element;
                System.out.println("Producent "+nr+" podał "+element);polozone2=true;
                notifyAll();
                
	}
    public synchronized void get(int nr)
	{
		while(polozone1==false || polozone2==false){
                    try{
                    wait();
                    }catch(Exception e){}
                }
                //System.out.println("Konsument "+nr+" pobrał "+arbit);
               
                
                System.out.println("Pobrano : "+w1+" i "+w2);
                polozone1=false;
                polozone2=false;
                notifyAll();
	}
}

class Producent extends Thread
{
	int numer;
	Bufor b;
        
	public Producent(int nr, Bufor c)
	{
		numer = nr;
		b = c; 
	}
        
	public void run()
	{
		for(int i=0;i<10;i++)
		{
                    if(numer==1){
			b.put1(numer,i+1);
                    try
			{
				sleep(100);
			}catch(Exception e){}
                    }
                    
                    if(numer==2){
                        b.put2(numer,i+1);
			try
			{
				sleep(300);
			}catch(Exception e){}
                    }
                }
                //numer=0;
		}
	}

class Konsument extends Thread
{
	int numer;
	Bufor b;
	
	public Konsument(int nr, Bufor c)
	{
		numer = nr;
		b = c;
	}
	
	public void run()
	{
		for(int i=0;i<10;i++)
		{
                    //System.out.println("Konsument pobral: " + b.get(numer)+" i ");
			b.get(numer);
			try
			{
				sleep(100);
			}catch(Exception e){}
		}
	}
}