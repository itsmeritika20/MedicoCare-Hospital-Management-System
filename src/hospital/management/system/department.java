package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class department extends JFrame {
    department(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(176, 219, 250, 255));
        add(panel);


        JTable table = new JTable();
        table.setBounds(0, 40, 700, 350);
        table.setBackground(new Color(176, 219, 250, 255));
        table.setForeground(new Color(40, 77, 90));
        table.setFont(new Font("Open Sans", Font.BOLD, 16));
        panel.add(table);


        try{
            connection c = new connection();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("Department");
        label1.setBounds(145, 11, 105, 20);
        label1.setFont(new Font("Open Sans", Font.BOLD, 16));
        panel.add(label1);


        JLabel label2 = new JLabel("Mobile No.");
        label2.setBounds(430, 11, 148, 20);
        label2.setFont(new Font("Open Sans", Font.BOLD, 16));
        panel.add(label2);


        JButton b1 = new JButton("Back");
        b1.setBounds(400, 410, 130, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(50, 122, 129));
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(350, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new department();
    }
}
