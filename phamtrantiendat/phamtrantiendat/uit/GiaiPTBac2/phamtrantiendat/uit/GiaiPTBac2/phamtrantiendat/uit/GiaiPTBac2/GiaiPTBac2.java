package phamtrantiendat.uit.GiaiPTBac2;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPTBac2 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFactorA;
	private JTextField txtFactorB;
	private JTextField txtFactorC;
	private JTextField txtResult;

	private JButton buttonSolve;
	private JButton buttonExit;

	ActionListener eventSolve = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			processSolve();
		}
	};

	public GiaiPTBac2(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void processSolve() {
		String factorA = txtFactorA.getText();
		String factorB = txtFactorB.getText();
		String factorC = txtFactorC.getText();
		Double a = Double.parseDouble(factorA);
		Double b = Double.parseDouble(factorB);
		Double c = Double.parseDouble(factorC);
		if (a == 0) {
			if (b == 0 && c == 0)
				txtResult.setText("Phương trình có vô số nghiệm.");
			if (b == 0 && c != 0)
				txtResult.setText("Phương trình vô nghiệm.");
		} else {
			double delta = b * b - 4 * a * c;
			double x1 = (-b + Math.sqrt(delta)) / 2 * a;
			double x = -b / (2 * a);
			double x2 = (-b - Math.sqrt(delta)) / 2 * a;
			if (delta < 0)
				txtResult.setText("Phương trình vô nghiệm.");
			else if (delta == 0)
				txtResult.setText("Phương trình có nghiệm kép x = " + x);
			else
				txtResult.setText("Phương trình có hai nghiệm x1 = " + x1 + " và x2 = " + x2);
		}
		;
	}

	public void showWindow(int width, int height) {
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addControls() {
		Container container = getContentPane();

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		container.add(mainPanel);

		JPanel panelTitle = new JPanel();
		JLabel title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		title.setForeground(Color.BLUE);
		Font font = new Font("Arial", Font.BOLD, 20);
		title.setFont(font);
		panelTitle.add(title);
		mainPanel.add(panelTitle);

		JLabel description = new JLabel("Nhập các hệ số a, b, c và bấm nút Giải");
		mainPanel.add(description);

		JPanel factorA = new JPanel();
		factorA.setLayout(new FlowLayout());
		JLabel labelA = new JLabel("Hệ số a: ");
		txtFactorA = new JTextField(15);
		factorA.add(labelA);
		factorA.add(txtFactorA);
		mainPanel.add(factorA);

		JPanel factorB = new JPanel();
		factorA.setLayout(new FlowLayout());
		JLabel labelB = new JLabel("Hệ số b: ");
		txtFactorB = new JTextField(15);
		factorB.add(labelB);
		factorB.add(txtFactorB);
		mainPanel.add(factorB);

		JPanel factorC = new JPanel();
		factorC.setLayout(new FlowLayout());
		JLabel labelC = new JLabel("Hệ số c: ");
		txtFactorC = new JTextField(15);
		factorC.add(labelC);
		factorC.add(txtFactorC);
		mainPanel.add(factorC);

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout());
		buttonSolve = new JButton("Giải");
		buttonExit = new JButton("Thoát");
		panelButton.add(buttonSolve);
		panelButton.add(buttonExit);
		mainPanel.add(panelButton);

		JPanel result = new JPanel();
		result.setLayout(new FlowLayout());
		JLabel labelResult = new JLabel("Kết quả: ");
		txtResult = new JTextField(20);
		result.add(labelResult);
		result.add(txtResult);
		mainPanel.add(result);
	}

	public void addEvents() {
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonSolve.addActionListener(eventSolve);
	}

	public static void main(String[] args) {
		GiaiPTBac2 funct = new GiaiPTBac2("Chuong trinh giai PT Bac hai");
		funct.showWindow(400, 300);
	}

}
