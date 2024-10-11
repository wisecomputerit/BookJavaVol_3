
import java.awt.*;
import java.awt.event.*;
import java.math.*;

import java.io.*;
import java.net.*;
import java.util.*;

import java.applet.*;

public class Client12_4_user1 extends Frame implements Runnable {

    int x1, y1, x2, y2;
    Image img1, img2;
    int[] area_flag = new int[9];
    int i;

    Socket socket;
    static String iaddr;
    static int port;
    DataOutputStream  outstream;
    DataInputStream  instream;
    int x1_send, y1_send, x2_send, y2_send, rcv, w;

    AudioClip sound1, sound2, soundwin;
    String message = "";

    public static void main(String args[]) {
      if (args.length < 2){
         System.out.println("USAGE: java Client11_3_User1 [iaddr] [port]");	
         System.exit(1);
      }

      iaddr = args[0];
      port=Integer.parseInt(args[1]);
      Client12_4_user1 workStart=new Client12_4_user1();
    }
    
    public Client12_4_user1() {
        super("Client12_4_user1");
        setSize(250,280);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img1 = tk.getImage("Circle.GIF");
        img2 = tk.getImage("Cross.GIF");

        sound1 = Applet.newAudioClip(getClass().getResource("sound1.au"));
        sound2 = Applet.newAudioClip(getClass().getResource("sound2.au"));
        soundwin = Applet.newAudioClip(getClass().getResource("soundwin.au"));
 
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
            x1 = e.getX();
            y1 = e.getY();
            sound1.play();

            x1_send = x1 * 100 + 0;
            y1_send = y1 * 100 + 1;
            outstream.writeInt(x1_send);
            outstream.writeInt(y1_send);
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
         if(rcv % 100 == 0) x1 = (rcv-0)/100;
         if(rcv % 100 == 1) y1 = (rcv-1)/100;
         if(rcv % 100 == 2) x2 = (rcv-2)/100;
         if(rcv % 100 == 3) y2 = (rcv-3)/100;
         w = w+1;

         if((x1>30)&&(x1<90)&&(y1>70)&&(y1<130)&&(area_flag[0]==0)&&(w%2==0)) 
           {area_flag[0] = 1;}
         else if ((x1>90)&&(x1<150)&&(y1>70)&&(y1<130)&&(area_flag[1]==0)&&(w%2==0)) 
                 {area_flag[1] = 1;}
         else if ((x1>150)&&(x1<210)&&(y1>70)&&(y1<130)&&(area_flag[2]==0)&&(w%2==0)) 
                 {area_flag[2] = 1;}
         else if((x1>30)&&(x1<90)&&(y1>130)&&(y1<190)&&(area_flag[3]==0)&&(w%2==0)) 
                 {area_flag[3] = 1;}
         else if((x1>90)&&(x1<150)&&(y1>130)&&(y1<190)&&(area_flag[4]==0)&&(w%2==0)) 
                 {area_flag[4] = 1;}
         else if((x1>150)&&(x1<210)&&(y1>130)&&(y1<190)&&(area_flag[5]==0)&&(w%2==0)) 
                 {area_flag[5] = 1;}
         else if((x1>30)&&(x1<90)&&(y1>190)&&(y1<250)&&(area_flag[6]==0)&&(w%2==0)) 
                 {area_flag[6] = 1;}
         else if((x1>90)&&(x1<150)&&(y1>190)&&(y1<250)&&(area_flag[7]==0)&&(w%2==0)) 
                 {area_flag[7] = 1;}
         else if((x1>150)&&(x1<210)&&(y1>190)&&(y1<250)&&(area_flag[8]==0)&&(w%2==0)) 
                 {area_flag[8] = 1;}

         if((x2>30)&&(x2<90)&&(y2>70)&&(y2<130)&&(area_flag[0]==0)&&(w%2==0)) 
           {area_flag[0] = 2;}
         else if ((x2>90)&&(x2<150)&&(y2>70)&&(y2<130)&&(area_flag[1]==0)&&(w%2==0)) 
                 {area_flag[1] = 2;}
         else if ((x2>150)&&(x2<210)&&(y2>70)&&(y2<130)&&(area_flag[2]==0)&&(w%2==0)) 
                 {area_flag[2] = 2;}
         else if((x2>30)&&(x2<90)&&(y2>130)&&(y2<190)&&(area_flag[3]==0)&&(w%2==0)) 
                 {area_flag[3] = 2;}
         else if((x2>90)&&(x2<150)&&(y2>130)&&(y2<190)&&(area_flag[4]==0)&&(w%2==0)) 
                 {area_flag[4] = 2;}
         else if((x2>150)&&(x2<210)&&(y2>130)&&(y2<190)&&(area_flag[5]==0)&&(w%2==0)) 
                 {area_flag[5] = 2;}
         else if((x2>30)&&(x2<90)&&(y2>190)&&(y2<250)&&(area_flag[6]==0)&&(w%2==0)) 
                 {area_flag[6] = 2;}
         else if((x2>90)&&(x2<150)&&(y2>190)&&(y2<250)&&(area_flag[7]==0)&&(w%2==0)) 
                 {area_flag[7] = 2;}
         else if((x2>150)&&(x2<210)&&(y2>190)&&(y2<250)&&(area_flag[8]==0)&&(w%2==0)) 
                 {area_flag[8] = 2;}

         if ((area_flag[0]==1)&&(area_flag[1]==1)&&(area_flag[2]==1)&&(message=="")) {
               message = "User1 win!!";
               soundwin.play();
         }
         else if ((area_flag[3]==1)&&(area_flag[4]==1)&&(area_flag[5]==1)&&(message=="")) {
               message = "User1 win!!";
               soundwin.play();
         }
         else if ((area_flag[6]==1)&&(area_flag[7]==1)&&(area_flag[8]==1)&&(message=="")) {
               message = "User1 win!!";
               soundwin.play();
         }
         else if ((area_flag[0]==1)&&(area_flag[3]==1)&&(area_flag[6]==1)&&(message=="")) {
               message = "User1 win!!";
               soundwin.play();
         }
         else if ((area_flag[1]==1)&&(area_flag[4]==1)&&(area_flag[7]==1)&&(message=="")) {
               message = "User1 win!!";
               soundwin.play();
         }
         else if ((area_flag[2]==1)&&(area_flag[5]==1)&&(area_flag[8]==1)&&(message=="")) {
               message = "User1 win!!";
               soundwin.play();
         }
         else if ((area_flag[0]==1)&&(area_flag[4]==1)&&(area_flag[8]==1)&&(message=="")) {
               message = "User1 win!!";
               soundwin.play();
         }
         else if ((area_flag[2]==1)&&(area_flag[4]==1)&&(area_flag[6]==1)&&(message=="")) {
               message = "User1 win!!";
               soundwin.play();
         }

         if ((area_flag[0]==2)&&(area_flag[1]==2)&&(area_flag[2]==2)&&(message=="")) {
               message = "User2 win!!";
               soundwin.play();
         }
         else if ((area_flag[3]==2)&&(area_flag[4]==2)&&(area_flag[5]==2)&&(message=="")) {
               message = "User2 win!!";
               soundwin.play();
         }
         else if ((area_flag[6]==2)&&(area_flag[7]==2)&&(area_flag[8]==2)&&(message=="")) {
               message = "User2 win!!";
               soundwin.play();
         }
         else if ((area_flag[0]==2)&&(area_flag[3]==2)&&(area_flag[6]==2)&&(message=="")) {
               message = "User2 win!!";
               soundwin.play();
         }
         else if ((area_flag[1]==2)&&(area_flag[4]==2)&&(area_flag[7]==2)&&(message=="")) {
               message = "User2 win!!";
               soundwin.play();
         }
         else if ((area_flag[2]==2)&&(area_flag[5]==2)&&(area_flag[8]==2)&&(message=="")) {
               message = "User2 win!!";
               soundwin.play();
         }
         else if ((area_flag[0]==2)&&(area_flag[4]==2)&&(area_flag[8]==2)&&(message=="")) {
               message = "User2 win!!";
               soundwin.play();
         }
         else if ((area_flag[2]==2)&&(area_flag[4]==2)&&(area_flag[6]==2)&&(message=="")) {
               message = "User2 win!!";
               soundwin.play();
         }

         repaint();
         Thread.sleep(250);
        }
        catch (Exception f) {
            f.printStackTrace();
        }
      }
    }

    public void paint(Graphics g) {
       g.drawString(message, 20, 45);
       g.drawLine(90,50,90,230);
       g.drawLine(150,50,150,230);
       g.drawLine(30,110,210,110);
       g.drawLine(30,170,210,170);

       for (i=0; i<9; i++) {
           if (area_flag[0] == 1)
              g.drawImage(img1, 42, 60, this);
           if (area_flag[1] == 1)
              g.drawImage(img1, 102, 60, this);
           if (area_flag[2] == 1)
              g.drawImage(img1, 164, 60, this);
           if (area_flag[3] == 1)
              g.drawImage(img1, 42, 125, this);
           if (area_flag[4] == 1)
              g.drawImage(img1, 102, 125, this);
           if (area_flag[5] == 1)
              g.drawImage(img1, 164, 125, this);
           if (area_flag[6] == 1)
              g.drawImage(img1, 42, 187, this);
           if (area_flag[7] == 1)
              g.drawImage(img1, 102, 187, this);
           if (area_flag[8] == 1)
              g.drawImage(img1, 164, 187, this);
       }

       for (i=0; i<9; i++) {
           if (area_flag[0] == 2)
              g.drawImage(img2, 42, 60, this);
           if (area_flag[1] == 2)
              g.drawImage(img2, 102, 60, this);
           if (area_flag[2] == 2)
              g.drawImage(img2, 164, 60, this);
           if (area_flag[3] == 2)
              g.drawImage(img2, 42, 125, this);
           if (area_flag[4] == 2)
              g.drawImage(img2, 102, 125, this);
           if (area_flag[5] == 2)
              g.drawImage(img2, 164, 125, this);
           if (area_flag[6] == 2)
              g.drawImage(img2, 42, 187, this);
           if (area_flag[7] == 2)
              g.drawImage(img2, 102, 187, this);
           if (area_flag[8] == 2)
              g.drawImage(img2, 164, 187, this);
       }
    }
}





