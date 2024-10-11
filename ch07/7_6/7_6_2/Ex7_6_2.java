
import java.awt.*;
import java.awt.event.*;

public class Ex7_6_2 extends Frame implements Runnable {

    int x1=50, y1=50, fx1=0, fy1=0, dx1=0, dy1=0;
    int flag1_type_img=0, flag1_num_img=0, num1=0;
    Image img10, img11, img12;

    int x2=100, y2=100, fx2=0, fy2=0, dx2=0, dy2=0;
    int flag2_type_img=0, flag2_num_img=0, num2=0;
    Image img20, img21, img22;

    public static void main(String args[]) {
      Ex7_6_2 workStart=new Ex7_6_2();
    }
    
    public Ex7_6_2() {
        super("Ex7_6_2");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img10 = tk.getImage("fly10.GIF");
        img11 = tk.getImage("fly11.GIF");
        img12 = tk.getImage("fly12.GIF");

        img20 = tk.getImage("fly20.GIF");
        img21 = tk.getImage("fly21.GIF");
        img22 = tk.getImage("fly22.GIF");

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
           if(((e.getX() >= x1) && (e.getX() <= (x1+80))) &&
             ((e.getY() >= y1) && (e.getY() <= (y1+60))))  {
                flag1_type_img = 1;
            }
           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag1_type_img == 1)) {
                fx1 = e.getX();
                fy1 = e.getY();
                dx1 = (fx1 - x1) / 50;
                dy1 = (fy1 - y1) / 50;
                flag1_type_img = 0;
           }

           if(((e.getX() >= x2) && (e.getX() <= (x2+80))) &&
             ((e.getY() >= y2) && (e.getY() <= (y2+60))))  {
                flag2_type_img = 1;
            }
           if((e.getID() == MouseEvent.MOUSE_RELEASED) && (flag2_type_img == 1)) {
                fx2 = e.getX();
                fy2 = e.getY();
                dx2 = (fx2 - x2) / 50;
                dy2 = (fy2 - y2) / 50;
                flag2_type_img = 0;
           }

     }

    public void run() {
      while(true) {
         x1 = x1 + dx1;
         y1 = y1 + dy1;
         flag1_num_img = num1 % 3;
         if(((dx1 > 0) && ((x1+40) >= fx1)) || ((dx1 < 0) && ((x1+40) <= fx1))) dx1 = 0;
         if(((dy1 > 0) && ((y1+30) >= fy1)) || ((dy1 < 0) && ((y1+30) <= fy1))) dy1 = 0;

         x2 = x2 + dx2;
         y2 = y2 + dy2;
         flag2_num_img = num2 % 3;
         if(((dx2 > 0) && ((x2+40) >= fx2)) || ((dx2 < 0) && ((x2+40) <= fx2))) dx2 = 0;
         if(((dy2 > 0) && ((y2+30) >= fy2)) || ((dy2 < 0) && ((y2+30) <= fy2))) dy2 = 0;

         repaint();
         num1 = num1 + 1;
         num2 = num2 + 1;
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
      if(flag1_num_img == 0) g.drawImage(img10, x1, y1, this);
      if(flag1_num_img == 1) g.drawImage(img11, x1, y1, this);
      if(flag1_num_img == 2) g.drawImage(img12, x1, y1, this);

      if(flag2_num_img == 0) g.drawImage(img20, x2, y2, this);
      if(flag2_num_img == 1) g.drawImage(img21, x2, y2, this);
      if(flag2_num_img == 2) g.drawImage(img22, x2, y2, this);
    }
}





