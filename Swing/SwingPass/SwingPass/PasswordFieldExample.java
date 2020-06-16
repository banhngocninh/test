package SwingPass;

import javax.swing.*;
import java.awt.event.*;

public class PasswordFieldExample {
   public JLabel l1, l2, label;
   public JTextField text;
   public JPasswordField value;
   public JButton b;

   public PasswordFieldExample() {

      addControls();
      addEvents();
   }

   private void addEvents() {
      b.addActionListener(eventExport);
   }

   ActionListener eventExport = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         String data =  text.getText();
         String data2 = new String(value.getPassword());
         label.setText("Username: " + data + ", Password: " + data2);
      }
   };

   public void addControls() {
      JFrame f = new JFrame("Password Field Example");

      l1 = new JLabel("Username:");
      l1.setBounds(20, 20, 80, 30);
      text = new JTextField();
      text.setBounds(100, 20, 100, 30);
      f.add(l1);
      f.add(text);

      l2 = new JLabel("Password:");
      l2.setBounds(20, 75, 80, 30);
      value = new JPasswordField();
      value.setBounds(100, 75, 100, 30);
      f.add(l2);
      f.add(value);

      b = new JButton("Login");
      b.setBounds(100, 120, 80, 30);
      label = new JLabel();
      label.setBounds(20, 150, 200, 50);
      f.add(b);
      f.add(label);

      f.setSize(300, 300);
      f.setLayout(null);
      f.setVisible(true);
   }

   public static void main(String[] args) {
      PasswordFieldExample P = new PasswordFieldExample();
   }
}