package Student;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThaiCK
 */
public class SinhVien {
	private int MaSV, Ngay, Thang, Nam, SLSV = 0;
	private String Hoten, HeDT, Khoa, Lop;
	public SinhVien[] ListSV;

	public SinhVien() {

	}

	// Getter va Setter Ma Sinh Vien
	public int getMaSV() {
		return MaSV;
	}

	public void setMaSV(int ID) {
		this.MaSV = ID;
	}

	// Getter va Setter Ho Ten
	public String getHoten() {
		return this.Hoten;
	}

	public void setHoten(String name) {
		this.Hoten = name;
	}

	// Getter va Setter Ngay Sinh
	public int getNgay() {
		return Ngay;
	}

	public void setNgay(int date) {
		this.Ngay = date;
	}

	// Getter va Setter Thang
	public int getThang() {
		return Thang;
	}

	public void setThang(int month) {
		this.Thang = month;
	}

	// Getter va Setter Nam
	public int getNam() {
		return Nam;
	}

	public void setNam(int year) {
		this.Nam = year;
	}

	// Getter va Setter He Dao Tao
	public String getHeDT() {
		return HeDT;
	}

	public void setHeDT(String HDT) {
		this.HeDT = HDT;
	}

	// Getter va Setter Khoa
	public String getKhoa() {
		return Khoa;
	}

	public void setKhoa(String skhoa) {
		this.Khoa = skhoa;
	}

	// Getter va Setter Lop
	public String getLop() {
		return Lop;
	}

	public void setLop(String sLop) {
		this.Lop = sLop;
	}

	// Getter va Setter So Luong Sinh Vien
	public int getSLSV() {
		return SLSV;
	}

	public void setSLSV(int ssl) {
		this.SLSV = ssl;
	}
}
