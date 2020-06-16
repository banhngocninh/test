import java.util.Scanner;
import java.lang.Math;

public class PhuongTrinh {
    static Scanner scanner = new Scanner(System.in);

    public static int Nhap() {
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
        System.out.print("\nNhập a: ");
        int a = Nhap();
        if (a == 0) {
            System.out.print("Nhập lại a lớn hơn 0: ");
            scanner.nextLine();
            a = Nhap();
        }
        System.out.print("\nNhập b: ");
        int b = Nhap();
        System.out.print("\nNhập c: ");
        int c = Nhap();
        System.out.print("\nPhương trình bậc 2 vừa nhập: " + a + "x^2 + " + b + "x + " + c);
        double Delta = Math.pow(b, 2) - 4 * a * c;
        System.out.print("\nDelta: " + Delta);
        double CanDelta = Math.sqrt(Delta);
        if (Delta < 0) {
            System.out.print("\nKhông có căn delta!!!");
        } else {
            System.out.print("\nCăn Delta: ");
            System.out.printf("%.2f", CanDelta);
        }
    }
}