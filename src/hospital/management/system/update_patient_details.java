package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {


    update_patient_details(){



        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(176, 219, 250));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);


        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 260, 25);
        label1.setFont(new Font("Open Sans",Font.BOLD, 20));
        label1.setForeground(new Color(6, 28, 83));
        panel.add(label1);


        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25, 88, 100, 14);
        label2.setFont(new Font("Open Sans",Font.PLAIN, 14));
        label2.setForeground(new Color(6, 28, 83));
        panel.add(label2);


        Choice choice = new Choice();
        choice.setBounds(248, 85, 100, 25);
        panel.add(choice);

        try {
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No :");
        label3.setBounds(25, 129, 100, 14);
        label3.setFont(new Font("Open Sans",Font.PLAIN, 14));
        label3.setForeground(new Color(6, 28, 83));
        panel.add(label3);

        JTextField textFieldr = new JTextField();
        textFieldr.setBounds(248, 129, 140, 20);
        panel.add(textFieldr);


        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25, 174, 100, 14);
        label4.setFont(new Font("Open Sans",Font.PLAIN, 14));
        label4.setForeground(new Color(6, 28, 83));
        panel.add(label4);

        JTextField textFieldintime = new JTextField();
        textFieldintime.setBounds(248, 174, 140, 20);
        panel.add(textFieldintime);


        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25, 216, 120, 14);
        label5.setFont(new Font("Open Sans",Font.PLAIN, 14));
        label5.setForeground(new Color(6, 28, 83));
        panel.add(label5);

        JTextField textFieldamount = new JTextField();
        textFieldamount.setBounds(248, 216, 140, 20);
        panel.add(textFieldamount);

        JLabel label6 = new JLabel("Due Amount (Rs) :");
        label6.setBounds(25, 260, 120, 14);
        label6.setFont(new Font("Open Sans",Font.PLAIN, 14));
        label6.setForeground(new Color(6, 28, 83));
        panel.add(label6);

        JTextField textFielddue = new JTextField();
        textFielddue.setBounds(248, 261, 140, 20);
        panel.add(textFielddue);


        JButton check = new JButton("Check");
        check.setBounds(281, 378, 89, 23);
        check.setBackground(new Color(6, 28, 83));
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try {
                    connection c = new connection();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldr.setText(resultSet.getString("room_no"));
                        textFieldintime.setText(resultSet.getString("Time"));
                        textFieldamount.setText(resultSet.getString("Deposit"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '"+textFieldr.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldamount.getText());
                        textFielddue.setText(""+amountPaid);
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(56, 378, 89, 23);
        update.setBackground(new Color(6, 28, 83));
        update.setForeground(Color.WHITE);
        panel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connection c = new connection();
                    String q = choice.getSelectedItem();
                    String room = textFieldr.getText();
                    String time = textFieldintime.getText();
                    String amount = textFieldamount.getText();
                    c.statement.executeUpdate("update patient_info set room_no = '"+room+"', Time = '"+time+"', Deposit = '"+amount+"' where name = '"+q+"' ");
                    JOptionPane.showMessageDialog(null, "Updated Successfully" );
                    setVisible(false);


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back = new JButton("Back");
        back.setBounds(168, 378, 89, 23);
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
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new update_patient_details();
    }
}
