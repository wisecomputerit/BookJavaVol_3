
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex3_9 extends Frame implements Runnable {
    public static void main(String args[]) {
      Ex3_9 workStart=new Ex3_9();
    }
    
    public Ex3_9() {
        super("Ex3_9");
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
      g.copyArea(35,200,100,60,135,0);
    }
}





