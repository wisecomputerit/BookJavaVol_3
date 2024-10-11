import math2D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex16_3 extends Frame implements Runnable {
  double xa=20, ya=40, xb=30, yb=10, xc=100, yc=20, xd=80, yd=60;
  int xam, yam, xbm, ybm, xcm, ycm, xdm, ydm;
  int xas, yas, xbs, ybs, xcs, ycs, xds, yds;

  view_To_screen_coordinates vTs = new view_To_screen_coordinates();
  rotate_calculator rc = new rotate_calculator();

  public static void main(String args[]) {
    Ex16_3 workStart=new Ex16_3();
  }
    
  public Ex16_3() {
    super("Ex16_3");
    setSize(350, 350);

    enableEvents(AWTEvent.WINDOW_EVENT_MASK);

    xam=(int)xa; yam=(int)ya;
    xbm=(int)xb; ybm=(int)yb;
    xcm=(int)xc; ycm=(int)yc;
    xdm=(int)xd; ydm=(int)yd;

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
      rc.rotateChange(xa,ya,0.03);
      xa=rc.getPtX(); ya=rc.getPtY();

      rc.rotateChange(xb,yb,0.03);
      xb=rc.getPtX(); yb=rc.getPtY();

      rc.rotateChange(xc,yc,0.03);
      xc=rc.getPtX(); yc=rc.getPtY();

      rc.rotateChange(xd,yd,0.03);
      xd=rc.getPtX(); yd=rc.getPtY();

      xam=(int)xa; yam=(int)ya;
      xbm=(int)xb; ybm=(int)yb;
      xcm=(int)xc; ycm=(int)yc;
      xdm=(int)xd; ydm=(int)yd;

      xas = vTs.viewX_To_screenX(xam);
      yas = vTs.viewY_To_screenY(yam);
      xbs = vTs.viewX_To_screenX(xbm);
      ybs = vTs.viewY_To_screenY(ybm);
      xcs = vTs.viewX_To_screenX(xcm);
      ycs = vTs.viewY_To_screenY(ycm);
      xds = vTs.viewX_To_screenX(xdm);
      yds = vTs.viewY_To_screenY(ydm);

      repaint();
      try{Thread.sleep(150);}
      catch(InterruptedException e) {;}
    }
  }

  public void paint(Graphics g) {
    int pgx[] = {xas, xbs, xcs, xds};
    int pgy[] = {yas, ybs, ycs, yds};
    g.drawPolygon(pgx, pgy, 4);
  }
}





