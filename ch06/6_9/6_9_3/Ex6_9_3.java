import java.awt.*;
import java.awt.event.*;

class Ex6_9_3 extends Frame {
   public Ex6_9_3() { 
      super("Ex6_9_3");
      setSize(350, 350);
      setVisible(true);  

      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt) {
              System.exit(0);
         }
      });
   }

    public static void main(String[] args) {
         Ex6_9_3 workstart = new Ex6_9_3();

    }
}
