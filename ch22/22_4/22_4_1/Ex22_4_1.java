
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Ex22_4_1 extends Applet implements Runnable {

    int x=50, y=50;
    Image img;

    public void init() {
      img = getImage(getDocumentBase(), "imgBoy.jpg");
      enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    
    public void processMouseEvent(MouseEvent e) {
        if(e.getID() == MouseEvent.MOUSE_PRESSED) {
            x = e.getX();
            y = e.getY();
        }
    }

    public void start() {
      new Thread(this).start();
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





