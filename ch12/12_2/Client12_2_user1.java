
import java.awt.*;
import java.awt.event.*;
import java.math.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client12_2_user1 extends Frame implements Runnable {

    int x, y;
    Image img;
    int[] area_flag = new int[9];
    int i;

    Socket socket;
    static String iaddr;
    static int port;
    DataOutputStream  outstream;
    DataInputStream  instream;
    int x_send, y_send, rcv, w;

    public static void main(String args[]) {
      if (args.length < 2){
         System.out.println("USAGE: java Client11_3_User1 [iaddr] [port]");	
         System.exit(1);
      }

      iaddr = args[0];
      port=Integer.parseInt(args[1]);
      Client12_2_user1 workStart=new Client12_2_user1();
    }
    
    public Client12_2_user1() {
        super("Client12_2_user1");
        setSize(250,280);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("Circle.GIF");

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);

        setVisible(true);

        try{
            socket=new Socket(InetAddress.getByName(iaddr),port);
            outstream = new DataOutputStream(socket.getOutputStream());
            instream = new DataInputStream(socket.getInputStream()); 
            new Thread(this).start();
         }
         catch (Exception e) {
            e.printStackTrace();
         }
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public void processMouseEvent(MouseEvent e) {
        if(e.getID() == MouseEvent.MOUSE_PRESSED) {
          try{
            x = e.getX();
            y = e.getY();

            x_send = x * 100 + 0;
            y_send = y * 100 + 1;
            outstream.writeInt(x_send);
            outstream.writeInt(y_send);
          }
          catch (Exception f) {
            f.printStackTrace();
          }
        }
    }

    public void run() {
      while(true) {
       try{
         rcv = instream.readInt();
         if(rcv % 100 == 0) x = (rcv-0)/100;
         if(rcv % 100 == 1) y = (rcv-1)/100;
         w = w+1;

         if((x>30)&&(x<90)&&(y>70)&&(y<130)&&(area_flag[0]==0)&&(w%2==0)) 
           {area_flag[0] = 1;}
         else if ((x>90)&&(x<150)&&(y>70)&&(y<130)&&(area_flag[1]==0)&&(w%2==0)) 
                 {area_flag[1] = 1;}
         else if ((x>150)&&(x<210)&&(y>70)&&(y<130)&&(area_flag[2]==0)&&(w%2==0)) 
                 {area_flag[2] = 1;}
         else if((x>30)&&(x<90)&&(y>130)&&(y<190)&&(area_flag[3]==0)&&(w%2==0)) 
                 {area_flag[3] = 1;}
         else if((x>90)&&(x<150)&&(y>130)&&(y<190)&&(area_flag[4]==0)&&(w%2==0)) 
                 {area_flag[4] = 1;}
         else if((x>150)&&(x<210)&&(y>130)&&(y<190)&&(area_flag[5]==0)&&(w%2==0)) 
                 {area_flag[5] = 1;}
         else if((x>30)&&(x<90)&&(y>190)&&(y<250)&&(area_flag[6]==0)&&(w%2==0)) 
                 {area_flag[6] = 1;}
         else if((x>90)&&(x<150)&&(y>190)&&(y<250)&&(area_flag[7]==0)&&(w%2==0)) 
                 {area_flag[7] = 1;}
         else if((x>150)&&(x<210)&&(y>190)&&(y<250)&&(area_flag[8]==0)&&(w%2==0)) 
                 {area_flag[8] = 1;}

         repaint();
         Thread.sleep(250);
        }
        catch (Exception f) {
            f.printStackTrace();
        }
      }
    }

    public void paint(Graphics g) {
       g.drawLine(90,50,90,230);
       g.drawLine(150,50,150,230);
       g.drawLine(30,110,210,110);
       g.drawLine(30,170,210,170);

       for (i=0; i<9; i++) {
           if (area_flag[0] == 1)
              g.drawImage(img, 42, 60, this);
           if (area_flag[1] == 1)
              g.drawImage(img, 102, 60, this);
           if (area_flag[2] == 1)
              g.drawImage(img, 164, 60, this);
           if (area_flag[3] == 1)
              g.drawImage(img, 42, 125, this);
           if (area_flag[4] == 1)
              g.drawImage(img, 102, 125, this);
           if (area_flag[5] == 1)
              g.drawImage(img, 164, 125, this);
           if (area_flag[6] == 1)
              g.drawImage(img, 42, 187, this);
           if (area_flag[7] == 1)
              g.drawImage(img, 102, 187, this);
           if (area_flag[8] == 1)
              g.drawImage(img, 164, 187, this);
       }
    }
}





