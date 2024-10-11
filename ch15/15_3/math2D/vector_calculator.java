package math2D;
import java.awt.*;

public class vector_calculator {
  private int x, y;

  public void setPt(int x, int y) {
     this.x = x; this.y = y;
  }

  public void vectAdd(int x, int y) {
     this.x += x; this.y += y;
  }

  public void vectSubtract(int x, int y) {
     this.x -= x; this.y -= y;
  }

  public void vectMultiply(int x, int y) {
     this.x *= x; this.y *= y;
  }

  public void vectDivide(int x, int y) {
     this.x /= x; this.y /= y;
  }

  public int getPtX() {return x;}
  public int getPtY() {return y;}
}