import java.awt.*;
import java.awt.event.*;

public class Ex6_4_2 extends Frame {
    public Ex6_4_2() {
        super("Ex6_4_2");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.COMPONENT_EVENT_MASK);
    }

    public void processComponentEvent(ComponentEvent e) {
        if(e.getID() == ComponentEvent.COMPONENT_RESIZED) {
           System.out.println("getSource() : " + e.getSource());
           System.out.println("getID() : " + e.getID());
    
        }
    }

    public static void main(String args[]) {
      Ex6_4_2 workStart=new Ex6_4_2();
    }
}





