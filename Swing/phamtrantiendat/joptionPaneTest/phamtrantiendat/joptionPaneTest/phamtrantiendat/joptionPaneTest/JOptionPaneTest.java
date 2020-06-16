package phamtrantiendat.joptionPaneTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JOptionPaneTest extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JFrame frameTitle;
	JMenuBar mnBar;
	JMenu mnFile, mnEdit, mnHelp;
	JMenuItem mniFileSave, mniFileOpen, mniFileExit, mniCut, mniCopy, mniPaste, selectAll;
	JTextArea txtData;

	public JOptionPaneTest() {
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
		mniFileExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int statusExit = JOptionPane.showConfirmDialog(null, "Do you really want to " + "exit this program ?",
						"Confirm to Exit", JOptionPane.YES_NO_OPTION);
				if (statusExit == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		mniFileOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				try {
					if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File selectedFile = chooser.getSelectedFile();
						FileInputStream fis = new FileInputStream(selectedFile);
						InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
						BufferedReader br = new BufferedReader(isr);
						String line , s2 = "";

						while ((line= br.readLine()) != null) {

							s2 += line + "\n";
						}
						br.close();
						txtData.setText(s2);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
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
		JOptionPaneTest funct = new JOptionPaneTest();
		funct.showWindow();
	}

}
