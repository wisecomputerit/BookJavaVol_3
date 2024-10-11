
import java.awt.*;
import java.awt.event.*;
import java.math.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client11_3_user1 extends Frame implements Runnable {

    int x=50, y=50;
    Image img;

    Socket socket;
    static String iaddr;
    static int port;
    DataOutputStream  outstream;
    DataInputStream  instream;
    int x_send, y_send, rcv;

    public static void main(String args[]) {
      if (args.length < 2){
         System.out.println("USAGE: java Client11_3_User1 [iaddr] [port]");	
         System.exit(1);
      }

      iaddr = args[0];
      port=Integer.parseInt(args[1]);
      Client11_3_user1 workStart=new Client11_3_user1();
    }
    
    public Client11_3_user1() {
        super("Client11_3_user1");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("img11_3.jpg");

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

           repaint();
         }
         catch (Exception f) {
            f.printStackTrace();
         }
      }
    }

    public void paint(Graphics g) {
        g.drawImage(img, x, y, this);
    }
}





