package workouts;

import java.awt.*;

class PolyLines extends Frame {
    /**
    	 *
    	 */
    private static final long serialVersionUID = 1L;
    int x1[] = { 70, 100, 0, 0, 0 };
    int y1[] = { 50, 30, 60, 75, 60 };
    int x2[] = { 67, 82, 95, 120, 135 };
    int y2[] = { 150, 130, 160, 155, 180 };

    public PolyLines()// constructor
    {
        super("Poly Lines");
        setSize(300, 300);
        setVisible(true);
        
    }

    public void paint(Graphics g) {
        g.drawPolyline(x1, y1, 5);
        //g.setFont(new Font("Times Roman", Font.BOLD, 15));
        g.drawString("Current Color is black", 100, 100);

        g.setColor(Color.blue);
        g.drawPolyline(x2, y2, 5);
        g.drawString("Current Color is blue", 100, 200);
    }

    public static void main(String[] args) {
        PolyLines clock = new PolyLines();

    }
}
