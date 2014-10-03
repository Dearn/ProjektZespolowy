package domek;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Domek {   
    static JFrameWin jFrameWindow;    
    public static class MyComponent extends JComponent{
     @Override
        protected void paintComponent(Graphics g) {
            Graphics2D graphics2D = (Graphics2D)g;
            Rectangle2D.Double rectangle2D = new Rectangle2D.Double(50,500 , 450, 20);
            graphics2D.draw(rectangle2D);
            graphics2D.setPaint(new Color(139,69,19));
            graphics2D.fill(rectangle2D);
            Rectangle2D.Double rec2 = new Rectangle2D.Double(50,495 , 450, 5);
            graphics2D.draw(rec2);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(rec2);
            Rectangle2D.Double rec3 = new Rectangle2D.Double(50,475 , 450,20);
            graphics2D.draw(rec3);
            graphics2D.setPaint(new Color(139,69,19));
            graphics2D.fill(rec3);
            Rectangle2D.Double rec4 = new Rectangle2D.Double(50,470 , 450, 5);
            graphics2D.draw(rec4);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(rec4);
            Rectangle2D.Double rec5 = new Rectangle2D.Double(50,450,450,20);
            graphics2D.draw(rec5);
            graphics2D.setPaint(new Color(139,69,19));
            graphics2D.fill(rec5);
            Rectangle2D.Double rec6 = new Rectangle2D.Double(50,445,450,5);
            graphics2D.draw(rec6);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(rec6);
            Rectangle2D.Double rec7 = new Rectangle2D.Double(50,425,450,20);
            graphics2D.draw(rec7);
            graphics2D.setPaint(new Color(139,69,19));
            graphics2D.fill(rec7);
            Rectangle2D.Double rec8 = new Rectangle2D.Double(50,420,450,5);
            graphics2D.draw(rec8);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(rec8);
            Rectangle2D.Double rec9 = new Rectangle2D.Double(50,400,450,20);
            graphics2D.draw(rec9);
            graphics2D.setPaint(new Color(139,69,19));
            graphics2D.fill(rec9);
            Rectangle2D.Double rec10 = new Rectangle2D.Double(50,395,450,5);
            graphics2D.draw(rec10);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(rec10);
            Rectangle2D.Double rec11 = new Rectangle2D.Double(50,375,450,20);
            graphics2D.draw(rec11);
            graphics2D.setPaint(new Color(139,69,19));
            graphics2D.fill(rec11);
            Rectangle2D.Double rec12 = new Rectangle2D.Double(50,370,450,5);
            graphics2D.draw(rec12);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(rec12);
            Rectangle2D.Double rec13 = new Rectangle2D.Double(50,350,450,20);
            graphics2D.draw(rec13);
            graphics2D.setPaint(new Color(139,69,19));
            graphics2D.fill(rec13);
            Rectangle2D.Double rec14 = new Rectangle2D.Double(50,345,450,5);
            graphics2D.draw(rec14);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(rec14);
            Rectangle2D.Double rec15 = new Rectangle2D.Double(50,325,450,20);
            graphics2D.draw(rec15);
            graphics2D.setPaint(new Color(139,69,19));
            graphics2D.fill(rec15);
            Rectangle2D.Double rec16 = new Rectangle2D.Double(75,335,100,185);
            graphics2D.draw(rec16);
            graphics2D.setPaint(Color.YELLOW);
            graphics2D.fill(rec16);
            Rectangle2D.Double rec17 = new Rectangle2D.Double(80,340,90,175);
            graphics2D.draw(rec17);
            graphics2D.setPaint(Color.DARK_GRAY);
            graphics2D.fill(rec17);
            Rectangle2D.Double rec18 = new Rectangle2D.Double(250,340,130,130);
            graphics2D.draw(rec18);
            graphics2D.setPaint(Color.WHITE);
            graphics2D.fill(rec18);
            Rectangle2D.Double rec19 = new Rectangle2D.Double(257,345,55,120);
            graphics2D.draw(rec19);
            graphics2D.setPaint(Color.BLUE);
            graphics2D.fill(rec19);
            Rectangle2D.Double rec20 = new Rectangle2D.Double(317,345,55,120);
            graphics2D.draw(rec20);
            graphics2D.setPaint(Color.BLUE);
            graphics2D.fill(rec20);
            Rectangle2D.Double rec21 = new Rectangle2D.Double(400,175,20,120);
            graphics2D.draw(rec21);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(rec21);
            int[]x = new int[3];
            int[]y = new int[3];
            int n;  // count of points
            x[0]=275; x[1]=500; x[2]=50;
            y[0]=150; y[1]=325; y[2]=325;
            n = 3;
            Polygon myTri = new Polygon(x, y, n);  // a triangle
            graphics2D.draw(myTri);
            graphics2D.setPaint(Color.RED);
            graphics2D.fill(myTri);  
            Ellipse2D.Double circ = new Ellipse2D.Double(225,200,100,100);
            graphics2D.draw(circ);
            graphics2D.setPaint(Color.WHITE);
            graphics2D.fill(circ); 
            Ellipse2D.Double circ1 = new Ellipse2D.Double(235,210,80,80);
            graphics2D.draw(circ1);
            graphics2D.setPaint(Color.BLUE);
            graphics2D.fill(circ1);
            Rectangle2D.Double rec22 = new Rectangle2D.Double(270,207,10,85);
            graphics2D.draw(rec22);
            graphics2D.setPaint(Color.WHITE);
            graphics2D.fill(rec22);
            Rectangle2D.Double rec23 = new Rectangle2D.Double(230,245,85,10);
            graphics2D.draw(rec23);
            graphics2D.setPaint(Color.WHITE);
            graphics2D.fill(rec23);
        }
    }
     
    public static class JFrameWin extends JFrame{
        public JFrameWin(){
            this.setTitle("Piotr Zyszczak");
            this.setSize(600, 600);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
            MyComponent myComponent = new MyComponent();
            this.add(myComponent);
        }
    }
   
    public static void main(String[] args) { 
    Runnable doSwingLater = new Runnable(){
             
            @Override
            public void run() {
                jFrameWindow = new JFrameWin();
                jFrameWindow.setVisible(true);
            }
        };        
        SwingUtilities.invokeLater(doSwingLater);         
    }
    }   

