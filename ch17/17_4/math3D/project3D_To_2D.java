package math3D;
import java.awt.*;

public class project3D_To_2D {
  private double x, y;
  private double d;

  public double projectPtX(double x, double y, double z) {
    d = ((double)400/2)/(double)Math.tan(80/2);
    this.x = d*x/(d-(-z));
    return this.x;
  }

  public double projectPtY(double x, double y, double z) {
    d = ((double)400/2)/(double)Math.tan(80/2);
    this.y = d*y/(d-(-z));
    return this.y;
  }
}