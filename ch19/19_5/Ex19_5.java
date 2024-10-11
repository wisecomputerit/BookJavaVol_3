import math3D.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex19_5 extends Frame implements Runnable {
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
    Ex19_5 workStart=new Ex19_5();
  }
    
  public Ex19_5() {
    super("Ex19_5");
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
    int P1_cf = (int)P1.getHidden()/52;
    int Xdaeh[] = {xds, xas, xes, xhs};
    int Ydaeh[] = {yds, yas, yes, yhs};
    int Ndaeh = 4;

    int P2_cf = (int)P2.getHidden()/52;
    int Xcdhg[] = {xcs, xds, xhs, xgs};
    int Ycdhg[] = {ycs, yds, yhs, ygs};
    int Ncdhg = 4;

    int P3_cf = (int)P3.getHidden()/52;
    int Xbcgf[] = {xbs, xcs, xgs, xfs};
    int Ybcgf[] = {ybs, ycs, ygs, yfs};
    int Nbcgf = 4;

    int P4_cf = (int)P4.getHidden()/52;
    int Xabfe[] = {xas, xbs, xfs, xes};
    int Yabfe[] = {yas, ybs, yfs, yes};
    int Nabfe = 4;

    int P5_cf = (int)P5.getHidden()/52;
    int Xadcb[] = {xas, xds, xcs, xbs};
    int Yadcb[] = {yas, yds, ycs, ybs};
    int Nadcb = 4;

    int P6_cf = (int)P6.getHidden()/52;
    int Xhefg[] = {xhs, xes, xfs, xgs};
    int Yhefg[] = {xhs, xes, xfs, xgs};
    int Nhefg = 4;

    if (P1.getHidden() > 2400.0) {
       g.setColor(new Color(P1_cf, P1_cf, P1_cf));
       g.fillPolygon(Xdaeh, Ydaeh, Ndaeh);
    }

    if (P2.getHidden() > 2400.0) {
       g.setColor(new Color(P2_cf, P2_cf, P2_cf));
       g.fillPolygon(Xcdhg, Ycdhg, Ncdhg);
    }

    if (P3.getHidden() > 2400.0)  {
       g.setColor(new Color(P3_cf, P3_cf, P3_cf));
       g.fillPolygon(Xbcgf, Ybcgf, Nbcgf);
    }

    if (P4.getHidden() > 2400.0) {
       g.setColor(new Color(P4_cf, P4_cf, P4_cf));
       g.fillPolygon(Xabfe, Yabfe, Nabfe);
    }

    if (P5.getHidden() > 2400.0) {
       g.setColor(new Color(P5_cf, P5_cf, P5_cf));
       g.fillPolygon(Xadcb, Yadcb, Nadcb);
    }

    if (P6.getHidden() > 2400.0) {
       g.setColor(new Color(P6_cf, P6_cf, P6_cf));
       g.fillPolygon(Xhefg, Yhefg, Nhefg);
    }
  }
}





