
import java.awt.*;
import java.applet.*;

public class Ex22_3_1 extends Applet implements Runnable {
    int x=0, y=100;
    int dx=5, dy=5;
    Image img;

    public void init() {
      img = getImage(getDocumentBase(), "fly.gif");
    }
    
    public void start() {
      new Thread(this).start();
    }

    public void run() {
      while(true) {
        x = x + dx;
        y = y + dy;
        repaint();

        if(x<=0) dx = 5;
        else if((x + 50) >= getWidth()) dx = -5;

        if(y<=0) dy = 5;
        else if((y + 50) >= getHeight()) dy = -5;

        try{Thread.sleep(250);}
        catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
       g.drawImage(img, x, y, this);
    }
}





