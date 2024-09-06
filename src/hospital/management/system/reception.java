package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame {
    reception(){


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(new Color(53, 153, 161));
        add(panel);


        JPanel panel1 = new JPanel();
        panel.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(53, 153, 161));
        add(panel1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/doctor.png"));
        Image image = i1.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300, 0, 160, 160);
        panel1.add(label);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/hospital.png"));
        Image image1 = i11.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(1000, 50, 160, 160);
        panel1.add(label1);


        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30, 15, 200, 30);
        btn1.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new new_patient();
            }
        });


        JButton btn2 = new JButton("Room");
        btn2.setBounds(30, 58, 200, 30);
        btn2.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn2);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new room();
            }
        });


        JButton btn3 = new JButton("Department");
        btn3.setBounds(30, 100, 200, 30);
        btn3.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn3);

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new department();
            }
        });


        JButton btn4 = new JButton("All employee info");
        btn4.setBounds(270, 15, 200, 30);
        btn4.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn4);

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new employee_info();
            }
        });


        JButton btn5 = new JButton("Patient info");
        btn5.setBounds(270, 58, 200, 30);
        btn5.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn5);

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new all_patient_info();
            }
        });


        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270, 100, 200, 30);
        btn6.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn6);

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();
            }
        });


        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(510, 15, 200, 30);
        btn7.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn7);

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });


        JButton btn8 = new JButton("Ambulance");
        btn8.setBounds(510, 58, 200, 30);
        btn8.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn8);

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(270, 100, 200, 30);
        btn9.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn9);

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JButton btn10 = new JButton("Logout");
        btn10.setBounds(750, 15, 200, 30);
        btn10.setBackground(new Color(248, 193, 224, 255));
        panel1.add(btn10);

        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setSize(1950,1090);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new reception();
    }
}
