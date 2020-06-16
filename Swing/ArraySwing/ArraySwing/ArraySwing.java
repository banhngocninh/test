package ArraySwing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArraySwing extends JFrame {

    private static final long serialVersionUID = 1L;

    private int n;
    private static ArrayList<Integer> arraySys = new ArrayList<Integer>();
    private JTextField textFieldElement; // Nhập số lượng
    private JTextField textFieldAray; // Nhập số thứ ...

    private JButton buttonComplete; // Nút xong
    private JButton buttonNext; // Nút tiếp theo
    private JButton buttonSort;
    private JButton buttonExit; // Nút thoát chương trình

    private JPanel mainPanel, panelTitle, panelTypeElement, panelComplete, panelTypeArr, panelExport, panelSort1,
            panelSort, panelExit;
    private JLabel labelTitle, labelTypeElement, labeltextAddArray, labelTypeArr, labelExport, labeltextOutArray,
            labelSort, labeltextSort;

    public ArraySwing(String Title) {
        super(Title);
        addControls();
        addEvents();
    }

    public void addControls() {
        Container container = getContentPane();

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        container.add(mainPanel);

        panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout());
        labelTitle = new JLabel("EXPORT THE ARRAY");
        labelTitle.setForeground(Color.GRAY);
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        labelTitle.setFont(font);
        panelTitle.add(labelTitle);
        mainPanel.add(panelTitle);

        panelTypeElement = new JPanel();
        panelTypeElement.setLayout(new FlowLayout());
        labelTypeElement = new JLabel("Type number of the array: ");
        labelTypeElement.setForeground(Color.DARK_GRAY);
        textFieldElement = new JTextField(15);
        panelTypeElement.add(labelTypeElement);
        panelTypeElement.add(textFieldElement);
        mainPanel.add(panelTypeElement);

        panelComplete = new JPanel();
        panelComplete.setLayout(new FlowLayout());
        buttonComplete = new JButton("Complete");
        mainPanel.add(buttonComplete);
        labeltextAddArray = new JLabel("");
        mainPanel.add(labeltextAddArray);
        mainPanel.add(panelComplete);

        panelTypeArr = new JPanel();
        panelTypeArr.setLayout(new FlowLayout());
        panelTypeArr.setVisible(false);
        labelTypeArr = new JLabel();
        labelTypeArr.setText("Element 1: ");
        labelTypeArr.setForeground(Color.DARK_GRAY);
        textFieldAray = new JTextField(15);
        buttonNext = new JButton("Next Element");
        panelTypeArr.add(labelTypeArr);
        panelTypeArr.add(textFieldAray);
        panelTypeArr.add(buttonNext);
        mainPanel.add(panelTypeArr);

        panelExport = new JPanel();
        panelExport.setLayout(new FlowLayout());
        panelExport.setVisible(false);
        labelExport = new JLabel("The Array: ");
        labelExport.setForeground(Color.DARK_GRAY);
        panelExport.add(labelExport);
        labeltextOutArray = new JLabel("");
        panelExport.add(labeltextOutArray);
        mainPanel.add(panelExport);

        panelSort1 = new JPanel();
        panelSort1.setLayout(new FlowLayout());
        buttonSort = new JButton("Sort");
        mainPanel.add(buttonSort);
        mainPanel.add(panelSort1);

        panelSort = new JPanel();
        panelSort.setLayout(new FlowLayout());
        panelSort.setVisible(false);
        labelSort = new JLabel("Array after sorting descending: ");
        labelSort.setForeground(Color.DARK_GRAY);
        panelSort.add(labelSort);
        labeltextSort = new JLabel("");
        panelSort.add(labeltextSort);
        mainPanel.add(panelSort);

        panelExit = new JPanel();
        panelExit.setLayout(new FlowLayout());
        panelExit.setVisible(false);
        buttonExit = new JButton("Finish");
        panelExit.add(buttonExit);
        mainPanel.add(panelExit);
    }

    public void addEvents() {
        buttonComplete.addActionListener(actionComplete);
        buttonNext.addActionListener(actionNext);
        buttonSort.addActionListener(actionSort);
    }

    ActionListener actionComplete = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textFieldElement.setEnabled(false);
            buttonComplete.setEnabled(false);
            String S = textFieldElement.getText();
            int I = Integer.parseInt(S);
            setNumber(I);
            labeltextAddArray.setText("The Array has " + I + " element(s)");
            panelTypeArr.setVisible(true);
        }
    };

    ActionListener actionNext = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String S1 = textFieldAray.getText();
            int I1 = Integer.parseInt(S1);
            arraySys.add(I1);
            if (arraySys.size() == getNumber()) {
                panelExport.setVisible(true);
                labeltextOutArray.setText(To_String(arraySys));
            } else {
                textFieldAray.setText("");
                int pos = arraySys.size() + 1;
                labelTypeArr.setText("Element " + pos + ": ");
            }
        }
    };

    ActionListener actionSort = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonNext.setEnabled(false);
            textFieldAray.setEnabled(false);
            panelSort.setVisible(true);
            labeltextSort.setText(Sort(arraySys));
            buttonSort.setEnabled(false);
        }
    };

    public static void main(String[] args) {
        ArraySwing funct = new ArraySwing("Program to manipulate arrays");
        funct.showWindow(400, 320);
    }

    public void setNumber(int n) {
        this.n = n;
    }

    public int getNumber() {
        return n;
    }

    public String To_String(ArrayList<Integer> arraySys) {
        String output = "";
        for (int i = 0; i < arraySys.size(); i++) {
            output += arraySys.get(i) + " ";
        }
        return output;
    }

    public String Sort(ArrayList<Integer> arraySys) {
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

    private void showWindow(int width, int height) {
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}