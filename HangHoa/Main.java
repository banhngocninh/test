import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static long Nhap() {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        int n = 0;
        while (!check) {
            try {
                n = scanner.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.print("Bạn nhập sai, xin nhập lại: ");
                scanner.nextLine();
            }
        }
        return (n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SanPham> sp = new ArrayList<SanPham>();
        System.out.print("Nhập số sản phẩm: ");
        int soSanPham = new Scanner(System.in).nextInt();
        System.out.println("\n   ---------");
        System.out.println("Nhập thông tin cho sản phẩm");
        System.out.println("\n   ---------");
        for (int i = 0; i < soSanPham; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1));
            System.out.print("Nhập tên sản phẩm: ");
            String TenSp = new Scanner(System.in).nextLine();
            System.out.print("Nhập giá sản phẩm: ");
            Long DonGia = Nhap();
            System.out.print("Nhập giá được giảm: ");
            Long GiamGia = Nhap();
            SanPham sanpham = new SanPham(TenSp, DonGia, GiamGia);
            sp.add(sanpham);
        }
        System.out.println("\n   ---------");
        System.out.println("Thông tin của các sản phẩm: ");
        for (SanPham i : sp) {
            i.xuat();
        }

    }
}