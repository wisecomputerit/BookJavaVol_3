
import java.awt.*;
import java.applet.*;

public class Ex22_3_2 extends Applet implements Runnable {
    int num=0, flag;
    int x=0, y=100, dx=5, dy=5;
    Image img0, img1, img2;

    public void init() {
      img0 = getImage(getDocumentBase(), "fly0.gif");
      img1 = getImage(getDocumentBase(), "fly1.gif");
      img2 = getImage(getDocumentBase(), "fly2.gif");
    }
    
    public void start() {
      new Thread(this).start();
    }

    public void run() {
      while(true) {
         x = x + dx;
         y = y + dy;
         flag = num % 3;
         repaint();
         num = num + 1;         

         if(x <= 0) dx = 5;
         else if((x+60) >= 350) dx = -5;

         if(y<=0) dy = 5;
         else if((y + 50) >= getHeight()) dy = -5;
 
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
       if(flag == 0)
          g.drawImage(img0, x, y, this);
       else if(flag == 1)
          g.drawImage(img1, x, y, this);
       else if(flag == 2)
          g.drawImage(img2, x, y, this);
    }
}





