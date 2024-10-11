
import java.awt.*;
import java.awt.event.*;

public class Ex7_6_1 extends Frame implements Runnable {

    int x1=50, y1=50, fx1=0, fy1=0, dx1=0, dy1=0, flag1=0;
    int x2=100, y2=100, fx2=0, fy2=0, dx2=0, dy2=0, flag2=0;
    Image img1, img2;

    public static void main(String args[]) {
      Ex7_6_1 workStart=new Ex7_6_1();
    }
    
    public Ex7_6_1() {
        super("Ex7_6_1");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img1 = tk.getImage("fly1.GIF");
        img2 = tk.getImage("fly2.GIF");

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
           if(((e.getX() >= x1) && (e.getX() <= (x1+80))) &&
             ((e.getY() >= y1) && (e.getY() <= (y1+60))))  {
                flag1 = 1;
            }
           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag1 == 1)) {
                fx1 = e.getX();
                fy1 = e.getY();

                dx1 = (fx1 - x1) / 50;
                dy1 = (fy1 - y1) / 50;
                flag1 =0;
           }

           if(((e.getX() >= x2) && (e.getX() <= (x2+80))) &&
             ((e.getY() >= y2) && (e.getY() <= (y2+60))))  {
                flag2 = 1;
            }
           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag2 == 1)) {
                fx2 = e.getX();
                fy2 = e.getY();

                dx2 = (fx2 - x2) / 50;
                dy2 = (fy2 - y2) / 50;
                flag2 = 0;
           }
     }

    public void run() {
      while(true) {
         x1 = x1 + dx1;
         y1 = y1 + dy1;
         if(((dx1 > 0) && ((x1+40) >= fx1)) || ((dx1 < 0) && ((x1+40) <= fx1))) dx1 = 0;
         if(((dy1 > 0) && ((y1+30) >= fy1)) || ((dy1 < 0) && ((y1+30) <= fy1))) dy1 = 0;

         x2 = x2 + dx2;
         y2 = y2 + dy2;
         if(((dx2 > 0) && ((x2+40) >= fx2)) || ((dx2 < 0) && ((x2+40) <= fx2))) dx2 = 0;
         if(((dy2 > 0) && ((y2+30) >= fy2)) || ((dy2 < 0) && ((y2+30) <= fy2))) dy2 = 0;

         repaint();
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
        g.drawImage(img1, x1, y1, this);
        g.drawImage(img2, x2, y2, this);
    }
}





