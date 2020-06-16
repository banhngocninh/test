package banhngocninh.pttd;




import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class GridLine {
  JTable table;

  public static void main(String[] args) {
    new GridLine();
  }

  public GridLine() {
    JFrame frame = new JFrame("Grid Line in JTable Component!");
    JPanel panel = new JPanel();
    String data[][] = { { "Vinod", "Computer", "3" }, { "Rahul", "History", "2" }, { "Manoj", "Biology", "4" },
        { "Sanjay", "PSD", "5" } };
    String col[] = { "Name", "Course", "Year" };
    DefaultTableModel model = new DefaultTableModel(data, col);
    table = new JTable(model);
    // Setting the grid line
    table.setShowGrid(true);
    // Removing the grid line from the table
    // table.setShowGrid(false);
    // Show vertical grid lines
    table.setShowVerticalLines(true);
    // setting grid color
    
    table.setGridColor(Color.BLUE);
    JTableHeader header = table.getTableHeader();
    // header.setBackground(Color.yellow);
    JScrollPane pane = new JScrollPane(table);
    panel.add(pane);
    frame.add(panel);
    frame.setSize(500, 150);
    // frame.setUndecorated(true);
    // frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}