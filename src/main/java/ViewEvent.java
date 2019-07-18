import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ViewEvent {
    public static void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    public void showtable() {
        JButton editb = new JButton("Edit");
        JButton deleteb = new JButton("Delete");

        String[] columnNames = {"Date", "Details","Edit Action","Delete Action"};
    JFrame frame = new JFrame("Total Details");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.getContentPane().setBackground(new Color(32, 179, 179));
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columnNames);
    JTable table = new JTable();
    table.setModel(model);
    resizeColumnWidth(table);
//    table.setFillsViewportHeight(true);
    JScrollPane scroll = new JScrollPane(table);
    scroll.setHorizontalScrollBarPolicy(
         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(
         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//    String textvalue = textbox.getText();
        String date = "";
        String detail = "";
//        private JButton editb = new JButton("Edit");
//        private JButton deleteb = new JButton("Delete");

//        DefaultTableModel model = new DefaultTableModel(new String[]{"dt", "details"}, 0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "oviya1002");
            Statement stmt = con.createStatement();
            String sql="SELECT * FROM todo";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            if (rs.next()){
                date = rs.getString("dt");
                detail = rs.getString("details");

                model.addRow(new Object[]{date,detail,editb,deleteb});
                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame.add(scroll);
        frame.setVisible(true);
        frame.setSize(400,300);
    }
    public void importantdetails(){
        String[] columnNames = {"Date", "Details"};
        JFrame frame = new JFrame("Total Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(32, 179, 179));
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable();
        table.setModel(model);
        resizeColumnWidth(table);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String date = "";
        String detail = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "oviya1002");
            Statement stmt = con.createStatement();
            String sql="SELECT * FROM todo";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            if (rs.next()){
                date = rs.getString("dt");
                detail = rs.getString("details");

                model.addRow(new Object[]{date,detail});
                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame.add(scroll);
        frame.setVisible(true);
        frame.setSize(400,300);
    }
    public void personaldetails(){

        String[] columnNames = {"Date", "Details"};
        JFrame frame = new JFrame("Total Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(32, 179, 179));
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable();
        table.setModel(model);
        resizeColumnWidth(table);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String date = "";
        String detail = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "oviya1002");
            Statement stmt = con.createStatement();
            String sql="SELECT * FROM todo";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            if (rs.next()){
                date = rs.getString("dt");
                detail = rs.getString("details");

                model.addRow(new Object[]{date,detail});
                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame.add(scroll);
        frame.setVisible(true);
        frame.setSize(400,300);
    }
}