import java.awt.*;
public class MonCanvas extends Canvas {
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(10, 10, 100,50);
        g.setColor(Color.green);
        g.fillOval(40, 40, 10,10);
    }
}

