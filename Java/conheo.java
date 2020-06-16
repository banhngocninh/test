import java.util.Scanner;

public class conheo {
  public static void countdown(int n) {
    if (n == 0) {
      System.out.print("Happy new year!");
    } else {
      System.out.println(n);
      countdown(n - 1);
    }
  }

  public static int check() {
    Scanner scanner = new Scanner(System.in);
    int a = 0;
    boolean check = false;
    while (!check) {
      try {
        a = scanner.nextInt();
        check = true;
      } catch (Exception e) {
        System.out.print("Bạn nhập chưa đúng, xin nhập lại số: ");
        scanner.nextLine();

      }
    }
    scanner.close();
    return (a);

  }

  public static void main(String[] args) {
    System.out.print("Nhập vào n: ");
    int i = check();
    countdown(i);
    StringBuilder as = new StringBuilder("Hello");
    StringBuilder bs = new StringBuilder("Hello World");
    bs = as;
    as.append("Java");
    System.out.println(bs);

    String s = "Sachin";
    s.concat(" Tendulkar");// concat() method appends the string at the end
    System.out.println(s);// will print Sachin because strings are immutable objects
  }
}