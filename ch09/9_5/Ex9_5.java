
import java.awt.*;
import java.awt.event.*;

public class Ex9_5 extends Frame implements Runnable {
    int x=150, y=235, dx, dy;
    int bx, by, dbx=0, dby=-5, bflag=0;
    Image img, bufferPage=null;

    public static void main(String args[]) {
      Ex9_5 workStart=new Ex9_5();
    }
    
    public Ex9_5() {
        super("Ex9_5");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("car090.gif");

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
                   case KeyEvent.VK_SPACE:
                          dx = 0; dy = 0;
                          bx = x + 30;
                          by = y - 5;
                          bflag = 1;
                          break;
                   default:
                          dx = 0; dy = 0;
              }
            x = x + dx;
            y = y + dy;

        }
    }

    public void run() {
      while(true) {
         if(by <= -10) bflag = 0;
         if(bflag == 1) by = by + dby;

         repaint();
         try{Thread.sleep(30);}
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

       bufferg.drawImage(img, x, y, this);
       bufferg.fillRect(bx, by, 3, 5);
       bufferg.setColor(Color.white);
       bufferg.fillRect(bx, by+5, 3, 5);

       bufferg.dispose();
       g.drawImage(bufferPage, getInsets().left, getInsets().top, this);
    }
}





