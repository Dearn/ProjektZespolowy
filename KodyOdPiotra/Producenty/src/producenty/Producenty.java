package producenty;
import java.util.ArrayList;
public class Producenty {
    public static void main(String[] args) {
                Bufor b = new Bufor(20);
		Producent p[] = new Producent[8];
		Konsument k[] = new Konsument[3];
		
		for(int i=0;i<8;i++)
		{
			p[i] = new Producent(i+1,b);
			p[i].start();
		}
		
		for(int i=0;i<3;i++)
		{
			k[i] = new Konsument(i+1,b);
			k[i].start();
		}
		
	}
}

class Bufor
{
	ArrayList<Integer> wartosc;
	int pojemnosc;
	int arbi = 0;
	Bufor(int c)
	{
			pojemnosc = c;
			wartosc = new ArrayList<Integer>();
	}
	
	public synchronized void put(int nr, int element)
	{
		arbi--;
		while(wartosc.size() >= pojemnosc)
		{
			try
			{
				wait();
			}catch(Exception e){}
		}
		wartosc.add(element);
		System.out.println("Producent wyprodukowal: " + element + " jego numer to: " + nr);
		notifyAll();
	}
	
	public synchronized void get(int numer)
	{
		int w1,w2,w3,w4,w5 = 0;
		if( arbi < 3)
		{
		arbi++;
		while(wartosc.size() < 5)
		{
			try
			{
				wait();
			}catch(Exception e){}
		}
		
		w1 = wartosc.get(wartosc.size()-1);
		w2 = wartosc.get(wartosc.size()-2);
		w3 = wartosc.get(wartosc.size()-3);
		w4 = wartosc.get(wartosc.size()-4);
		w5 = wartosc.get(wartosc.size()-5);
		
		for(int i = 0; i<5;i++)
		{
			wartosc.remove(wartosc.size()-1);
		}
		System.out.println("Konsument pobral: w1 = " + w1 + " w2 = " + w2 + " w3 = " + w3 + " w4  = " + w4 + " w5 = " + w5);
		notifyAll(); 
		}
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
		for(int i=0;i<100;i++)
		{
			b.put(numer,i);
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
		for(int i=0;i<100;i++)
		{
			b.get(numer);
			try
			{
				sleep(100);
			}catch(Exception e){}
		}
	}
}