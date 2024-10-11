
import java.awt.*;
import java.awt.event.*;

public class Ex9_3_1 extends Frame implements Runnable {
    int x=0, y=100;
    int dx=5, dy=5;
    Image img, bufferPage=null;

    public static void main(String args[]) {
      Ex9_3_1 workStart=new Ex9_3_1();
    }
    
    public Ex9_3_1() {
      super("Ex9_3_1");
      setSize(350, 350);

      Toolkit tk = Toolkit.getDefaultToolkit();
      img = tk.getImage("fly.gif");

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
        repaint();

        if(x<=0) dx = 5;
        else if((x + 50) >= getWidth()) dx = -5;

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
       bufferg =bufferPage.getGraphics();

       bufferg.drawImage(img, x, y, this);

       bufferg.dispose();
       g.drawImage(bufferPage, getInsets().left, getInsets().top, this);
    }
}





