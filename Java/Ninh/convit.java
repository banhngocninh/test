package Ninh;

public class convit {
  public static void main(String[] args) {
    test1 t1 = new test1();
    test2 t2 = new test2();
    Thread t = new Thread(t2);
    t1.start();
    t.start();
  }
}