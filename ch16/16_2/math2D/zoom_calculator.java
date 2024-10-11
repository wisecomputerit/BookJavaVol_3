package math2D;
import java.awt.*;

public class zoom_calculator {
  private double x, y;

  public void zoomChange(double x, double y, double zf) {
     this.x = x * zf;
     this.y = y * zf;
  }

  public double getPtX() {return x;}
  public double getPtY() {return y;}
}