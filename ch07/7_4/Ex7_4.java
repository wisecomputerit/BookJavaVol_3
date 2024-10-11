
import java.awt.*;
import java.awt.event.*;

public class Ex7_4 extends Frame implements Runnable {

    int x1=50, y1=50, x2=100, y2=100, x3=150, y3=150;
    int flag=0;
    Image img1, img2, img3;

    public static void main(String args[]) {
      Ex7_4 workStart=new Ex7_4();
    }
    
    public Ex7_4() {
        super("Ex7_4");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img1 = tk.getImage("img7_4_01.jpg");
        img2 = tk.getImage("img7_4_02.jpg");
        img3 = tk.getImage("img7_4_03.jpg");

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);

        setVisible(true);
        new Thread(this).start();
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public void processMouseEvent(MouseEvent e) {
        if(e.getID() == MouseEvent.MOUSE_PRESSED)
           if(((e.getX() >= x1) && (e.getX() <= (x1+40))) &&
             ((e.getY() >= y1) && (e.getY() <= (y1+40))))  {
                flag = 1;
            }

           if(((e.getX() >= x2) && (e.getX() <= (x2+40))) &&
             ((e.getY() >= y2) && (e.getY() <= (y2+40))))  {
                flag = 2;
            }

           if(((e.getX() >= x3) && (e.getX() <= (x3+40))) &&
             ((e.getY() >= y3) && (e.getY() <= (y3+40))))  {
                flag = 3;
            }
  
           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag == 1)) {
                x1 = e.getX();
                y1 = e.getY();
                flag = 0;
           }

           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag == 2)) {
                x2 = e.getX();
                y2 = e.getY();
                flag = 0;
           }

           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag == 3)) {
                x3 = e.getX();
                y3 = e.getY();
                flag = 0;
           }
     }

    public void run() {
      while(true) {
         repaint();
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
        g.drawImage(img1, x1, y1, this);
        g.drawImage(img2, x2, y2, this);
        g.drawImage(img3, x3, y3, this);
    }
}





