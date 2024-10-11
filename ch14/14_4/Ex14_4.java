import math2D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex14_4 extends Frame implements Runnable {
    int xv1=0, yv1=0, xv2=100, yv2=100;
    int xs1, ys1, xs2, ys2;

    public static void main(String args[]) {
      Ex14_4 workStart=new Ex14_4();
    }
    
    public Ex14_4() {
        super("Ex14_4");
        setSize(350, 350);

        view_To_screen_coordinates vTs = new view_To_screen_coordinates();
        xs1 = vTs.viewX_To_screenX(xv1);
        ys1 = vTs.viewY_To_screenY(yv1);
        xs2 = vTs.viewX_To_screenX(xv2);
        ys2 = vTs.viewY_To_screenY(xv2);

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





