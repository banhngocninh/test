package SwingCheckBox;

import javax.swing.*;
import java.awt.event.*;

public class CheckBoxExample extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JCheckBox checkF1, checkF2, checkF3;
    public JButton buttonTotal;
    public JLabel l;

    public CheckBoxExample() {
        super("Order");
        l = new JLabel("Food Ordering System");
        l.setBounds(50, 50, 300, 20);
        add(l);

        checkF1 = new JCheckBox("Coffee 10$");
        checkF1.setBounds(100, 100, 150, 20);
        add(checkF1);

        checkF2 = new JCheckBox("Pizza 100$");
        checkF2.setBounds(100, 150, 150, 20);
        add(checkF2);

        checkF3 = new JCheckBox("Hotdog 50$");
        checkF3.setBounds(100, 200, 150, 20);
        add(checkF3);

        buttonTotal = new JButton("Total");
        buttonTotal.setBounds(100, 250, 150, 20);
        add(buttonTotal);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addEvent();
    }

    private void addEvent() {
        buttonTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                float fTotal = 0;
                String sBill = "";
                if (checkF1.isSelected()) {
                    fTotal += 10;
                    sBill += "The coffee: 10$\n";
                }
                if (checkF2.isSelected()) {
                    fTotal += 100;
                    sBill += "The pizza: 100$\n";
                }
                if (checkF3.isSelected()) {
                    fTotal += 50;
                    sBill += "The hotdog: 50$\n";
                }
                sBill += "----------\n";
                JOptionPane.showMessageDialog(null, sBill + "Total: " + fTotal);
            }
        });
    }

    public static void main(String[] args) {
        new CheckBoxExample();
    }

}