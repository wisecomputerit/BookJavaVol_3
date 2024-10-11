import java.awt.Graphics;
import java.applet.*;

public class firstApplet extends Applet {
  String message = "My firstApplet WWW Program";
 
  public void paint(Graphics g){
     g.drawString(message,100,45);
  }
}
