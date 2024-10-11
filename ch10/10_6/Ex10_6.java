
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Ex10_6 extends Frame implements Runnable {
    int x1=150, y1=225, dx1, dy1, x2=150, y2=10;
    int bx, by, dbx=0, dby=-5, bflag=0, hitflag2=0;
    Image img1, img2, img3, bufferPage=null;
    AudioClip shoot1, explode;
    String message="";

    public static void main(String args[]) {
      Ex10_6 workStart=new Ex10_6();
    }
    
    public Ex10_6() {
        super("Ex10_6");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img1 = tk.getImage("car090.gif");
        img2 = tk.getImage("car180.gif");
        img3 = tk.getImage("hit2.gif");

        shoot1 = Applet.newAudioClip(getClass().getResource("shoot1.au"));
        explode = Applet.newAudioClip(getClass().getResource("explode.au"));

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        enableEvents(AWTEvent.KEY_EVENT_MASK);

        setVisible(true);
        new Thread(this).start();
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public void processKeyEvent(KeyEvent e) {
        if(e.getID() == KeyEvent.KEY_PRESSED) {
              switch(e.getKeyCode()) {
                   case KeyEvent.VK_RIGHT:
                          dx1 = 5; dy1 = 0;
                          break;
                   case KeyEvent.VK_LEFT:
                          dx1 = -5; dy1 = 0;
                          break;
                   case KeyEvent.VK_UP:
                          dx1 = 0; dy1 = -5; 
                          break;
                   case KeyEvent.VK_DOWN:
                          dx1 = 0; dy1 = 5;
                          break;
                   case KeyEvent.VK_SPACE:
                          dx1 = 0; dy1 = 0;
                          bx = x1 + 30;
                          by = y1 - 5;
                          bflag = 1;
                          shoot1.play();
                          break;
                    default:
                          dx1 = 0; dy1 = 0;
              }
            x1 = x1 + dx1;
            y1 = y1 + dy1;

        }
    }

    public void run() {
      while(true) {
         if(by <= -10) bflag = 0;
         if(bflag == 1) by = by + dby;

         if ((bx>=x2)&&(bx<=x2+60)&&(by<=y2)&&(message=="")){
             hitflag2=1;
             explode.play();
             message="User Win!!";
         }         

         repaint();
         try{Thread.sleep(30);}
         catch(InterruptedException e) {;}
      }
    }

    public void update(Graphics g) {
       paint(g);
    }

    public void paint(Graphics g) {
       Graphics bufferg;
       if(bufferPage == null)
          bufferPage = createImage(350, 350);
       bufferg = bufferPage.getGraphics();

       if (hitflag2==1) img2=img3;
       bufferg.drawString(message, 20, 20);

       bufferg.drawImage(img1, x1, y1, this);
       bufferg.drawImage(img2, x2, y2, this);

       bufferg.fillRect(bx, by, 3, 5);
       bufferg.setColor(Color.white);
       bufferg.fillRect(bx, by+5, 3, 5);

       bufferg.dispose();
       g.drawImage(bufferPage, getInsets().left, getInsets().top, this);
    }
}





