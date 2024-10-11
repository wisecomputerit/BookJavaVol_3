
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Ex2_6_1 extends Frame implements Runnable {
    Font messageFont1;
    Font messageFont2;
    String message;

    public static void main(String args[]) {
      Ex2_6_1 workStart=new Ex2_6_1();
    }
    
    public Ex2_6_1() {
        super("Ex2_6_1");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      messageFont1 = new Font("新細明體", Font.PLAIN, 30);
      messageFont2 = new Font("標楷體", Font.PLAIN, 30);
      message = "中文字串";
      repaint();
    }

    public void paint(Graphics g) {
        g.setFont(messageFont1);
        g.setColor(Color.blue);
        g.drawString(message, 5, 50);

        g.setFont(messageFont2);
        g.setColor(Color.green);
        g.drawString(message, 5, 100);
    }
}





