import java.awt.*;
import java.awt.event.*;

public class Ex6_9_2 extends Frame {
    public Ex6_9_2() {
        super("Ex6_9_2");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public static void main(String args[]) {
      Ex6_9_2 workStart=new Ex6_9_2();
    }
}





