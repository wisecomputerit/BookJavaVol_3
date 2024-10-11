import java.awt.*;
import java.awt.event.*;

public class Ex6_5_2 extends Frame {
    public Ex6_5_2() {
        super("Ex6_5_2");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.KEY_EVENT_MASK);
    }

    public void processKeyEvent(KeyEvent e) {
        if(e.getID() == KeyEvent.KEY_PRESSED) {
          if(e.getKeyCode() == KeyEvent.VK_A)
            System.out.println("This is VK_A event");
          else
            System.out.println("This is not VK_A event");
        }
    }

    public static void main(String args[]) {
      Ex6_5_2 workStart=new Ex6_5_2();
    }
}





