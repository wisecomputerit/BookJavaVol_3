
import java.awt.*;
import java.awt.event.*;

public class Ex8_4_2 extends Frame implements Runnable {
    int x=0, y=170, dx=0, dy=0;
    int num=1, flag;
    Image img0, img1, img2;

    public static void main(String args[]) {
      Ex8_4_2 workStart=new Ex8_4_2();
    }
    
    public Ex8_4_2() {
        super("Ex8_4_2");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img0 = tk.getImage("fly0.gif");
        img1 = tk.getImage("fly1.gif");
        img2 = tk.getImage("fly2.gif");

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        enableEvents(AWTEvent.KEY_EVENT_MASK);

        setVisible(true);
        new Thread(this).start();
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public void processKeyEvent(KeyEvent e) {
        if(e.getID() == KeyEvent.KEY_PRESSED) {
              switch(e.getKeyCode()) {
                   case KeyEvent.VK_RIGHT:
                          dx = 5; dy = 0;
                          break;
                   case KeyEvent.VK_LEFT:
                          dx = -5; dy = 0;
                          break;
                   case KeyEvent.VK_UP:
                          dx = 0; dy = -5; 
                          break;
                   case KeyEvent.VK_DOWN:
                          dx = 0; dy = 5;
                          break;
              }
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
         if((y-10) <= 0) dy = 5;
         else if((y+50) >= 350) dy = -5;
 
         try{Thread.sleep(170);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
      if(flag == 0)  g.drawImage(img0, x, y, this);
      if(flag == 1)  g.drawImage(img1, x, y, this);
      if(flag == 2)  g.drawImage(img2, x, y, this);
    }
}





