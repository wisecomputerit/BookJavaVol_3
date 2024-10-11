package math2D;
import java.awt.*;

public class rotate_calculator {
  private double x, y;
  private double sinAngle, cosAngle;

  public void rotateChange(double x, double y, double angle) {
    this.sinAngle = (double)Math.sin(angle);
    this.cosAngle = (double)Math.cos(angle);

    this.x = x*cosAngle - y*sinAngle;
    this.y = x*sinAngle + y*cosAngle;
  }

  public double getPtX() {return x;}
  public double getPtY() {return y;}
}