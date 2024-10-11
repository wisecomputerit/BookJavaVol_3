
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex3_6 extends Frame implements Runnable {
    public static void main(String args[]) {
      Ex3_6 workStart=new Ex3_6();
    }
    
    public Ex3_6() {
        super("Ex3_6");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawArc(35,65,100,60,10,90);

      g.drawArc(170,65,100,60,10,90);
      g.drawRect(170,65,100,60);

      g.fillArc(35,200,100,60,10,90);
    }
}





