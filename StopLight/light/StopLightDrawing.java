package light;

import javax.swing.JComponent;
import java.awt.*;

public class StopLightDrawing extends JComponent {

    /**
     *
     */
    Color green = Color.GRAY;
    Color yellow = Color.GRAY;
    Color red = Color.GRAY;
    String activeLight = "red";
    private static final long serialVersionUID = 1L;

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 150, 250);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 150, 250);
        g.setColor(green);
        g.fillOval(50, 30, 50, 50);
        g.setColor(yellow);
        g.fillOval(50, 100, 50, 50);
        g.setColor(red);
        g.fillOval(50, 170, 50, 50);
    }

    public void changeColor() {
        green = Color.GRAY;
        yellow = Color.GRAY;
        red = Color.GRAY;
        if (activeLight.equals("red")) {
            activeLight = "green";
            green = Color.GREEN;
        }else if (activeLight.equals("green")){
            activeLight = "yellow";
            yellow = Color.YELLOW;

        }else {
            activeLight = "red";
            red = Color.RED;}
        repaint();
    }
}