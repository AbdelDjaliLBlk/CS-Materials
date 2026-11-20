import javax.swing.*; import java.awt.*;
public class TestContainer2 {
    public static void main(String[] arg) { 
    JFrame cadre = new JFrame("Premiere fenetre");
    JPanel panel =  (JPanel) cadre.getContentPane (); // Retourne un Container casté en JPanel
    panel.setPreferredSize(new Dimension(250, 150));
    panel.setBackground(Color.RED);
    cadre.setLocation(400, 300);
    cadre.pack();
    cadre.setVisible(true);
    cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
