
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex14_3 extends Frame implements Runnable {
    int xv1=0, yv1=0, xv2=100, yv2=100;
    int xs1, ys1, xs2, ys2;

    public static void main(String args[]) {
      Ex14_3 workStart=new Ex14_3();
    }
    
    public Ex14_3() {
        super("Ex14_3");
        setSize(350, 350);

        xs1 = 350/2;
        ys1 = 350/2;
        
        xs2 = xv2 + 350/2;
        ys2 = -yv2 + 350/2;

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
      repaint();
    }

    public void paint(Graphics g) {
      g.drawLine(xs1, ys1, xs2, ys2);
    }
}





