package hello;
/**
 *
 * @author Samael
 * W linuxie by uruchomić plik wpisujemy "javac Hello" "java Hello"
 */
public class Hello {
    public static void main(String args[]) {
        System.out.println("Witajcie !" + Thread.currentThread().getName());
        //System.out.println("Witajcie ! i " + args.length);
        
       /* Watek w1=new Watek();
        Watek w2=new Watek();
        Watek w3=new Watek();
        w1.start();
        (new Watek()).start();
        w2.start();
        (new Watek()).start();
        w3.start();
        (new Watek()).start();*/
        Watek2 wr=new Watek2();
        Thread t1=new Thread(wr);
        t1.start();
        Watek2 wr1=new Watek2();
        Thread t2=new Thread(wr1);
        t2.start();
    } 
}

class Watek extends Thread{
    static int l=0;
    int id=l++;
    @Override
    public void run(){
        System.out.println("Witajcie bardzo!"+Thread.currentThread().getName());
    }
}

class Watek2 implements Runnable{
    static int l=0;
    int id=l++;
    @Override
    public void run(){
        //System.out.println("Witajcie bardzo!"+Thread.currentThread().getName());
        System.out.println("Witajcie bardzo!"+id);
    }
}