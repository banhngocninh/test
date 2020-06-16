import java.util.Scanner;
 
public class Main1 {
 
    public static void main(String[] args) {
        int luongTrungBinh = 0, tongLuong = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nhân viên trong công ty: ");
        int soNhanVien = scanner.nextInt();
        NhanVien[] nhanVien = new NhanVien[soNhanVien];
         
        System.out.println("Nhập thông tin cho nhân viên");
        for (int i = 0; i < soNhanVien; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            System.out.print("Chọn loại nhân viên (1 - lập trình viên, 2 - kiểm chứng viên): ");
            int choose = scanner.nextInt();
             
            if (choose == 1) {
                nhanVien[i] = new LapTrinhVien();
            } else if (choose == 2) {
                nhanVien[i] = new KiemChungVien();
            }
             
            nhanVien[i].nhap();
            nhanVien[i].tinhLuong();
        }
         
        System.out.println("Thông tin của các nhân viên trong công ty: ");
        for (int i = 0; i < soNhanVien; i++) {
            System.out.println(nhanVien[i].toString());
        }
         
        System.out.println("Danh sách nhân viên có lương thấp hơn mức lương trung bình của "
            + "các nhân viên trong công ty.");
        for (int i = 0; i < soNhanVien; i++) {
            tongLuong += nhanVien[i].tinhLuong();
        }
        luongTrungBinh = tongLuong / soNhanVien;
         
        for (int i = 0; i < soNhanVien; i++) {
            if (nhanVien[i].tinhLuong() <= luongTrungBinh) {
                System.out.println(nhanVien[i].toString());
            }
        }
        scanner.close();
    }
 
}