
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Ex22_5_1 extends Applet implements Runnable {
    int x=150, y=235, dx=0, dy=0, flag_direction=0;
    Image img0, img1, img2, img3;

    public void init() {
      img0 = getImage(getDocumentBase(), "img000.JPG");
      img1 = getImage(getDocumentBase(), "img090.JPG");
      img2 = getImage(getDocumentBase(), "img180.JPG");
      img3 = getImage(getDocumentBase(), "img270.JPG");
      enableEvents(AWTEvent.KEY_EVENT_MASK);
    }
    
    public void processKeyEvent(KeyEvent e) {
        if(e.getID() == KeyEvent.KEY_PRESSED) {
              switch(e.getKeyCode()) {
                   case KeyEvent.VK_RIGHT:
                          dx = 5; dy = 0;
                          flag_direction = 0;
                          break;
                   case KeyEvent.VK_LEFT:
                          dx = -5; dy = 0;
                          flag_direction = 2;
                          break;
                   case KeyEvent.VK_UP:
                          dx = 0; dy = -5; 
                          flag_direction = 1;
                          break;
                   case KeyEvent.VK_DOWN:
                          dx = 0; dy = 5;
                          flag_direction = 3;
                          break;
              }
            x = x + dx;
            y = y + dy;

        }
    }

    public void start() {
      new Thread(this).start();
    }

    public void run() {
      while(true) {
         repaint();
         try{Thread.sleep(150);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
       if(flag_direction == 0) g.drawImage(img0, x, y, this);
       if(flag_direction == 1) g.drawImage(img1, x, y, this);
       if(flag_direction == 2) g.drawImage(img2, x, y, this);
       if(flag_direction == 3) g.drawImage(img3, x, y, this);
    }
}





