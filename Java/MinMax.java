import java.util.Arrays;
import java.util.Scanner;

public class MinMax {
    public static void main(String[] arrgs) {
        Scanner scanner = new Scanner(System.in);
        int n, dem = 0;
        System.out.print("Nhập vào số lượng phần tử có trong mảng: ");
        n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            a[i] = scanner.nextInt();
        }
        System.out.print("Mảng vừa nhập gồm: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (max < a[i]) {
                max = a[i];

            }
        }
        System.out.print("\nSố lớn nhất trong mảng là: " + max);

        int min = a[0];
        for (int i = 0; i < n; i++) {
            if (min > a[i]) {
                min = a[i];

            }
        }
        System.out.print("\nSố nhỏ nhất trong mảng là: " + min);

        System.out.print("\nSố LẺ trong mảng là số: ");
        for (int i = 0; i < n; i++) {
            if ((a[i] % 2) != 0) {
                System.out.print(a[i]+ " ");
                dem++;
            }
        }
        System.out.print("\nCó " + dem + " phần tử là số LẺ trong mảng");

        System.out.print("\nMảng sau khi xếp giảm dần: ");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (a[i] < a[j]) {
                    int swap;
                    swap = a[j];
                    a[j] = a[i];
                    a[i] = swap;
                }
            }
            

        }
            System.out.print(a[0] + " ");
            System.out.print(a[1] + " ");
            System.out.print(a[2] + " ");
            System.out.print(a[3] + " ");
            System.out.print(a[4] + " ");

        Arrays.sort(a);
        System.out.print("\nMảng sau khi sắp xếp tăng dần: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        scanner.close();
    }
}