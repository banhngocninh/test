import java.util.Scanner;

public class SanPham {
    String TenSp;
    Long DonGia, GiamGia;
    Scanner scanner = new Scanner(System.in);
    
    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String TenSp) {
        this.TenSp = TenSp;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(Long DonGia) {
        this.DonGia = DonGia;
    }

    public double getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(Long GiamGia) {
        this.GiamGia = GiamGia;
    }

    
    public SanPham(String TenSp, Long DonGia, Long GiamGia) {
		this.TenSp = TenSp;
		this.DonGia = DonGia;
		this.GiamGia = GiamGia;
	}

    public void xuat() {
        System.out.println("Tên sản phẩm: " + this.TenSp);
        System.out.println("Giá sản phẩm: " + this.DonGia);
        System.out.println("Giá được giảm: " + this.GiamGia);
    }

}