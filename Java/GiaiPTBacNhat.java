
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GiaiPTBacNhat extends JFrame {

	private JTextField txtFactorA;
	private JTextField txtFactorB;
	private JTextField txtResult;
	private JButton buttonSolve;
	private JButton buttonExit;
	ActionListener eventSolve = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			processSolve();
		}
	};

	public GiaiPTBacNhat(String title) {
		super(title);
		this.addControls();
		this.addEvents();
	}

	public void addControls() {
		// The window
		Container container = getContentPane();
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		container.add(panelMain);
		// The title of the program with text "GIAI PT BAC NHAT"
		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(new FlowLayout());
		JLabel labelTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC NHẤT");
		panelTitle.add(labelTitle);
		panelMain.add(panelTitle);
		labelTitle.setForeground(Color.BLUE); // set font color
		Font font = new Font("Arial", Font.BOLD, 20); // font style
		labelTitle.setFont(font);
		// The description after title
		JPanel panelDescription = new JPanel();
		panelDescription.setLayout(new FlowLayout());
		JLabel descript = new JLabel("Nhập các hệ số a, b, c và bấm vào nút Giải");
		panelDescription.add(descript);
		panelMain.add(panelDescription);
		// Factor A
		JPanel factorA = new JPanel();
		factorA.setLayout(new FlowLayout());
		JLabel labelFactorA = new JLabel("Nhập hệ số a:");
		txtFactorA = new JTextField(15);
		factorA.add(labelFactorA);
		factorA.add(txtFactorA);
		panelMain.add(factorA);
		// Factor B
		JPanel factorB = new JPanel();
		factorA.setLayout(new FlowLayout());
		JLabel labelFactorB = new JLabel("Nhập hệ số b:");
		txtFactorB = new JTextField(15);
		factorB.add(labelFactorB);
		factorB.add(txtFactorB);
		panelMain.add(factorB);
		// Two button
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout());
		buttonSolve = new JButton("Giải");
		buttonExit = new JButton("Thoát");
		panelButton.add(buttonSolve);
		panelButton.add(buttonExit);
		panelMain.add(panelButton);
		// Result output
		JPanel result = new JPanel();
		result.setLayout(new FlowLayout());
		JLabel labelResult = new JLabel("Kết quả: ");
		txtResult = new JTextField(20);
		result.add(labelResult);
		result.add(txtResult);
		panelMain.add(result);
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

	protected void processSolve() {
		String factorA = txtFactorA.getText();
		String factorB = txtFactorB.getText();
		double a = Double.parseDouble(factorA);
		double b = Double.parseDouble(factorB);
		if (a == 0 && b == 0)
			txtResult.setText("Phương trình có vô số nghiệm.");
		else if (a == 0 && b != 0)
			txtResult.setText("Phương trình vô nghiệm.");
		else {
			double result = -b / a;
			txtResult.setText("Nghiệm của phương trình là x = " + result);
		}
		;

	}

	public void showWindow(int width, int height) {
		this.setSize(width, height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		GiaiPTBacNhat funct = new GiaiPTBacNhat("Giai phuong trinh bac nhat");
		funct.showWindow(380, 300);
	}
}