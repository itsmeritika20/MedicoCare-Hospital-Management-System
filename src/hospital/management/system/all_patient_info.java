package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class all_patient_info extends JFrame {
    all_patient_info(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(176, 219, 250, 255));
        setLayout(null);
        add(panel);


        JTable table = new JTable();
        table.setBounds(10, 40, 500, 400);
        table.setFont(new Font("Open Sans", Font.BOLD, 12));
        table.setBackground(new Color(176, 219, 250, 255));
        table.setForeground(new Color(6, 28, 83));
        panel.add(table);


        try {
            connection c = new connection();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setBounds(12, 15, 80, 15);
        label1.setFont(new Font("Open Sans", Font.BOLD, 14));
        label1.setForeground(new Color(6, 28, 83));
        panel.add(label1);




        setSize(900, 600);
        setLayout(null);
        setLocation(300, 230);
        setVisible(true);

    }
    public static void main(String[] args) {
        new all_patient_info();
    }
}