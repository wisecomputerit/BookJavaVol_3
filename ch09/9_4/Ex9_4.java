
import java.awt.*;
import java.awt.event.*;

public class Ex9_4 extends Frame implements Runnable {

    int x, y;
    Image img, bufferPage;
    int[] area_flag = new int[9];
    int i;

    public static void main(String args[]) {
      Ex9_4 workStart=new Ex9_4();
    }
    
    public Ex9_4() {
        super("Ex9_4");
        setSize(250,280);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("Circle.GIF");

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
        if(e.getID() == MouseEvent.MOUSE_PRESSED) {
            x = e.getX();
            y = e.getY();
        }
    }

    public void run() {
      while(true) {
         if((x>30)&&(x<90)&&(y>70)&&(y<130)&&(area_flag[0]==0)) 
           {area_flag[0] = 1;}
         else if ((x>90)&&(x<150)&&(y>70)&&(y<130)&&(area_flag[1]==0)) 
                 {area_flag[1] = 1;}
         else if ((x>150)&&(x<210)&&(y>70)&&(y<130)&&(area_flag[2]==0)) 
                 {area_flag[2] = 1;}
         else if((x>30)&&(x<90)&&(y>130)&&(y<190)&&(area_flag[3]==0)) 
                 {area_flag[3] = 1;}
         else if((x>90)&&(x<150)&&(y>130)&&(y<190)&&(area_flag[4]==0)) 
                 {area_flag[4] = 1;}
         else if((x>150)&&(x<210)&&(y>130)&&(y<190)&&(area_flag[5]==0)) 
                 {area_flag[5] = 1;}
         else if((x>30)&&(x<90)&&(y>190)&&(y<250)&&(area_flag[6]==0)) 
                 {area_flag[6] = 1;}
         else if((x>90)&&(x<150)&&(y>190)&&(y<250)&&(area_flag[7]==0)) 
                 {area_flag[7] = 1;}
         else if((x>150)&&(x<210)&&(y>190)&&(y<250)&&(area_flag[8]==0)) 
                 {area_flag[8] = 1;}
         repaint();
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void update(Graphics g) {
       paint(g);
    }

    public void paint(Graphics g) {
       Graphics bufferg;
       if(bufferPage == null)
          bufferPage = createImage(250, 250);
       bufferg = bufferPage.getGraphics();

       bufferg.drawLine(90,50,90,230);
       bufferg.drawLine(150,50,150,230);
       bufferg.drawLine(30,110,210,110);
       bufferg.drawLine(30,170,210,170);

       for (i=0; i<9; i++) {
           if (area_flag[0] == 1)
              bufferg.drawImage(img, 42, 60, this);
           if (area_flag[1] == 1)
              bufferg.drawImage(img, 102, 60, this);
           if (area_flag[2] == 1)
              bufferg.drawImage(img, 164, 60, this);
           if (area_flag[3] == 1)
              bufferg.drawImage(img, 42, 125, this);
           if (area_flag[4] == 1)
              bufferg.drawImage(img, 102, 125, this);
           if (area_flag[5] == 1)
              bufferg.drawImage(img, 164, 125, this);
           if (area_flag[6] == 1)
              bufferg.drawImage(img, 42, 187, this);
           if (area_flag[7] == 1)
              bufferg.drawImage(img, 102, 187, this);
           if (area_flag[8] == 1)
              bufferg.drawImage(img, 164, 187, this);
       }

       bufferg.dispose();
       g.drawImage(bufferPage, getInsets().left, getInsets().top, this);
    }
}





