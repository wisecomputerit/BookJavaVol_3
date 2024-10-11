import math2D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex15_3 extends Frame implements Runnable {
  int x0=0, y0=0, xa=20, ya=40, xb=100, yb=10, xc, yc;
  int x0s, y0s, xas, yas, xbs, ybs, xcs, ycs;

  public static void main(String args[]) {
    Ex15_3 workStart=new Ex15_3();
  }
    
  public Ex15_3() {
    super("Ex15_3");
    setSize(350, 350);

    vector_calculator vc = new vector_calculator();
    vc.setPt(xa, ya);
    vc.vectAdd(xb, yb);
    xc = vc.getPtX();
    yc = vc.getPtY();

    view_To_screen_coordinates vTs = new view_To_screen_coordinates();
    x0s = vTs.viewX_To_screenX(x0);
    y0s = vTs.viewY_To_screenY(y0);
    xas = vTs.viewX_To_screenX(xa);
    yas = vTs.viewY_To_screenY(ya);
    xbs = vTs.viewX_To_screenX(xb);
    ybs = vTs.viewY_To_screenY(yb);
    xcs = vTs.viewX_To_screenX(xc);
    ycs = vTs.viewY_To_screenY(yc);

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
    g.drawLine(x0s, y0s, xas, yas);
    g.drawLine(x0s, y0s, xbs, ybs);
    g.drawLine(x0s, y0s, xcs, ycs);
    }
}





