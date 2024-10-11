
import java.awt.*;
import java.awt.event.*;

public class Ex7_5_1 extends Frame implements Runnable {

    int x=50, y=50, fx=0, fy=0, dx=0, dy=0, flag=0;
    Image img;

    public static void main(String args[]) {
      Ex7_5_1 workStart=new Ex7_5_1();
    }
    
    public Ex7_5_1() {
        super("Ex7_5_1");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("fly.GIF");

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
           if(((e.getX() >= x) && (e.getX() <= (x+60))) &&
             ((e.getY() >= y) && (e.getY() <= (y+50))))  {
                flag = 1;
            }
  
           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag == 1)) {
                fx = e.getX();
                fy = e.getY();

                dx = (fx - x) / 10;
                dy = (fy - y) / 10;
                flag = 0;
           }
     }

    public void run() {
      while(true) {
         x = x + dx;
         y = y + dy;

         if(((dx > 0) && ((x+30) >= fx)) || ((dx < 0) && ((x+30) <= fx))) dx = 0;
         if(((dy > 0) && ((y+25) >= fy)) || ((dy < 0) && ((y+25) <= fy))) dy = 0;

         repaint();
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
        g.drawImage(img, x, y, this);
    }
}





