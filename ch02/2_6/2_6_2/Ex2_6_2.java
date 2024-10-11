
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Ex2_6_2 extends Frame implements Runnable {
    Font messageFont1, messageFont2, messageFont3, messageFont4;
    String message;

    public static void main(String args[]) {
      Ex2_6_2 workStart=new Ex2_6_2();
    }
    
    public Ex2_6_2() {
        super("Ex2_6_2");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      messageFont1 = new Font("新細明體"+"TimesRoman", Font.PLAIN, 30);
      messageFont2 = new Font("新細明體"+"Monotype Corsiva", Font.PLAIN, 30);
      messageFont3 = new Font("Monotype Corsiva", Font.PLAIN, 30);
      messageFont4 = new Font("標楷體"+"Monotype Corsiva", Font.ITALIC + Font.PLAIN, 30);
      message = "中文字串 English String";
      repaint();
    }

    public void paint(Graphics g) {

        g.setFont(messageFont1);
        g.setColor(Color.blue);
        g.drawString(message, 5, 50);

        g.setFont(messageFont2);
        g.setColor(Color.gray);
        g.drawString(message, 5, 100);

        g.setFont(messageFont3);
        g.setColor(Color.red);
        g.drawString(message, 5, 150);

        g.setFont(messageFont4);
        g.setColor(Color.yellow);
        g.drawString(message, 5, 200);
    }
}





