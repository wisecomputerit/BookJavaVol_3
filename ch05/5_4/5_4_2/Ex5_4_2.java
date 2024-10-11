
import java.awt.*;
import java.awt.event.*;

public class Ex5_4_2 extends Frame implements Runnable {
    int num=0, flag, i;
    int x=0, y=100, dx=5, dy=5;
    Image[] img;

    public static void main(String args[]) {
      Ex5_4_2 workStart=new Ex5_4_2();
    }
    
    public Ex5_4_2() {
        super("Ex5_4_2");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = new Image[3];
        for(i=0; i<3; i++) {
           img[i] = tk.getImage("fly" + i + ".gif");
        }

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      while(true) {
         x = x + dx;
         y = y + dy;
         flag = num % 3;
         repaint();
         num = num + 1;         

         if(x <= 0) dx = 5;
         else if((x+60) >= 350) dx = -5;

         if(y<=0) dy = 5;
         else if((y + 50) >= getHeight()) dy = -5;
 
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
        g.drawImage(img[flag], x, y, this);
    }
}





