
import java.awt.*;
import java.awt.event.*;

public class Ex7_5_2 extends Frame implements Runnable {

    int x=50, y=50, fx=0, fy=0, dx=0, dy=0;
    int flag_type_img=0, flag_num_img=0, num=0;
    Image img0, img1, img2;

    public static void main(String args[]) {
      Ex7_5_2 workStart=new Ex7_5_2();
    }
    
    public Ex7_5_2() {
        super("Ex7_5_2");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img0 = tk.getImage("fly0.GIF");
        img1 = tk.getImage("fly1.GIF");
        img2 = tk.getImage("fly2.GIF");

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);

        setVisible(true);
        new Thread(this).start();
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public void processMouseEvent(MouseEvent e) {
        if(e.getID() == MouseEvent.MOUSE_PRESSED)
           if(((e.getX() >= x) && (e.getX() <= (x+80))) &&
             ((e.getY() >= y) && (e.getY() <= (y+60))))  {
                flag_type_img = 1;
            }
  
           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag_type_img == 1)) {
                fx = e.getX();
                fy = e.getY();

                dx = (fx - x) / 10;
                dy = (fy - y) / 10;
                flag_type_img = 0;
           }
     }

    public void run() {
      while(true) {
         x = x + dx;
         y = y + dy;

         flag_num_img = num % 3;

         if(((dx > 0) && ((x+40) >= fx)) || ((dx < 0) && ((x+40) <= fx))) dx = 0;
         if(((dy > 0) && ((y+30) >= fy)) || ((dy < 0) && ((y+30) <= fy))) dy = 0;

         repaint();
         num = num + 1;
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
      if(flag_num_img == 0) g.drawImage(img0, x, y, this);
      if(flag_num_img == 1) g.drawImage(img1, x, y, this);
      if(flag_num_img == 2) g.drawImage(img2, x, y, this);
    }
}





