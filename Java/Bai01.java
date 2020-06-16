import java.util.Scanner;

public class Bai01 {
    public static int Nhap() {
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
        scanner.close();
        return (n);
    }

    public static int UCLN(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else
                b = b - a;
        }
        return (a);
    }

    public static void main(String[] args) {
        System.out.print("Nhập a: ");
        int a = Nhap();
        System.out.println();
        System.out.print("Nhập b: ");
        int b = Nhap();
        System.out.println();
        System.out.print("Ước chung nhỏ nhất của " + a + " và " + b + " là: " + UCLN(a, b));
        System.out.println();
        System.out.print("Bội chung lớn nhất của " + a + " và " + b + " là: " + ((a * b) / UCLN(a, b)));
    }
}