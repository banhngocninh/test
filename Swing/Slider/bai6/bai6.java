
package bai6;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class bai6 extends JFrame {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	public bai6() {
		super("Exercise17_3");
		Container container = getContentPane();

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		JSlider redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		JLabel redLabel = new JLabel("R =");
		redLabel.setForeground(Color.RED);
		topPanel.add(redSlider);
		topPanel.add(redLabel);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		JSlider greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		JLabel greenLabel = new JLabel("G =");
		greenLabel.setForeground(Color.GREEN);
		centerPanel.add(greenSlider);
		centerPanel.add(greenLabel);

		JPanel botPanel = new JPanel();
		botPanel.setLayout(new FlowLayout());
		botPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		JSlider blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		JLabel blueLabel = new JLabel("B =");
		blueLabel.setForeground(Color.BLUE);
		botPanel.add(blueSlider);
		botPanel.add(blueLabel);

		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		mainPanel.add(rightPanel, BorderLayout.EAST);
		
		mainPanel.add(topPanel, BorderLayout.CENTER);
		
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(botPanel, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(topPanel);
		leftPanel.add(centerPanel);
		leftPanel.add(botPanel);
		leftPanel.setLayout(new GridLayout(3, 1));
		mainPanel.add(leftPanel, BorderLayout.NORTH);
		
		JPanel sum = new JPanel();
		sum.setLayout(new BorderLayout());
		sum.add(leftPanel);
		sum.add(rightPanel);
		sum.setLayout(new GridLayout(1, 2));
		mainPanel.add(sum, BorderLayout.CENTER);

		container.add(mainPanel);

		redSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int red = redSlider.getValue();
				int green = greenSlider.getValue();
				int blue = blueSlider.getValue();
				redLabel.setText("R = " + red);
				if (green > red && green > blue) {
					rightPanel.setBackground(Color.GREEN);
				} else if (blue > red && blue > green) {
					rightPanel.setBackground(Color.BLUE);
				} else if (blue == red && blue == green) {
					rightPanel.setBackground(Color.WHITE);
				} else if (red == blue && green < red) {
					rightPanel.setBackground(Color.PINK);
				} else if (red == green && blue < red) {
					rightPanel.setBackground(Color.YELLOW);
				} else if (green == blue && red < green) {
					rightPanel.setBackground(Color.CYAN);
				} else
					rightPanel.setBackground(Color.RED);
			}
		});

		greenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int red = redSlider.getValue();
				int green = greenSlider.getValue();
				int blue = blueSlider.getValue();
				greenLabel.setText("G = " + green);
				if (red > green && red > blue) {
					rightPanel.setBackground(Color.RED);
				} else if (blue > green && blue > red) {
					rightPanel.setBackground(Color.BLUE);
				} else if (blue == red && blue == green) {
					rightPanel.setBackground(Color.WHITE);
				} else if (red == blue && green < red) {
					rightPanel.setBackground(Color.PINK);
				} else if (red == green && blue < red) {
					rightPanel.setBackground(Color.YELLOW);
				} else if (green == blue && red < green) {
					rightPanel.setBackground(Color.CYAN);
				} else
					rightPanel.setBackground(Color.GREEN);
			}
		});
		blueSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int red = redSlider.getValue();
				int green = greenSlider.getValue();
				int blue = blueSlider.getValue();
				blueLabel.setText("B = " + blue);
				if (red > blue && red > green) {
					rightPanel.setBackground(Color.RED);
				} else if (green > blue && green > red) {
					rightPanel.setBackground(Color.GREEN);
				} else if (blue == red && blue == green) {
					rightPanel.setBackground(Color.WHITE);
				} else if (red == blue && green < red) {
					rightPanel.setBackground(Color.PINK);
				} else if (red == green && blue < red) {
					rightPanel.setBackground(Color.YELLOW);
				} else if (green == blue && red < green) {
					rightPanel.setBackground(Color.CYAN);

				} else
					rightPanel.setBackground(Color.BLUE);
			}
		});

	}

	public void showWindow() {
		this.setSize(650, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		bai6 funct = new bai6();
		funct.showWindow();
	}
}