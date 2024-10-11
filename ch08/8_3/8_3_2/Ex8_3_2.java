
import java.awt.*;
import java.awt.event.*;

public class Ex8_3_2 extends Frame implements Runnable {
    int x=150, y=235, dx=0, dy=0, flag_direction=0;
    Image img0, img1, img2, img3;

    public static void main(String args[]) {
      Ex8_3_2 workStart=new Ex8_3_2();
    }
    
    public Ex8_3_2() {
        super("Ex8_3_2");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img0 = tk.getImage("img000.JPG");
        img1 = tk.getImage("img090.JPG");
        img2 = tk.getImage("img180.JPG");
        img3 = tk.getImage("img270.JPG");

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

    public void run() {
      while(true) {
         repaint();
         try{Thread.sleep(10);}
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





