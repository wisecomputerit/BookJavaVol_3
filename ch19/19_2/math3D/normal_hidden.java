package math3D;
import java.awt.*;

public class normal_hidden {
  private double Nx, Ny, Nz;

  public void vectNormal(double xa, double ya, double za,
                         double xb, double yb, double zb,
                         double xc, double yc, double zc) {

    double Ux=xa-xb; double Uy=ya-yb; double Uz=za-zb; 
    double Vx=xb-xc; double Vy=yb-yc; double Vz=zb-zc; 

    this.Nx=Uy*Vz - Uz*Vy;
    this.Ny=Uz*Vx - Ux*Vz;
    this.Nz=Ux*Vy - Uy*Vx;
  }

  public double getHidden() {return Nz;}

}