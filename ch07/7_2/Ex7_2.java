
import java.awt.*;
import java.awt.event.*;

public class Ex7_2 extends Frame implements Runnable {

    int x=50, y=50;
    Image img;

    public static void main(String args[]) {
      Ex7_2 workStart=new Ex7_2();
    }
    
    public Ex7_2() {
        super("Ex7_2");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("img7_2.jpg");

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);

        setVisible(true);
        new Thread(this).start();
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public void processMouseEvent(MouseEvent e) {
        if(e.getID() == MouseEvent.MOUSE_PRESSED) {
            x = e.getX();
            y = e.getY();
        }
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





