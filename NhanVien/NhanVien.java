import java.util.Scanner;

public class NhanVien {
    private String maNhanVien, hoTen, soDienThoai, mail;
    private int tuoi;
    protected int luong, luongCoBan;
    Scanner scanner = new Scanner(System.in);

    public NhanVien() {
        super();
    }

    public NhanVien(String maNhanVien, String hoTen, String soDienThoai, String mail, int tuoi, int luong,
            int luongCoBan) {
        super();
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.mail = mail;
        this.tuoi = tuoi;
        this.luong = luong;
        this.luongCoBan = luongCoBan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public void nhap() {
        System.out.print("Nhập mã nhân viên: ");
        maNhanVien = scanner.nextLine();
        System.out.print("Nhập họ tên nhân viên: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        soDienThoai = scanner.nextLine();
        System.out.print("Nhập mail: ");
        mail = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        tuoi = scanner.nextInt();
        System.out.print("Nhập lương cơ bản: ");
        luongCoBan = scanner.nextInt();
    }

    public int tinhLuong() {
        return 0;
    }

    @Override
    public String toString() {
        return "Mã nhân viên: " + this.maNhanVien + ", họ tên nhân viên: " + this.hoTen + ", số điện thoại: "
                + this.soDienThoai + ", mail: " + this.mail + ", tuổi: " + this.tuoi + ", lương cơ bản: "
                + this.luongCoBan;
    }
}