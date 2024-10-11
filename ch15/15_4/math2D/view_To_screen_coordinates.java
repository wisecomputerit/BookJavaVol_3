package math2D;
import java.awt.*;

public class view_To_screen_coordinates {

  public int viewX_To_screenX(int x) {
    return x + 350/2;
  }

  public int viewY_To_screenY(int y) {
    return -y + 350/2;
  }
}