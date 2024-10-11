
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex3_5 extends Frame implements Runnable {
    public static void main(String args[]) {
      Ex3_5 workStart=new Ex3_5();
    }
    
    public Ex3_5() {
        super("Ex3_5");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawOval(35,65,100,60);

      g.drawOval(170,65,100,60);
      g.drawRect(170,65,100,60);

      g.fillOval(35,200,100,60);
    }
}





