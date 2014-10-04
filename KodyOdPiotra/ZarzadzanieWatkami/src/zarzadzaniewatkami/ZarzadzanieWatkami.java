package zarzadzaniewatkami;
import java.util.concurrent.*;

class Zadanie implements Runnable
{
    static int licznik=0;
    int id=licznik++;
    
    @Override
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println("Jestem watek : "+id+" , "+i);
            Thread.yield();
        }
    }
}

public class ZarzadzanieWatkami {
    public static void main(String[] args) {
        /*for(int i=0;i<10;i++)
        {
        new Thread(new Zadanie()).start();
        }*/
        /*Executor exec = Executors.newSingleThreadExecutors();
        for(int i=0;i<10;i++)
        {
        exec.execute(new Zadanie());
        }*/
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++)
        {
        exec.execute(new Zadanie());
        }
        exec.shutdown();
        /*Executor exec = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++)
        {
        exec.execute(new Zadanie());
        }*/
    }   
}
