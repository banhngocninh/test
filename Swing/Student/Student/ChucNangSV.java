package Student;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThaiCK
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ChucNangSV extends Main {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//SinhVien SV = new SinhVien();
	//SinhVien[] ListSV = new SinhVien[100];
	private static int KTLuu = 0;

	public ChucNangSV() {
		super();
		Gui();

	}

	void GhiFile(SinhVien SVW) {
		try {
			FileOutputStream fos = new FileOutputStream("QLSV.txt", true);
			PrintWriter pw = new PrintWriter(fos);
			pw.println(SVW.getMaSV());
			pw.println(SVW.getHoten());
			pw.println(SVW.getNgay());
			pw.println(SVW.getThang());
			pw.println(SVW.getNam());
			pw.println(SVW.getHeDT());
			pw.println(SVW.getKhoa());
			pw.println(SVW.getLop());
			pw.println("********************");
			pw.close();
			fos.close();

		} catch (IOException io) {
			JOptionPane.showMessageDialog(null, "Lỗi : Nhập Liệu Mã SV Phải Nhập Kí Tự Số !");
		} finally {
			JOptionPane.showMessageDialog(null, "Thêm Dữ Liệu Thành Công ");
		}
	}

	void DocFile() {
		try {
			FileReader fr = new FileReader("QLSV.txt");
			BufferedReader buff = new BufferedReader(fr);
			for (int i = 0; i < SV.getSLSV(); i++) {
				ListSV[i] = new SinhVien();
				ListSV[i].setMaSV(Integer.parseInt(buff.readLine()));
				ListSV[i].setHoten(buff.readLine());
				ListSV[i].setNgay(Integer.parseInt(buff.readLine()));
				ListSV[i].setThang(Integer.parseInt(buff.readLine()));
				ListSV[i].setNam((Integer.parseInt(buff.readLine())));
				ListSV[i].setHeDT(buff.readLine());
				ListSV[i].setKhoa(buff.readLine());
				ListSV[i].setLop(buff.readLine());
				buff.readLine();
			}
			buff.close();
			fr.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi : Không Tìm Thấy CSDL !");
		}
	}

	// Kiem Tra Du Lieu Truoc Khi Dua Vao File
	void NhapDuLieu() {
		boolean KTMaSV = true;
		SoBangGhi();
		int i = SV.getSLSV();
		ListSV[i] = new SinhVien();
		ListSV[i].setMaSV(Integer.parseInt(tfmasv.getText()));
		DocFile();
		for (int j = 0; j < SV.getSLSV(); j++) {
			if (ListSV[i].getMaSV() == ListSV[j].getMaSV()) {
				KTMaSV = false;
				JOptionPane.showMessageDialog(this, "Lỗi : Mã Sinh Viên Đã Tồn Tại !");
				break;
			}
		}
		if (KTMaSV && KiemTra() == true) {
			ListSV[i].setMaSV(Integer.parseInt(tfmasv.getText()));
			ListSV[i].setHoten(tfhoten.getText());
			ListSV[i].setNgay(Integer.parseInt(cbngay.getSelectedItem().toString()));
			ListSV[i].setThang(Integer.parseInt(cbthang.getSelectedItem().toString()));
			ListSV[i].setNam(Integer.parseInt(cbnam.getSelectedItem().toString()));
			ListSV[i].setHeDT(cbhedt.getSelectedItem().toString());
			ListSV[i].setKhoa(cbkhoa.getSelectedItem().toString());
			ListSV[i].setLop(tflop.getText());
			GhiFile(ListSV[i]);
		}
	}

	public boolean KiemTra() {
		if (tfhoten.getText().trim().compareTo("") == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi : Họ Tên Không Được Rỗng !");
			return false;
		}
		if (tflop.getText().trim().compareTo("") == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi : Lớp Không Được Rỗng !");
			return false;
		} else
			return true;

	}

	public void SoBangGhi() {
		try {
			int count = 1;
			FileReader frd = new FileReader("QLSV.txt");
			BufferedReader buff = new BufferedReader(frd);
			buff.readLine();
			while (buff.readLine() != null) {
				count++;
			}
			SV.setSLSV(count / 9);
			buff.close();
			frd.close();
		} catch (FileNotFoundException fe) {
			JOptionPane.showMessageDialog(null, "Lỗi : Không Tìm Thấy CSDL !");
		} catch (IOException io) {
			JOptionPane.showMessageDialog(null, "Loi :Tran Lan ");
		}
	}

	void getText() {
		SV.setMaSV(Integer.parseInt(tfmasv.getText()));
		SV.setHoten(tfhoten.getText());
		SV.setNgay(Integer.parseInt(cbngay.getSelectedItem().toString()));
		SV.setThang(Integer.parseInt(cbthang.getSelectedItem().toString()));
		SV.setNam(Integer.parseInt(cbnam.getSelectedItem().toString()));
		SV.setHeDT(cbhedt.getSelectedItem().toString());
		SV.setKhoa(cbkhoa.getSelectedItem().toString());
		SV.setLop(tflop.getText());

	}

	public void Huy() {
		tfmasv.setText("");
		tfhoten.setText("");
		tflop.setText("");
	}

	public void SearchSV() {
		SoBangGhi();
		DocFile();
		cbmasv.addItem("Chọn Mã");
		for (int i = 0; i < SV.getSLSV(); i++) {
			cbmasv.addItem(ListSV[i].getMaSV());
		}
		cbmasv.addActionListener(this);
	}

	public void ThongTinSV() {
		if (cbmasv.getSelectedItem().toString().compareTo("Chọn Mã") == 0) {
			JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Mã SV Cần Tìm !");
			tfngaysinh.setText("");
			tfheDT.setText("");
			tfKhoa.setText("");
			Huy();
		} else {
			int i = Integer.parseInt(cbmasv.getSelectedItem().toString());
			for (int j = 0; j < SV.getSLSV(); j++) {
				if (ListSV[j].getMaSV() == i) {
					tfhoten.setText(ListSV[j].getHoten());
					tfngaysinh.setText(ListSV[j].getNgay() + "/" + ListSV[j].getThang() + "/" + ListSV[j].getNam());
					tfheDT.setText(ListSV[j].getHeDT());
					tfKhoa.setText(ListSV[j].getKhoa());
					tflop.setText(ListSV[j].getLop());
				}
			}
		}

	}

	public void Sua() {
		SoBangGhi();
		DocFile();
		try {
			FileOutputStream fos = new FileOutputStream("QLSV.txt");
			PrintWriter pw;
			for (int i = 0; i < SV.getSLSV(); i++) {
				fos = new FileOutputStream("QLSV.txt", true);
				pw = new PrintWriter(fos);
				if (ListSV[i].getMaSV() == Integer.parseInt(cbmasv.getSelectedItem().toString())) {
					pw.println(ListSV[i].getMaSV());
					pw.println(tfhoten.getText());
					pw.println(cbngay.getSelectedItem().toString());
					pw.println(cbthang.getSelectedItem().toString());
					pw.println(cbnam.getSelectedItem().toString());
					pw.println(cbhedt.getSelectedItem().toString());
					pw.println(cbkhoa.getSelectedItem().toString());
					pw.println(tflop.getText());
					pw.println("********************");
					pw.close();
					fos.close();
				} else {
					pw.println(ListSV[i].getMaSV());
					pw.println(ListSV[i].getHoten());
					pw.println(ListSV[i].getNgay());
					pw.println(ListSV[i].getThang());
					pw.println(ListSV[i].getNam());
					pw.println(ListSV[i].getHeDT());
					pw.println(ListSV[i].getKhoa());
					pw.println(ListSV[i].getLop());
					pw.println("********************");
					pw.close();
					fos.close();
				}
			}
		} catch (IOException io) {
			JOptionPane.showMessageDialog(this, "Lỗi : Chỉnh Sửa Thông Tin !");
		} finally {
			JOptionPane.showMessageDialog(this, "Cập Nhập Thành Công !");
		}
	}

	public void Del() {
		SoBangGhi();
		DocFile();
		try {
			FileOutputStream fos = new FileOutputStream("QLSV.txt");
			PrintWriter pw;
			for (int i = 1; i <= SV.getSLSV(); i++) {
				if (ListSV[i].getMaSV() == Integer.parseInt(cbmasv.getSelectedItem().toString())) {
					continue;
				} else {
					fos = new FileOutputStream("QLSV.txt", true);
					pw = new PrintWriter(fos);
					pw.println(ListSV[i].getMaSV());
					pw.println(ListSV[i].getHoten());
					pw.println(ListSV[i].getNgay());
					pw.println(ListSV[i].getThang());
					pw.println(ListSV[i].getNam());
					pw.println(ListSV[i].getHeDT());
					pw.println(ListSV[i].getKhoa());
					pw.println(ListSV[i].getLop());
					pw.println("*************************");
					pw.close();
					fos.close();
				}
			}
		} catch (IOException io) {
			JOptionPane.showMessageDialog(this, "Lỗi : Xóa Dữ Liệu !");
		} finally {
			JOptionPane.showMessageDialog(this, "Xóa Dữ Liệu Thành Công !");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bntThem) {
			if (bntThem.getText().equalsIgnoreCase("Thêm")) {
				LockText(true);
				bntSua.setEnabled(false);
				bntThem.setEnabled(true);
				bntThem.setText("Hủy");
			} else {
				if (bntThem.getText().equalsIgnoreCase("Xóa")) {
					if (cbmasv.getSelectedItem().toString().equalsIgnoreCase("Chọn Mã")) {
						JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Mã SV Cần Xóa !");
					} else {
						if (JOptionPane.showConfirmDialog(null, "Bạn Muốn Xóa Thông Tin Này ?", "Xác Nhận",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							try {
								Del();
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null, "Bạn Cần Hủy Để Danh Sách Cập Nhập Lại !");
							}
						}
					}

				} else {
					LockText(false);
					Huy();
					bntThem.setText("Thêm");
				}
			}
		}
		if (e.getSource() == bntLuu) {
			try {
				if (KTLuu == 0) {
					getText();
					NhapDuLieu();
				} else {
					if (JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Là Muốn Sửa Thông Tin Này Không ?", "Xác Nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						Sua();
					}
				}
				KTLuu = 0;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Lỗi : Mã SV Không Được Rỗng Và Nhập Kí Tự Số !");
			}
		}
		if (e.getSource() == bntTimkiem) {
			if (bntTimkiem.getText().compareTo("Tìm SV") == 0) {
				GuiTK();
				SearchSV();
				bntTimkiem.setText("Hủy");
				bntTimkiem.setEnabled(true);
				bntSua.setEnabled(true);
				bntThem.setText("Xóa");

			} else {
				KTLuu = 0;
				LockText(false);
				HideText(true);
				LockTK(false);
				Huy();
				bntSua.setEnabled(false);
				bntThem.setEnabled(true);
				bntTimkiem.setEnabled(true);
				bntLuu.setEnabled(false);
				bntThem.setText("Thêm");
				bntTimkiem.setText("Tìm SV");
			}
		}
		if (e.getSource() == cbmasv) {
			ThongTinSV();
		}
		if (e.getSource() == bntSua) {
			if (cbmasv.getSelectedItem().toString().compareTo("Chọn Mã") == 0) {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Thông Tin SV Cần Sửa ? ");
			} else {
				cbmasv.setEnabled(false);
				bntThem.setEnabled(false);
				tfngaysinh.setVisible(false);
				cbngay.setVisible(true);
				cbthang.setVisible(true);
				cbnam.setVisible(true);
				tfheDT.setVisible(false);
				tfKhoa.setVisible(false);
				cbhedt.setVisible(true);
				cbkhoa.setVisible(true);
				bntLuu.setEnabled(true);
				LockText(true);
				bntSua.setEnabled(false);
				bntTimkiem.setEnabled(true);
				KTLuu = 1;
			}
		}
	}

}
