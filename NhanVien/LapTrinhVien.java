public class LapTrinhVien extends NhanVien {
    private int soGioLamThem;
 
    public LapTrinhVien() {
        super();
    }
 
    public LapTrinhVien(int soGioLamThem) {
        super();
        this.soGioLamThem = soGioLamThem;
    }
 
    public int getSoGioLamThem() {
        return soGioLamThem;
    }
 
    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }
     
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập số giờ làm thêm: ");
        soGioLamThem = scanner.nextInt();
    }
     
    @Override
    public int tinhLuong() {
        this.luong = this.luongCoBan + this.soGioLamThem * 200000;
        return this.luong;
    }
 
    @Override
    public String toString() {
        return super.toString() + "\n, số giờ làm thêm: " + this.soGioLamThem + 
            ", lương: " + this.luong;
    }
}