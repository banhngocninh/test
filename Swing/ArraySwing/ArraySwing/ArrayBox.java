package ArraySwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ArrayBox extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField tElement, tValue;
    private JLabel lTitle, lElement, lValue, lInfo, lInfo1, lInfo2, lSort, lSort1;
    private JButton bComplete, bNext, bSort, bExit;
    private int n;
    private static ArrayList<Integer> arraySys = new ArrayList<Integer>();

    public ArrayBox() {
        addControl();
        addSolve();
    }

    public void addControl() {
        JFrame fTitle = new JFrame("CHƯƠNG TRÌNH XUẤT MẢNG");

        lTitle = new JLabel("CHƯƠNG TRÌNH XUẤT MẢNG");
        lTitle.setBounds(100, 20, 200, 50);
        fTitle.add(lTitle);

        lElement = new JLabel("Nhập số lượng phần tử: ");
        lElement.setBounds(10, 80, 200, 30);
        fTitle.add(lElement);
        tElement = new JTextField();
        tElement.setBounds(150, 80, 50, 30);
        fTitle.add(tElement);
        bComplete = new JButton("Complete");
        bComplete.setBounds(250, 85, 100, 20);
        fTitle.add(bComplete);

        lInfo = new JLabel("");
        lInfo.setBounds(120, 120, 250, 30);
        fTitle.add(lInfo);
        lInfo.setVisible(false);

        lValue = new JLabel("Phần tử thứ 1: ");
        lValue.setBounds(10, 160, 200, 30);
        lValue.setVisible(false);
        fTitle.add(lValue);
        tValue = new JTextField("");
        tValue.setBounds(150, 160, 50, 30);
        tValue.setVisible(false);
        fTitle.add(tValue);
        bNext = new JButton("Next");
        bNext.setBounds(250, 165, 100, 20);
        bNext.setVisible(false);
        fTitle.add(bNext);

        lInfo1 = new JLabel("Mảng sau khi nhập: ");
        lInfo1.setBounds(10, 220, 200, 30);
        lInfo1.setVisible(false);
        fTitle.add(lInfo1);
        lInfo2 = new JLabel("");
        lInfo2.setBounds(150, 220, 200, 30);
        lInfo2.setVisible(false);
        fTitle.add(lInfo2);
        bSort = new JButton("Sort");
        bSort.setBounds(250, 225, 100, 20);
        bSort.setVisible(false);
        fTitle.add(bSort);

        lSort = new JLabel("Mảng sau khi sắp xếp: ");
        lSort.setBounds(10, 280, 200, 30);
        lSort.setVisible(false);
        fTitle.add(lSort);
        lSort1 = new JLabel("");
        lSort1.setBounds(150, 280, 200, 30);
        lSort1.setVisible(false);
        fTitle.add(lSort1);

        bExit = new JButton("Exit");
		bExit.setBounds(250, 300, 100, 20);
		fTitle.add(bExit);

        fTitle.setSize(400, 400);
        fTitle.setLayout(null);
        fTitle.setLocationRelativeTo(null);
        fTitle.setVisible(true);
    }

    public void addSolve() {
        bComplete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lInfo.setVisible(true);
                lValue.setVisible(true);
                tValue.setVisible(true);
                bNext.setVisible(true);
                String S = tElement.getText();
                int I = Integer.parseInt(S);
                setNumber(I);
                lInfo.setText("Mảng gồm " + I + " phần tử");
                lElement.setEnabled(false);
                tElement.setEnabled(false);
                bComplete.setEnabled(false);
            }
        });

        bNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String S = tValue.getText();
                int I = Integer.parseInt(S);
                arraySys.add(I);
                if (arraySys.size() == getNumber()) {
                    lInfo1.setVisible(true);
                    lInfo2.setVisible(true);
                    bSort.setVisible(true);
                    lInfo2.setText(To_String(arraySys));
                    lValue.setEnabled(false);
                    bNext.setEnabled(false);
                    tValue.setEnabled(false);
                } else {
                    tValue.setText("");
                    int pos = arraySys.size() + 1;
                    lValue.setText("Phẩn tử thứ " + pos + ": ");
                }
            }
        });
        bSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lSort.setVisible(true);
                lSort1.setVisible(true);
                lSort1.setText(Sort(arraySys));
            }
        });
        bExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

    }
    private String To_String(ArrayList<Integer> arraySys) {
        String output = "";
        for (int i = 0; i < arraySys.size(); i++) {
            output += arraySys.get(i) + " ";
        }
        return output;
    }

    public static String Sort(ArrayList<Integer> arraySys) {
        ArrayList<Integer> temp = arraySys;
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i) < temp.get(j)) {
                    int Extra = temp.get(j);
                    temp.set(j, temp.get(i));
                    temp.set(i, Extra);
                }
            }
        }
        return temp.toString();
    }

    void setNumber(int n) {
        this.n = n;
    }

    int getNumber() {
        return n;
    }

    public static void main(String[] args) {
        ArrayBox AB = new ArrayBox();
    }

}