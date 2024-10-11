import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.applet.*;


public class Ex21_2 extends Applet {
  Font messageFont1 = new Font("TimesRoman", Font.PLAIN, 30);
  Font messageFont2 = new Font("新細明體", Font.PLAIN, 30);
  Font messageFont3 = new Font("標楷體", Font.PLAIN, 30);

  String messageEnglish = "English test string";
  String messageChinese = "中文測試字串";
  
  public void paint(Graphics g) {
    g.setFont(messageFont1);
    g.setColor(Color.red);
    g.drawString(messageEnglish, 10, 50);

    g.setFont(messageFont2);
    g.setColor(Color.green);
    g.drawString(messageChinese, 10, 100);

    g.setFont(messageFont3);
    g.setColor(Color.blue);
    g.drawString(messageChinese, 10, 150);
  }
}
