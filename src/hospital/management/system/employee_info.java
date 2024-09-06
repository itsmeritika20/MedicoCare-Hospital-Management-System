package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class employee_info extends JFrame {
    employee_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(176, 219, 250, 255));
        panel.setLayout(null);
        add(panel);


        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setBackground(new Color(176, 219, 250, 255));
        table.setFont(new Font("Open Sans",Font.BOLD, 16));
        panel.add(table);

        try {
            connection c = new connection();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(50, 9, 70, 20);
        label1.setFont(new Font("Open Sans", Font.BOLD, 16));
        label1.setForeground(new Color(6, 28, 83));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(230, 9, 70, 20);
        label2.setFont(new Font("Open Sans", Font.BOLD, 16));
        label2.setForeground(new Color(6, 28, 83));
        panel.add(label2);

        JLabel label3 = new JLabel("Mobile No");
        label3.setBounds(375, 9, 120, 20);
        label3.setFont(new Font("Open Sans", Font.BOLD, 16));
        label3.setForeground(new Color(6, 28, 83));
        panel.add(label3);


        JLabel label4 = new JLabel("Salary");
        label4.setBounds(550, 9, 120, 20);
        label4.setFont(new Font("Open Sans", Font.BOLD, 16));
        label4.setForeground(new Color(6, 28, 83));
        panel.add(label4);


        JLabel label5 = new JLabel("Email");
        label5.setBounds(690, 9, 120, 20);
        label5.setFont(new Font("Open Sans", Font.BOLD, 16));
        label5.setForeground(new Color(6, 28, 83));
        panel.add(label5);


        JLabel label6 = new JLabel("Aadhaar No");
        label6.setBounds(850, 9, 120, 20);
        label6.setFont(new Font("Open Sans", Font.BOLD, 16));
        label6.setForeground(new Color(6, 28, 83));
        panel.add(label6);


        JButton btn = new JButton("Back");
        btn.setBounds(350, 500, 120, 30);
        btn.setBackground(new Color(40, 77, 90));
        btn.setForeground(Color.WHITE);
        panel.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(1000, 600);
        setLayout(null);
        setLocation(350, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new employee_info();
    }
}
