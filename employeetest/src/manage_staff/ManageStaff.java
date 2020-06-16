package manage_staff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.AbstractListModel;
import java.awt.SystemColor;

public class ManageStaff extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldDateBegin;
	private JTextField textFieldDateOfBirth;
	private JButton btnDelete;
	private JButton btnExit;
	private JButton btnSave;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	Staff staff_1 = null;
	Room room_1 = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStaff frame = new ManageStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManageStaff() {
		setResizable(false);
		setPreferredSize(new Dimension(300, 400));
		setTitle("Chương trình quản lý nhân viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblTitle = new JLabel("STAFF MANAGEMENT PROGRAM");
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setAutoscrolls(true);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblChooseRoom = new JLabel("Choose the room: ");
		lblChooseRoom.setBounds(16, 15, 116, 16);
		panel_1.add(lblChooseRoom);
		lblChooseRoom.setAlignmentY(Component.TOP_ALIGNMENT);
		
		JComboBox comboBoxRoom = new JComboBox();
		comboBoxRoom.setBounds(144, 11, 250, 27);
		panel_1.add(comboBoxRoom);
		comboBoxRoom.setRequestFocusEnabled(false);
		comboBoxRoom.setOpaque(true);
		comboBoxRoom.setName("");
		comboBoxRoom.setPreferredSize(new Dimension(250, 27));
		comboBoxRoom.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		comboBoxRoom.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JLabel lblStaffList = new JLabel("List of staffs:");
		lblStaffList.setBounds(16, 58, 116, 16);
		panel_1.add(lblStaffList);
		
		JLabel lblDetails = new JLabel("Details: ");
		lblDetails.setBounds(220, 58, 61, 16);
		panel_1.add(lblDetails);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(201, 108, 61, 16);
		panel_1.add(lblId);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(201, 136, 61, 16);
		panel_1.add(lblName);
		
		JLabel lblDateBegin = new JLabel("Date begin: ");
		lblDateBegin.setBounds(201, 164, 83, 16);
		panel_1.add(lblDateBegin);
		
		JLabel lblBirth = new JLabel("Date of birth: ");
		lblBirth.setBounds(201, 192, 93, 16);
		panel_1.add(lblBirth);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(296, 103, 130, 26);
		panel_1.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(296, 131, 130, 26);
		panel_1.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldDateBegin = new JTextField();
		textFieldDateBegin.setBounds(296, 159, 130, 26);
		panel_1.add(textFieldDateBegin);
		textFieldDateBegin.setColumns(10);
		
		textFieldDateOfBirth = new JTextField();
		textFieldDateOfBirth.setBounds(296, 187, 130, 26);
		panel_1.add(textFieldDateOfBirth);
		textFieldDateOfBirth.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(54, 243, 117, 29);
		panel_1.add(btnSave);
		
		btnDelete = new JButton("Delete");
		btnDelete.setVerifyInputWhenFocusTarget(false);
		btnDelete.setBounds(170, 243, 117, 29);
		panel_1.add(btnDelete);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(289, 243, 117, 29);
		panel_1.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 86, 158, 143);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JList listStaff = new JList();
		listStaff.setSelectionForeground(SystemColor.window);
		listStaff.setBackground(SystemColor.window);
		listStaff.setModel(new AbstractListModel() {
			String[] values = new String[] {"Please choose the room"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_2.add(listStaff);
		
		Room Room_1 = new Room("1","Phòng Đào tạo");
		Room Room_2 = new Room("2", "Phòng Kế hoạch - Tài chính");
		Room Room_3 = new Room("3", "Phòng Công tác sinh viên");
		Room Room_4 = new Room("3", "Phòng TTPC - ĐBCL");
		listRoom.add(Room_1);
		listRoom.add(Room_2);
		listRoom.add(Room_3);
		listRoom.add(Room_4);
		for(Room i : listRoom)
			comboBoxRoom.addItem(i);
		Room_1.addStaff(new Staff("NV01", "Nguyễn Lưu Thùy Ngân", new Date(12/01/2000), new Date(12/01/1980)));
		Room_1.addStaff(new Staff("NV02", "Trần Bá Nhiệm", new Date(20/12/2009), new Date(15/11/1974)));
		Room_2.addStaff(new Staff("NV03", "Lưu Thị Bích Thủy", new Date(20/12/2009), new Date(15/11/1974)));
		Room_3.addStaff(new Staff("NV04", "Nguyễn Văn Toàn", new Date(20/12/2009), new Date(15/11/1974)));
		Room_3.addStaff(new Staff("NV05", "Trần Thị Tường Vi", new Date(20/12/2009), new Date(15/11/1974)));
		Room_3.addStaff(new Staff("NV06", "Trương Quốc Dũng", new Date(20/12/2009), new Date(15/11/1974)));
		Room_3.addStaff(new Staff("NV07", "Dương Phi Long", new Date(20/12/2009), new Date(15/11/1974)));
		Room_4.addStaff(new Staff("NV02", "Nguyễn Hoàng Tú Anh", new Date(20/12/2009), new Date(15/11/1974)));
		
		comboBoxRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxRoom.getSelectedIndex() == -1)
					return;
				room_1 = (Room) comboBoxRoom.getSelectedItem();
				listStaff.setListData(room_1.getStaffs());
			}
		});
		listStaff.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listStaff.getSelectedIndex() == -1)
					return;
				staff_1 = (Staff) listStaff.getSelectedValue();
				textFieldId.setText(staff_1.getId());
				textFieldName.setText(staff_1.getName());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				textFieldDateBegin.setText(sdf.format(staff_1.getDateBegin()));
				textFieldDateOfBirth.setText(sdf.format(staff_1.getBirthday()));
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Staff temp = null;
				try {
					temp = new Staff(textFieldId.getText(), 
							textFieldName.getText(), sdf.parse(textFieldDateBegin.getText()),
							sdf.parse(textFieldDateOfBirth.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (Room_1 != null) {
					room_1.addStaff(temp);
					listStaff.setListData(room_1.getStaffs());
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(staff_1 != null) {
					room_1.getStaffs().remove(staff_1);
					staff_1 = null;
					listStaff.setListData(room_1.getStaffs());
				}
			}
			});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	private ArrayList<Room> listRoom = new ArrayList<Room>();
	private Vector<Staff> staffs = new Vector<Staff>();
}
