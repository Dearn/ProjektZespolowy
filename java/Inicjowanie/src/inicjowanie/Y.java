/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inicjowanie;

/**
 *
 * @author Samael
 */
public class Y {
    X x1=new X();
    X x2;
    X x3;
    
    public Y()
    {
     x3=new X();
     System.out.println("Deklaracja w ciele konstruktora !");
    }
    
    {
    x2=new X();
    System.out.println("Deklaracja w bloku !");
    }
}
