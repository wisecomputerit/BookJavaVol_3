import math2D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex16_2 extends Frame implements Runnable {
  double xa=20, ya=40, xb=30, yb=10, xc=100, yc=20, xd=80, yd=60;
  int xam, yam, xbm, ybm, xcm, ycm, xdm, ydm;
  int xas, yas, xbs, ybs, xcs, ycs, xds, yds;
  double zf=1;

  view_To_screen_coordinates vTs = new view_To_screen_coordinates();
  zoom_calculator zc = new zoom_calculator();

  public static void main(String args[]) {
    Ex16_2 workStart=new Ex16_2();
  }
    
  public Ex16_2() {
    super("Ex16_2");
    setSize(350, 350);

    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    enableEvents(AWTEvent.KEY_EVENT_MASK);

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

  public void processKeyEvent(KeyEvent e) {
    if(e.getID() == KeyEvent.KEY_PRESSED) {
      switch(e.getKeyCode()) {
         case KeyEvent.VK_UP:
              if(zf<1) zf = 1;
              zf = zf + 0.01;
              break;
         case KeyEvent.VK_DOWN:
              if(zf>0) zf = 1;
              zf = zf - 0.01;
              break;
       }
       zc.zoomChange(xa,ya,zf);
       xa=zc.getPtX(); ya=zc.getPtY();

       zc.zoomChange(xb,yb,zf);
       xb=zc.getPtX(); yb=zc.getPtY();

       zc.zoomChange(xc,yc,zf);
       xc=zc.getPtX(); yc=zc.getPtY();

       zc.zoomChange(xd,yd,zf);
       xd=zc.getPtX(); yd=zc.getPtY();

       xam=(int)xa; yam=(int)ya;
       xbm=(int)xb; ybm=(int)yb;
       xcm=(int)xc; ycm=(int)yc;
       xdm=(int)xd; ydm=(int)yd;
     }
  }

  public void run() {
    while(true) {
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





