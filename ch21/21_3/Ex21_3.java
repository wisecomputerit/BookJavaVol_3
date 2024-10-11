import java.awt.Graphics;
import java.applet.Applet;

public class Ex21_3 extends Applet {

   public void paint(Graphics g) {
    g.drawLine(100,35,250,35);

    g.drawRect(60,70,100,50);
    g.fillRect(200,70,100,50);

    g.drawOval(30,160,80,60);
    g.drawOval(140,160,80,60);
    g.drawRect(140,160,80,60);
    g.fillOval(250,160,80,60);

    g.drawArc(30,260,80,60,10,90);
    g.drawArc(140,260,80,60,10,90);
    g.drawRect(140,260,80,60);
    g.fillArc(250,260,80,60,10,90);
  }
}