import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class test {
    public static void main(String[] args) {
        NumberFormat currentLocale = NumberFormat.getInstance();
             
        // định dạng số của khu vực mặc định của máy ảo JVM
        // sử dụng phương thức format()
        double doubleNumber = 10.08;
        String str = currentLocale.format(doubleNumber);
        System.out.println("Số " + doubleNumber + " sau khi định dạng = " + str);
             
        // tạo 1 NumberFormat để định dạng số theo tiêu chuẩn của nước Anh
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
             
        // đối với số có kiểu long được định dạng theo chuẩn của nước Anh
        // thì phần ngàn của số được phân cách bằng dấu phẩy
        long longNumber = 12345678L;
        String str1 = en.format(longNumber);
        System.out.println("Số " + longNumber + " sau khi định dạng = " + str1);
             
        // tạo 1 NumberFormat để định dạng số theo tiêu chuẩn của Việt Nam
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
             
        // đối với số float được định dạng theo chuẩn của Việt Nam
        // thì phần thập phân của số được phân cách bằng dấu phẩy
        Scanner scanner = new Scanner(System.in);
        long longNumber1;
        System.out.print("Nhập vào số: ");
        longNumber1=scanner.nextLong();
        String str2 = vn.format(longNumber1);
        System.out.println("Số " + longNumber1 + " sau khi định dạng = " + str2);
        scanner.close();
    }
}