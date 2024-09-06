package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ambulance extends JFrame {
        ambulance(){

            JPanel panel = new JPanel();
            panel.setBounds(5, 5, 900, 590);
            panel.setBackground(new Color(176, 219, 250, 255));
            setLayout(null);
            add(panel);

            JTable table = new JTable();
            table.setBounds(400, 600, 900, 450);
            table.setFont(new Font("Open Sans", Font.BOLD, 12));
            table.setBackground(new Color(176, 219, 250, 255));
            table.setForeground(new Color(6, 28, 83));
            panel.add(table);

            /*try {
                connection c = new connection();
                String q = "select * from patient_info";
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception e){
                e.printStackTrace();
            }





            JTable table = new JTable();
            table.setBounds(10, 40, 900, 450);
            table.setBackground(new Color(176, 219, 250, 255));
            table.setForeground(new Color(6, 28, 83));
            table.setFont(new Font("Open Sans", Font.BOLD, 12));
            panel.add(table);*/

            try {
                connection c = new connection();
                String q = "select * from ambulance";
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception e){
                e.printStackTrace();
            }

            JLabel label1 = new JLabel("Name");
            label1.setBounds(31, 11, 100, 14);
            label1.setFont(new Font("Open Sans", Font.BOLD, 12));
            panel.add(label1);

            JLabel label2 = new JLabel("Gender");
            label2.setBounds(150, 11, 100, 14);
            label2.setFont(new Font("Open Sans", Font.BOLD, 12));
            panel.add(label2);

            JLabel label3 = new JLabel("Car_name");
            label3.setBounds(270, 11, 100, 14);
            label3.setFont(new Font("Open Sans", Font.BOLD, 12));
            panel.add(label3);

            JLabel label4 = new JLabel("Available");
            label4.setBounds(360, 11, 100, 14);
            label4.setFont(new Font("Open Sans", Font.BOLD, 12));
            panel.add(label4);

            JLabel label5 = new JLabel("Location");
            label5.setBounds(480, 11, 100, 14);
            label5.setFont(new Font("Open Sans", Font.BOLD, 12));
            panel.add(label5);





            JButton btn = new JButton("Back");
            btn.setBounds(450, 610, 120, 30);
            btn.setBackground(new Color(6, 28, 83));
            btn.setForeground(Color.WHITE);
            panel.add(btn);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            setUndecorated(true);
            setSize(900, 600);
            setLayout(null);
            setLocation(300, 200);
            setVisible(true);
        }
    public static void main(String[] args) {
        new ambulance();
    }
}
