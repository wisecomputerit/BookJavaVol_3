import java.awt.*;
import java.awt.event.*;

public class Ex6_8_2 extends Frame {
    public Ex6_8_2() {
        super("Ex6_8_2");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.FOCUS_EVENT_MASK);
    }

    public void processFocusEvent(FocusEvent e) {
        if(e.getID() == FocusEvent.FOCUS_LOST) {
           System.out.println("getSource() : " + e.getSource());
           System.out.println("getID() : " + e.getID());
           System.out.println("isTemporary() : " + e.isTemporary());
        }
    }

    public static void main(String args[]) {
      Ex6_8_2 workStart=new Ex6_8_2();
    }
}





