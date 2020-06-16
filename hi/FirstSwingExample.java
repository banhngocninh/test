import javax.swing.*;

public class FirstSwingExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("My Frame");// Tao instance cua JFrame
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(400, 500);// Do rong la 400 va chieu cao la 500
        JButton b = new JButton("Click");// Tao instance cua JButton
        b.setBounds(130, 100, 100, 40);// truc x, truc y, do rong, chieu cao

        f.add(b);// Them button vao trong JFrame
        f.setLocationRelativeTo(null);

        f.setLayout(null);// Khong su dung Layout Manager
        f.setVisible(true);// Tao Frame la co the nhin thay (visible)

    }
}
