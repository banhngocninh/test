

class array {
    public static void main(String arrgs[]) {
        int[] a = { 5, 2, 3, 7, 1 };
        System.out.print("Mảng vừa tạo là: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.print("Số lớn nhất trong mảng là: " + max);
        int min = a[0];
        for (int i = 0; i < a.length; i++) {

            if (min > a[i]) {
                min = a[i];

            }
        }
        System.out.println();
        System.out.print("Số nhỏ nhất trong mảng là: " + min);
        int swap;
        System.out.println();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j <= a.length - 1; j++) {
                if (a[i] > a[j]) {
                    swap = a[i];
                    a[i] = a[j];
                    a[j] = swap;
                }
            }
        }
        System.out.print("Mảng sau khi xếp tăng dần là: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println();
        System.out.print("Tổng dãy số: " + sum);
    }

    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        
    }
    
   
}
