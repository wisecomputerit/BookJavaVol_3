
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex4_4_1 extends Frame implements Runnable {
    Image image;

    public static void main(String args[]) {
      Ex4_4_1 workStart=new Ex4_4_1();
    }
    
    public Ex4_4_1() {
        super("Ex4_4_1");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        image = tk.getImage("Sunset.jpg");

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawImage(image, 0, 0, this);
    }
}





