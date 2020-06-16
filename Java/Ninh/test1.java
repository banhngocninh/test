package Ninh;

class test1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("B" + i);
        }

    }
}