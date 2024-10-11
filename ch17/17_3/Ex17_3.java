import math3D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex17_3 extends Frame implements Runnable {
  double xa=-50, ya=50, za=50, xb=-50, yb=50, zb=-50;
  double xc=50, yc=50, zc=-50, xd=50, yd=50, zd=50;
  int xam, yam, xbm, ybm, xcm, ycm, xdm, ydm;
  int xas, yas, xbs, ybs, xcs, ycs, xds, yds;

  view_To_screen_coordinates vTs = new view_To_screen_coordinates();
  project3D_To_2D pr = new project3D_To_2D();

  public static void main(String args[]) {
    Ex17_3 workStart=new Ex17_3();
  }
    
  public Ex17_3() {
    super("Ex17_3");
    setSize(400, 400);

    enableEvents(AWTEvent.WINDOW_EVENT_MASK);

    xam = (int)pr.projectPtX(xa,ya,za);
    yam = (int)pr.projectPtY(xa,ya,za);

    xbm = (int)pr.projectPtX(xb,yb,zb);
    ybm = (int)pr.projectPtY(xb,yb,zb);

    xcm = (int)pr.projectPtX(xc,yc,zc);
    ycm = (int)pr.projectPtY(xc,yc,zc);

    xdm = (int)pr.projectPtX(xd,yd,zd);
    ydm = (int)pr.projectPtY(xd,yd,zd);

    xas = vTs.viewX_To_screenX(xam);
    yas = vTs.viewY_To_screenY(yam);

    xbs = vTs.viewX_To_screenX(xbm);
    ybs = vTs.viewY_To_screenY(ybm);

    xcs = vTs.viewX_To_screenX(xcm);
    ycs = vTs.viewY_To_screenY(ycm);

    xds = vTs.viewX_To_screenX(xdm);
    yds = vTs.viewY_To_screenY(ydm);

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
    int pgx[] = {xas, xbs, xcs, xds};
    int pgy[] = {yas, ybs, ycs, yds};
    g.drawPolygon(pgx, pgy, 4);
  }
}





