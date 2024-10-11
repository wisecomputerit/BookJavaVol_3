
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex3_8 extends Frame implements Runnable {
    int[] pgx = {90,130,180,230,180,130,90};
    int[] pgy = {100,60,60,100,150,150,100};
    int pgn = 7;

    int[] fpgx = {90,130,180,230,180,130,90};
    int[] fpgy = {250,210,210,250,300,300,250};
    int fpgn = 7;

    public static void main(String args[]) {
      Ex3_8 workStart=new Ex3_8();
    }
    
    public Ex3_8() {
        super("Ex3_8");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawRect(100,80,120,50);
      g.drawPolygon(pgx, pgy, pgn);

      g.clipRect(100,230,120,50);
      g.fillPolygon(fpgx, fpgy, fpgn);
    }
}





