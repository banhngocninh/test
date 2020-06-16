package phamtrantiendat.employeeProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EmployeeManagement extends JFrame {
	private final JTextField txFieldId, txFieldName, txFieldAddress, txFieldEmail, txFieldAge, txFieldSalary;
	private final JButton btnNew, btnSave, btnDelete, btnExit;
	private final JButton btnLast, btnFirst, btnNext, btnPr;
	private final JButton btnOpenFile, btnSaveFile;
	private int elementPosition = -1;
	ArrayList<Employee> list = new ArrayList<Employee>();

	public EmployeeManagement() {
		final JFrame frame = new JFrame("Employee Test");

		final JLabel lblTitle = new JLabel("EMPLOYEE MANAGEMENT");
		lblTitle.setBounds(200, 20, 200, 50);
		frame.add(lblTitle);

		final JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(40, 80, 80, 30);
		txFieldId = new JTextField();
		txFieldId.setBounds(140, 80, 200, 30);
		frame.add(lblId);
		frame.add(txFieldId);

		final JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(40, 120, 80, 30);
		txFieldName = new JTextField();
		txFieldName.setBounds(140, 120, 200, 30);
		frame.add(lblName);
		frame.add(txFieldName);

		final JLabel lblAdr = new JLabel("Address: ");
		lblAdr.setBounds(40, 160, 80, 30);
		txFieldAddress = new JTextField();
		txFieldAddress.setBounds(140, 160, 200, 30);
		frame.add(lblAdr);
		frame.add(txFieldAddress);

		final JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(40, 200, 80, 30);
		txFieldEmail = new JTextField();
		txFieldEmail.setBounds(140, 200, 200, 30);
		frame.add(lblEmail);
		frame.add(txFieldEmail);

		final JLabel lblAge = new JLabel("Age: ");
		lblAge.setBounds(40, 240, 80, 30);
		txFieldAge = new JTextField();
		txFieldAge.setBounds(140, 240, 200, 30);
		frame.add(lblAge);
		frame.add(txFieldAge);

		final JLabel lblSalary = new JLabel("Salary: ");
		lblSalary.setBounds(40, 280, 80, 30);
		txFieldSalary = new JTextField();
		txFieldSalary.setBounds(140, 280, 200, 30);
		frame.add(lblSalary);
		frame.add(txFieldSalary);

		btnFirst = new JButton("First");
		btnFirst.setBounds(20, 340, 60, 20);
		frame.add(btnFirst);

		btnPr = new JButton("Previous");
		btnPr.setEnabled(false);
		btnPr.setBounds(100, 340, 100, 20);
		frame.add(btnPr);

		btnNext = new JButton("Next");
		btnNext.setBounds(220, 340, 60, 20);
		btnNext.setEnabled(false);
		frame.add(btnNext);

		btnLast = new JButton("Last");
		btnLast.setBounds(300, 340, 60, 20);
		frame.add(btnLast);

		//
		btnOpenFile = new JButton("Import");
		btnOpenFile.setBounds(400, 80, 100, 20);
		frame.add(btnOpenFile);

		btnSaveFile = new JButton("Export");
		btnSaveFile.setBounds(400, 120, 100, 20);
		frame.add(btnSaveFile);

		btnNew = new JButton("New");
		btnNew.setBounds(400, 160, 100, 20);
		btnNew.setEnabled(false);
		frame.add(btnNew);

		btnSave = new JButton("Save");
		btnSave.setBounds(400, 200, 100, 20);
		frame.add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(400, 240, 100, 20);
		frame.add(btnDelete);
		btnDelete.setEnabled(false);

		btnExit = new JButton("Exit");
		btnExit.setBounds(400, 320, 100, 20);
		frame.add(btnExit);

		frame.setSize(600, 500);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		if (list.size() != 0)
			showInformation(elementPosition);
		addEvents();
	}

	private void addEvents() {
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				elementPosition = -1;
				txFieldId.setText(null);
				txFieldName.setText(null);
				txFieldEmail.setText(null);
				txFieldAddress.setText(null);
				txFieldAge.setText(null);
				txFieldSalary.setText(null);

				btnNew.setEnabled(false);
				btnLast.setEnabled(false);
				btnFirst.setEnabled(false);
				btnPr.setEnabled(false);
				btnNext.setEnabled(false);
				btnDelete.setEnabled(false);

			}
		});
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if (elementPosition == -1) {
					list.add(new Employee(txFieldId.getText(), txFieldName.getText(), txFieldAddress.getText(),
							txFieldEmail.getText(), Integer.parseInt(txFieldAge.getText()),
							Double.parseDouble(txFieldSalary.getText())));
					elementPosition = list.size() - 1;
					System.out.println(list.get(elementPosition));
				} else {
					list.get(elementPosition).setName(txFieldName.getText());
					list.get(elementPosition).setAddress(txFieldAddress.getText());
					list.get(elementPosition).setEmail(txFieldEmail.getText());
					list.get(elementPosition).setAge(Integer.parseInt(txFieldAge.getText()));
					list.get(elementPosition).setSalary(Double.parseDouble(txFieldSalary.getText()));
				}
				btnNew.setEnabled(true);
				btnPr.setEnabled(true);
				btnDelete.setEnabled(true);
				btnNext.setEnabled(true);
				btnFirst.setEnabled(true);
				btnLast.setEnabled(true);

			}
		});
		btnSaveFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				doWriteDataToDisk();
			}
		});
		btnFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				showInformation(0);
				elementPosition = 0;
			}
		});
		btnLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				showInformation(list.size() - 1);
				elementPosition = list.size() - 1;
			}
		});
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				if (elementPosition == list.size() - 1)
					showInformation(list.size() - 1);
				else {
					showInformation(elementPosition + 1);
					elementPosition++;
				}

			}
		});
		btnPr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				if (elementPosition != 0) {
					elementPosition--;
					showInformation(elementPosition);
				}

				else
					showInformation(0);
			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				list.remove(elementPosition);
				if (elementPosition >= list.size())
					elementPosition = list.size() - 1;
				if (list.size() == 0) {
					btnNew.doClick();
					return;
				}

			}
		});
		btnOpenFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				doReadDataFromDisk();
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void doReadDataFromDisk() {
		final JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			list.removeAll(list);
			list = (ArrayList<Employee>) MyProcessFile.openData(fc.getSelectedFile().getAbsolutePath());
			btnLast.doClick();
			btnFirst.doClick();
			btnNext.doClick();
			btnPr.doClick();
			elementPosition = 0;
			System.out.println("Read file successfully");
			btnSave.doClick();
		}
	}

	private void doWriteDataToDisk() {
		final JFileChooser fc = new JFileChooser();
		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			MyProcessFile.saveData(list, fc.getSelectedFile().getAbsolutePath());
			System.out.println("Write file successfully");
		}
	}

	public void showInformation(final int index) {
		txFieldId.setText(list.get(index).getId());
		txFieldName.setText(list.get(index).getName());
		txFieldAddress.setText(list.get(index).getAddress());
		txFieldEmail.setText(list.get(index).getAddress());
		txFieldAge.setText(String.valueOf(list.get(index).getAge()));
		txFieldSalary.setText(String.valueOf(list.get(index).getSalary()));
	}

	public static void main(final String[] args) {
		new EmployeeManagement();

	}
}
