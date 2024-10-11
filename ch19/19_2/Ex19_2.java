import math3D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex19_2 extends Frame implements Runnable {
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
  rotate_calculator rc = new rotate_calculator();

  normal_hidden P1 = new normal_hidden(); 
  normal_hidden P2 = new normal_hidden();
  normal_hidden P3 = new normal_hidden();
  normal_hidden P4 = new normal_hidden();
  normal_hidden P5 = new normal_hidden();
  normal_hidden P6 = new normal_hidden();

  public static void main(String args[]) {
    Ex19_2 workStart=new Ex19_2();
  }
    
  public Ex19_2() {
    super("Ex19_2");
    setSize(400, 400);

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
    while(true) {
      rc.rotateY(xa,ya,za, 0.03);
      xa=rc.getPtX(); ya=rc.getPtY(); za=rc.getPtZ();
      rc.rotateY(xb,yb,zb, 0.03);
      xb=rc.getPtX(); yb=rc.getPtY(); zb=rc.getPtZ();
      rc.rotateY(xc,yc,zc, 0.03);
      xc=rc.getPtX(); yc=rc.getPtY(); zc=rc.getPtZ();
      rc.rotateY(xd,yd,zd, 0.03);
      xd=rc.getPtX(); yd=rc.getPtY(); zd=rc.getPtZ();
      rc.rotateY(xe,ye,ze, 0.03);
      xe=rc.getPtX(); ye=rc.getPtY(); ze=rc.getPtZ();
      rc.rotateY(xf,yf,zf, 0.03);
      xf=rc.getPtX(); yf=rc.getPtY(); zf=rc.getPtZ();
      rc.rotateY(xg,yg,zg, 0.03);
      xg=rc.getPtX(); yg=rc.getPtY(); zg=rc.getPtZ();
      rc.rotateY(xh,yh,zh, 0.03);
      xh=rc.getPtX(); yh=rc.getPtY(); zh=rc.getPtZ();

      P1.vectNormal(xd, yd, zd, xa, ya, za, xe, ye, ze);
      P2.vectNormal(xc, yc, zc, xd, yd, zd, xh, yh, zh);
      P3.vectNormal(xb, yb, zb, xc, yc, zc, xg, yg, zg);
      P4.vectNormal(xa, ya, za, xb, yb, zb, xf, yf, zf);
      P5.vectNormal(xc, yc, zc, xb, yb, zb, xa, ya, za);
      P6.vectNormal(xh, yh, zh, xe, ye, ze, xf, yf, zf);
 
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

      repaint();
      try{Thread.sleep(150);}
      catch(InterruptedException e) {;}
    }
  }

  public void paint(Graphics g) {
    g.setColor(new Color(225,225,225));
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

    g.setColor(new Color(0,0,0));
    if (P1.getHidden() > 0.0) {
      g.drawLine(xds, yds, xas, yas);
      g.drawLine(xas, yas, xes, yes);
      g.drawLine(xes, yes, xhs, yhs);
      g.drawLine(xhs, yhs, xds, yds);
    }

    if (P2.getHidden() > 0.0) {
      g.drawLine(xcs, ycs, xds, yds);
      g.drawLine(xds, yds, xhs, yhs);
      g.drawLine(xhs, yhs, xgs, ygs);
      g.drawLine(xgs, ygs, xcs, ycs);
    }

    if (P3.getHidden() > 0.0) {
      g.drawLine(xbs, ybs, xcs, ycs);
      g.drawLine(xcs, ycs, xgs, ygs);
      g.drawLine(xgs, ygs, xfs, yfs);
      g.drawLine(xfs, yfs, xbs, ybs);
    }

    if (P4.getHidden() > 0.0) {
      g.drawLine(xas, yas, xbs, ybs);
      g.drawLine(xbs, ybs, xfs, yfs);
      g.drawLine(xfs, yfs, xes, yes);
      g.drawLine(xes, yes, xas, yas);
    }

    if (P5.getHidden() > 0.0) {
      g.drawLine(xcs, ycs, xbs, ybs);
      g.drawLine(xbs, ybs, xas, yas);
      g.drawLine(xas, yas, xds, yds);
      g.drawLine(xds, yds, xcs, ycs);
    }

    if (P6.getHidden() > 0.0) {
      g.drawLine(xhs, yhs, xes, yes);
      g.drawLine(xes, yes, xfs, yfs);
      g.drawLine(xfs, yfs, xgs, ygs);
      g.drawLine(xgs, ygs, xhs, yhs);
    }
  }
}





