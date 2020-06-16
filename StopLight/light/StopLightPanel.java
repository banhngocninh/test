package light;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopLightPanel extends JPanel {

    /**
     *
     */
    StopLightDrawing light = new StopLightDrawing();

    private static final long serialVersionUID = 1L;
    JRadioButton buttonRed, buttonYellow, buttonGreen;

    public StopLightPanel() {
        JButton changeButton = new JButton("Switch");

        
		
		
        light.setPreferredSize(new Dimension(160, 260));
        
        add(light);
        add(changeButton);
        changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				light.changeColor();
			}
		});
    }

}