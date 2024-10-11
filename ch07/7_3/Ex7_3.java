
import java.awt.*;
import java.awt.event.*;

public class Ex7_3 extends Frame implements Runnable {

    int x=50, y=50, flag=0;
    Image img;

    public static void main(String args[]) {
      Ex7_3 workStart=new Ex7_3();
    }
    
    public Ex7_3() {
        super("Ex7_3");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("img7_3.jpg");

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
           if(((e.getX() >= x) && (e.getX() <= (x+40))) &&
             ((e.getY() >= y) && (e.getY() <= (y+40))))  {
                flag = 1;
            }
  
           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag == 1)) {
                x = e.getX();
                y = e.getY();
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
        g.drawImage(img, x, y, this);
    }
}





