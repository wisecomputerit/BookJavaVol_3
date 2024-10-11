import math2D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex15_4 extends Frame implements Runnable {
  int x0=0, y0=0, xa=20, ya=40, xb=100, yb=10, xc, yc;
  int xN1, yN1, xN2, yN2;
  int x0s, y0s, xcs, ycs, xN1s, yN1s, xN2s, yN2s;

  public static void main(String args[]) {
    Ex15_4 workStart=new Ex15_4();
  }
    
  public Ex15_4() {
    super("Ex15_4");
    setSize(350, 350);

    vector_calculator vc = new vector_calculator();
    vc.setPt(xb, yb);
    vc.vectSubtract(xa, ya);
    xc = vc.getPtX();
    yc = vc.getPtY();

    xN1 = -yc;  yN1 = xc;
    xN2 = yc;   yN2 = -xc;

    view_To_screen_coordinates vTs = new view_To_screen_coordinates();
    x0s = vTs.viewX_To_screenX(x0);
    y0s = vTs.viewY_To_screenY(y0);
    xcs = vTs.viewX_To_screenX(xc);
    ycs = vTs.viewY_To_screenY(yc);
    xN1s = vTs.viewX_To_screenX(xN1);
    yN1s = vTs.viewY_To_screenY(yN1);
    xN2s = vTs.viewX_To_screenX(xN2);
    yN2s = vTs.viewY_To_screenY(yN2);

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
    g.drawLine(x0s, y0s, xcs, ycs);
    g.drawLine(x0s, y0s, xN1s, yN1s);
    g.drawLine(x0s, y0s, xN2s, yN2s);
    }
}





