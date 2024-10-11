
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex3_3 extends Frame implements Runnable {
    public static void main(String args[]) {
      Ex3_3 workStart=new Ex3_3();
    }
    
    public Ex3_3() {
        super("Ex3_3");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawLine(50,50,120,100);

      g.drawLine(10,250,50,200);
      g.drawLine(50,200,120,270);
      g.drawLine(120,270,200,160);
    }
}





