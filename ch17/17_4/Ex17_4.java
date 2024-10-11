import math3D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex17_4 extends Frame implements Runnable {
  double xa=-50, ya=50, za=50, xb=-50, yb=50, zb=-50;
  double xc=50, yc=50, zc=-50, xd=50, yd=50, zd=50;
  double xe=-50, ye=-50, ze=50, xf=-50, yf=-50, zf=-50;
  double xg=50, yg=-50, zg=-50, xh=50, yh=-50, zh=50;

  int xam, yam, xbm, ybm, xcm, ycm, xdm, ydm;
  int xem, yem, xfm, yfm, xgm, ygm, xhm, yhm;

  int xas, yas, xbs, ybs, xcs, ycs, xds, yds;
  int xes, yes, xfs, yfs, xgs, ygs, xhs, yhs;

  view_To_screen_coordinates vTs = new view_To_screen_coordinates();
  project3D_To_2D pr = new project3D_To_2D();

  public static void main(String args[]) {
    Ex17_4 workStart=new Ex17_4();
  }
    
  public Ex17_4() {
    super("Ex17_4");
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

    xem = (int)pr.projectPtX(xe,ye,ze);
    yem = (int)pr.projectPtY(xe,ye,ze);

    xfm = (int)pr.projectPtX(xf,yf,zf);
    yfm = (int)pr.projectPtY(xf,yf,zf);

    xgm = (int)pr.projectPtX(xg,yg,zg);
    ygm = (int)pr.projectPtY(xg,yg,zg);

    xhm = (int)pr.projectPtX(xh,yh,zh);
    yhm = (int)pr.projectPtY(xh,yh,zh);

    xas = vTs.viewX_To_screenX(xam);
    yas = vTs.viewY_To_screenY(yam);

    xbs = vTs.viewX_To_screenX(xbm);
    ybs = vTs.viewY_To_screenY(ybm);

    xcs = vTs.viewX_To_screenX(xcm);
    ycs = vTs.viewY_To_screenY(ycm);

    xds = vTs.viewX_To_screenX(xdm);
    yds = vTs.viewY_To_screenY(ydm);

    xes = vTs.viewX_To_screenX(xem);
    yes = vTs.viewY_To_screenY(yem);

    xfs = vTs.viewX_To_screenX(xfm);
    yfs = vTs.viewY_To_screenY(yfm);

    xgs = vTs.viewX_To_screenX(xgm);
    ygs = vTs.viewY_To_screenY(ygm);

    xhs = vTs.viewX_To_screenX(xhm);
    yhs = vTs.viewY_To_screenY(yhm);

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
    g.drawLine(xas, yas, xbs, ybs);
    g.drawLine(xbs, ybs, xcs, ycs);
    g.drawLine(xcs, ycs, xds, yds);
    g.drawLine(xds, yds, xas, yas);

    g.drawLine(xes, yes, xfs, yfs);
    g.drawLine(xfs, yfs, xgs, ygs);
    g.drawLine(xgs, ygs, xhs, yhs);
    g.drawLine(xhs, yhs, xes, yes);

    g.drawLine(xas, yas, xes, yes);
    g.drawLine(xbs, ybs, xfs, yfs);
    g.drawLine(xcs, ycs, xgs, ygs);
    g.drawLine(xds, yds, xhs, yhs);
  }
}





