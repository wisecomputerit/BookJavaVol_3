
import java.awt.*;
import java.awt.event.*;

public class Ex8_4_1 extends Frame implements Runnable {
    int x=0, y=100;
    int dx=0, dy=0;
    Image img;

    public static void main(String args[]) {
      Ex8_4_1 workStart=new Ex8_4_1();
    }
    
    public Ex8_4_1() {
      super("Ex8_4_1");
      setSize(350, 350);

      Toolkit tk = Toolkit.getDefaultToolkit();
      img = tk.getImage("fly.gif");

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





