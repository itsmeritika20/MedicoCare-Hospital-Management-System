package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class search_room extends JFrame {

    search_room(){
        Choice choice;
        JTable table;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(176, 219, 250));
        add(panel);



        JLabel status = new JLabel("Status: ");
        status.setBounds(50, 70, 80, 20);
        status.setFont(new Font("Open Sans",Font.BOLD, 14));
        status.setForeground(new Color(6, 28, 83));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);


        table = new JTable();
        table.setBounds(0, 187, 700, 210);
        table.setBackground(new Color(176, 219, 250));
        table.setForeground(new Color(5, 118, 143));
        panel.add(table);


        try {
            connection c = new connection();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel roomno = new JLabel("Room No: ");
        roomno.setBounds(23, 162, 150, 20);
        roomno.setFont(new Font("Open Sans",Font.BOLD, 14));
        roomno.setForeground(new Color(6, 28, 83));
        panel.add(roomno);

        JLabel availability = new JLabel("Availability: ");
        availability.setBounds(175, 162, 150, 20);
        availability.setFont(new Font("Open Sans",Font.BOLD, 14));
        availability.setForeground(new Color(6, 28, 83));
        panel.add(availability);


        JLabel price = new JLabel("Price: ");
        price.setBounds(430, 162, 150, 20);
        price.setFont(new Font("Open Sans",Font.BOLD, 14));
        price.setForeground(new Color(6, 28, 83));
        panel.add(price);




        JLabel roomtype = new JLabel("Room Type: ");
        roomtype.setBounds(555, 162, 150, 20);
        roomtype.setFont(new Font("Open Sans",Font.BOLD, 14));
        roomtype.setForeground(new Color(6, 28, 83));
        panel.add(roomtype);


        JButton search = new JButton("Search");
        search.setBounds(200, 420, 120, 25);
        //search.setFont(new Font("Open Sans",Font.BOLD, 14));
        search.setBackground(new Color(6, 28, 83));
        search.setForeground(Color.WHITE);
        panel.add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from room where Availability = '"+choice.getSelectedItem()+"'";
                try {
                    connection c = new connection();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380, 420, 120, 25);
        //search.setFont(new Font("Open Sans",Font.BOLD, 14));
        back.setBackground(new Color(6, 28, 83));
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(450, 250);
        setVisible(true);

    }
    public static void main(String[] args) {
        new search_room();
    }
}
