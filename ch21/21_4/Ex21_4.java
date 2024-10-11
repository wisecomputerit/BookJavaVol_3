import java.awt.Graphics;
import java.awt.Image;
import java.applet.Applet;

public class Ex21_4 extends Applet {
  Image Img;
	
  public void init() {
    Img = getImage(getDocumentBase(), "pic.JPG");
  }
	
  public void paint(Graphics g) {
    g.drawImage(Img, 170, 170, this);

  }
}
