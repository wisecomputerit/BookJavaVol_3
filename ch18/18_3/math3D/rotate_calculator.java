package math3D;
import java.awt.*;

public class rotate_calculator {
  private double x, y, z;
  private double sinAngle, cosAngle;

  public void rotateX(double x, double y, double z, double angle) {
    this.sinAngle = (double)Math.sin(angle);
    this.cosAngle = (double)Math.cos(angle);
    this.y = y*cosAngle - z*sinAngle;
    this.z = y*sinAngle + z*cosAngle;
    this.x = x;
  }

  public void rotateY(double x, double y, double z, double angle) {
    this.sinAngle = (double)Math.sin(angle);
    this.cosAngle = (double)Math.cos(angle);
    this.z = z*cosAngle - x*sinAngle;
    this.x = z*sinAngle + x*cosAngle;
    this.y = y;
  }

  public void rotateZ(double x, double y, double z, double angle) {
    this.sinAngle = (double)Math.sin(angle);
    this.cosAngle = (double)Math.cos(angle);
    this.x = x*cosAngle - y*sinAngle;
    this.y = x*sinAngle + y*cosAngle;
    this.z = z;
  }

  public double getPtX() {return x;}
  public double getPtY() {return y;}
  public double getPtZ() {return z;}
}