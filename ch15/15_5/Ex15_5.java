import math2D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex15_5 extends Frame implements Runnable {
  int xa=20, ya=40, xb=30, yb=10, xc=100, yc=20, xd=80, yd=60;
  int xas, yas, xbs, ybs, xcs, ycs, xds, yds; 

  public static void main(String args[]) {
    Ex15_5 workStart=new Ex15_5();
  }
    
  public Ex15_5() {
    super("Ex15_5");
    setSize(350, 350);

    view_To_screen_coordinates vTs = new view_To_screen_coordinates();
    xas = vTs.viewX_To_screenX(xa);
    yas = vTs.viewY_To_screenY(ya);
    xbs = vTs.viewX_To_screenX(xb);
    ybs = vTs.viewY_To_screenY(yb);
    xcs = vTs.viewX_To_screenX(xc);
    ycs = vTs.viewY_To_screenY(yc);
    xds = vTs.viewX_To_screenX(xd);
    yds = vTs.viewY_To_screenY(yd);

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
    int pgx[] = {xas,xbs,xcs,xds};
    int pgy[] = {yas,ybs,ycs,yds};

    g.fillPolygon(pgx, pgy, 4);
    }
}





