package hospital.management.system;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {
    patient_discharge(){


        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(176, 219, 250));
        panel.setLayout(null);
        add(panel);


        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 150, 20);
        label.setForeground(new Color(6, 28, 83));
        label.setFont(new Font("Open Sans", Font.BOLD, 20));
        panel.add(label);


        JLabel label1 = new JLabel("Customer ID");
        label1.setBounds(30, 80, 150, 20);
        label1.setFont(new Font("Open Sans", Font.BOLD, 14));
        label1.setForeground(new Color(54, 81, 184));
        panel.add(label1);


        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);


        try {
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("ID_No"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room No");
        label2.setBounds(30, 130, 150, 20);
        label2.setFont(new Font("Open Sans", Font.BOLD, 14));
        label2.setForeground(new Color(54, 81, 184));
        panel.add(label2);


        JLabel rno = new JLabel();
        rno.setBounds(200, 130, 150, 20);
        rno.setFont(new Font("Open Sans", Font.BOLD, 14));
        rno.setForeground(new Color(54, 81, 184));
        panel.add(rno);


        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30, 180, 150, 20);
        label3.setFont(new Font("Open Sans", Font.BOLD, 14));
        label3.setForeground(new Color(54, 81, 184));
        panel.add(label3);


        JLabel intime = new JLabel();
        intime.setBounds(200, 180, 250, 20);
        intime.setFont(new Font("Open Sans", Font.BOLD, 14));
        intime.setForeground(new Color(54, 81, 184));
        panel.add(intime);

        JLabel label4 = new JLabel("Out Time");
        label4.setBounds(30, 230, 150, 20);
        label4.setFont(new Font("Open Sans", Font.BOLD, 14));
        label4.setForeground(new Color(54, 81, 184));
        panel.add(label4);


        Date date = new Date();

        JLabel outtime = new JLabel(""+date);
        outtime.setBounds(200, 230, 250, 20);
        outtime.setFont(new Font("Open Sans", Font.BOLD, 14));
        outtime.setForeground(new Color(54, 81, 184));
        panel.add(outtime);


        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30, 300, 120, 30);
        discharge.setBackground(new Color(6, 28, 83));
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c = new connection();
                try {
                    c.statement.executeUpdate("delete from patient_info where ID_No  = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no = '"+rno.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }

            }
        });

        JButton check = new JButton("Check");
        check.setBounds(170, 300, 120, 30);
        check.setBackground(new Color(6, 28, 83));
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c = new connection();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where ID_No = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        rno.setText(resultSet.getString("room_no"));
                        intime.setText(resultSet.getString("Time"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton back = new JButton("Back");
        back.setBounds(300, 300, 120, 30);
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
        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new patient_discharge();
    }
}
