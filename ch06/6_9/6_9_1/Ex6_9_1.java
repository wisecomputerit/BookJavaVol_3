import java.awt.*;
import java.awt.event.*;

public class Ex6_9_1 extends Frame {
    public Ex6_9_1() {
        super("Ex6_9_1");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.out.println("getSource() : " + e.getSource());
           System.out.println("getID() : " + e.getID());
        }
    }

    public static void main(String args[]) {
      Ex6_9_1 workStart=new Ex6_9_1();
    }
}





