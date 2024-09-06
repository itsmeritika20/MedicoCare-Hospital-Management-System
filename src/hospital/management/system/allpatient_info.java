package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class allpatient_info extends JFrame {
    allpatient_info() {
        JPanel panel =new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(176, 219, 250, 255));
        setLayout(null);
        add(panel);



        JTable table = new JTable();
        table.setBounds(8, 100, 500, 400);
        table.setBackground(new Color(176, 219, 250, 255));
        table.setFont(new Font("Open Sans", Font.BOLD, 12));
        panel.add(table);

        try {
            connection c = new connection();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }


        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);


    }
    public static void main(String[] args) {
      new allpatient_info();
    }
}
