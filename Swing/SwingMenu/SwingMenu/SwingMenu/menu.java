package SwingMenu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.awt.Desktop;

//import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class menu extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JFrame frameTitle;
	JMenuBar mnBar;
	JMenu mnFile, mnEdit, mnHelp;
	JMenuItem mniFileSave, mniFileOpen, mniFileExit, mniCut, mniCopy, mniPaste, selectAll;
	JTextArea txtData;

	public menu() {
		super("Chương trình thử hộp thoại và File Chooser");
		showWindow();
		mnBar = new JMenuBar();
		setJMenuBar(mnBar);

		mnFile = new JMenu("File");
		mnBar.add(mnFile);
		mniFileOpen = new JMenuItem("Open");
		mnFile.add(mniFileOpen);
		mniFileSave = new JMenuItem("Save");
		mnFile.add(mniFileSave);
		mniFileExit = new JMenuItem("Exit");
		mnFile.addSeparator();
		mnFile.add(mniFileExit);

		mnEdit = new JMenu("Edit");
		mnBar.add(mnEdit);
		mniCut = new JMenuItem("Cut");
		mnEdit.add(mniCut);
		mniCopy = new JMenuItem("Copy");
		mnEdit.add(mniCopy);
		mniPaste = new JMenuItem("Paste");
		mnEdit.add(mniPaste);
		selectAll = new JMenuItem("Select All");
		mnEdit.addSeparator();
		mnEdit.add(selectAll);

		mnHelp = new JMenu("Help");
		mnBar.add(mnHelp);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		txtData = new JTextArea(50, 50);
		txtData.setLineWrap(true);
		txtData.setWrapStyleWord(true);
		JScrollPane sc = new JScrollPane(txtData, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		container.add(sc, BorderLayout.CENTER);
		addEvent();
	}

	private void addEvent() {
		mniCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mniCut) {
					txtData.cut();
				}
			}
		});
		mniPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mniPaste) {
					txtData.paste();
				}
			}
		});
		mniCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mniCopy) {
					txtData.copy();
				}
			}
		});
		selectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == selectAll) {
					txtData.selectAll();
				}
			}
		});

		mniFileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int statusExit = JOptionPane.showConfirmDialog(null, "Do you really want to exit this program?",
						"Confirm to Exit", JOptionPane.YES_NO_OPTION);
				if (statusExit == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		mniFileSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser1 = new JFileChooser();
				try {
					if (chooser1.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						File selectedFile1 = chooser1.getSelectedFile();
						if (selectedFile1 == null) {
							return;
						}
						if (!selectedFile1.getName().endsWith(".txt")) {
							selectedFile1 = new File(selectedFile1.getParentFile(), selectedFile1.getName() + ".txt");
						}
						txtData.write(new OutputStreamWriter(new FileOutputStream(selectedFile1), "utf-8"));
						Desktop.getDesktop().open(selectedFile1);
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		mniFileOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(); // Xây dựng một JFileChooser trỏ tới thư mục mặc định của
															// người dùng
				try {
					if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { // Hiển thị một hộp thoại "Open
																						// File"
						File selectedFile = chooser.getSelectedFile(); // Lấy file được lựa chọn
						String filePath = selectedFile.getPath(); // Biến đổi pathname trừu tượng này thành một chuỗi
																	// pathname
						BufferedReader br = new BufferedReader(new FileReader(filePath)); // BufferedReader được sd để
																							// đọc văn bản từ một input
																							// stream dựa trên các ký
																							// tự, FileReader được sử
																							// dụng để đọc các luồng ký
																							// tự.
						String s1 = "", s2 = "";
						while ((s1 = br.readLine()) != null) { // Nó được sử dụng để đọc một dòng văn bản.
							s2 += s1 + "\n";
						}
						br.close();
						txtData.setText(s2);
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void showWindow() {
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		menu funct = new menu();
		funct.showWindow();
	}
}
