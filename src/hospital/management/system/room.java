package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends JFrame {
    room(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(176, 219, 250, 255));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);JLabel label = new JLabel(imageIcon1);
        label.setBounds(600, 200, 200, 200);
        panel.add(label);


        JTable table = new JTable();
        table.setBounds(10, 40, 500, 400);
        table.setFont(new Font("Open Sans", Font.BOLD,14));
        table.setBackground(new Color(176, 219, 250, 255));
        panel.add(table);

        try {
            connection c = new connection();
            String q = "select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));



        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12, 15, 80, 15);
        label1.setFont(new Font("Open Sans", Font.BOLD, 14));
        label1.setForeground(new Color(50, 122, 129));
        panel.add(label1);


        JLabel label2 = new JLabel("Availability");
        label2.setBounds(140, 15, 80, 15);
        label2.setFont(new Font("Open Sans", Font.BOLD, 14));
        label2.setForeground(new Color(50, 122, 129));
        panel.add(label2);


        JLabel label3 = new JLabel("Price");
        label3.setBounds(290, 15, 80, 15);
        label3.setFont(new Font("Open Sans", Font.BOLD, 14));
        label3.setForeground(new Color(50, 122, 129));
        panel.add(label3);


        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(400, 15, 80, 15);
        label4.setFont(new Font("Open Sans", Font.BOLD, 14));
        label4.setForeground(new Color(50, 122, 129));
        panel.add(label4);


        JButton back = new JButton("Back");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(new Color(5, 118, 143));
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 230);
        setVisible(true);
    }


    public static void main(String[] args) {
        new room();
    }
}
