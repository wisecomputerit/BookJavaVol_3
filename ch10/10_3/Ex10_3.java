
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Ex10_3 extends Frame implements Runnable {
    int num=0, flag;
    int x=0, y=100, dx=5, dy=5;
    Image img0, img1, img2, bufferPage = null;
    AudioClip sound;

    public static void main(String args[]) {
      Ex10_3 workStart=new Ex10_3();
    }
    
    public Ex10_3() {
        super("Ex10_3");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img0 = tk.getImage("fly0.gif");
        img1 = tk.getImage("fly1.gif");
        img2 = tk.getImage("fly2.gif");

        sound = Applet.newAudioClip(getClass().getResource("sound.au"));
        sound.loop();

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);

        setVisible(true);
        new Thread(this).start();
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
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

   public void update(Graphics g) {
       paint(g);
   }

    public void paint(Graphics g) {
       Graphics bufferg;
       if(bufferPage == null)
          bufferPage = createImage(350, 350);
       bufferg = bufferPage.getGraphics();

       if(flag == 0)
          bufferg.drawImage(img0, x, y, this);
       else if(flag == 1)
          bufferg.drawImage(img1, x, y, this);
       else if(flag == 2)
          bufferg.drawImage(img2, x, y, this);
        
       bufferg.dispose();
       g.drawImage(bufferPage, getInsets().left, getInsets().top, this);
    }
}





