package kolokwium;

import static java.lang.Thread.sleep;

public class Kolokwium {
    public static void main(String[] args) {
        Bufor b=new Bufor(1);
        Bufor b1=new Bufor(1);
        Producent p1=new Producent(1,b); p1.start();
        Producent1 p2=new Producent1(2,b,b1);p2.start();
        Konsument k=new Konsument(1,b1);k.start();  
    }
}

class Bufor{
    int poj;
    int arbit;
    //int wart=0;
    Bufor(int c)
	{
                        poj = c;
                        arbit=0;
	}
    public synchronized void put(int nr, int element)
	{
		while(arbit!=0){
                    try{
                    wait();
                    }catch(Exception e){}
                }
                arbit=element;
                System.out.println("Producent "+nr+" podał "+element);
                notifyAll();
	}
    public synchronized int get(int nr)
	{
		while(arbit==0){
                    try{
                    wait();
                    }catch(Exception e){}
                }
                //System.out.println("Konsument "+nr+" pobrał "+arbit);
               
                notifyAll();
                int temp=arbit;
                arbit=0;
                return temp;
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
			b.put(numer,i+1);
			try
			{
				sleep(100);
			}catch(Exception e){}
				
		}
	}
}

class Producent1 extends Thread
{
	int numer;
	Bufor b;
        Bufor b1;
        
	public Producent1(int nr, Bufor c,Bufor d)
	{
		numer = nr;
		this.b = c;
                this.b1=d;
	}
        
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			int temp=b.get(numer);
                        b1.put(numer,temp+i+1);
			try
			{
				sleep(100);
			}catch(Exception e){}
				
		}
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
                    System.out.println("Konsument pobral: " + b.get(numer));
			//b.get(numer);
			try
			{
				sleep(100);
			}catch(Exception e){}
		}
	}
}