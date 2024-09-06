package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class new_patient extends JFrame implements ActionListener {


    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldComplications, textFieldDeposit;
    JRadioButton r1, r2, r3;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    new_patient(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(176, 219, 250, 255));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);


        JLabel labelName = new JLabel("New Patient Form");
        labelName.setBounds(118, 20, 260, 53);
        labelName.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(labelName);


        JLabel labelID = new JLabel("ID type. ");
        labelID.setBounds(35, 76, 200, 20);
        labelID.setFont(new Font("Open Sans", Font.BOLD, 16));
        labelID.setForeground(new Color(6, 28, 83));
        panel.add(labelID);


        comboBox = new JComboBox(new String[] {"Aadhaar Card", "Voter ID", "Pan Card", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(90, 160, 184));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(comboBox);



        JLabel labelNumber = new JLabel("ID no. ");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Open Sans", Font.BOLD, 16));
        labelNumber.setForeground(new Color(6, 28, 83));
        panel.add(labelNumber);


        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);


        JLabel labelName1 = new JLabel("Name: ");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Open Sans", Font.BOLD, 16));
        labelName1.setForeground(new Color(6, 28, 83));
        panel.add(labelName1);


        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);


        JLabel labelGender = new JLabel("Gender: ");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Open Sans", Font.BOLD, 16));
        labelGender.setForeground(new Color(6, 28, 83));
        panel.add(labelGender);


        r1 = new JRadioButton("Female");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(90, 160, 184));
        r1.setBounds(271, 191, 80, 15);
        panel.add(r1);


        r2 = new JRadioButton("Male");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(90, 160, 184));
        r2.setBounds(355, 191, 80, 15);
        panel.add(r2);


        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        r3.setForeground(Color.WHITE);
        r3.setBackground(new Color(90, 160, 184));
        r3.setBounds(439, 191, 80, 15);
        panel.add(r3);



        JLabel labelComplications = new JLabel("Name of Complications: ");
        labelComplications.setBounds(35, 231, 200, 14);
        labelComplications.setFont(new Font("Open Sans", Font.BOLD, 16));
        labelComplications.setForeground(new Color(6, 28, 83));
        panel.add(labelComplications);


        textFieldComplications = new JTextField();
        textFieldComplications.setBounds(271, 231, 150, 20);
        panel.add(textFieldComplications);



        JLabel labelRoom = new JLabel("Room: ");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Open Sans", Font.BOLD, 16));
        labelRoom.setForeground(new Color(6, 28, 83));
        panel.add(labelRoom);



        c1 = new Choice();
        try{
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Open Sans", Font.BOLD, 16));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(6, 28, 83));
        panel.add(c1);


        JLabel labelDate = new JLabel("Time: ");
        labelDate.setBounds(35, 316, 200, 14);
        labelDate.setFont(new Font("Open Sans", Font.BOLD, 16));
        labelDate.setForeground(new Color(6, 28, 83));
        panel.add(labelDate);


        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271, 316, 280, 14);
        date.setForeground(new Color(35, 123, 233));
        date.setFont(new Font("Open Sans", Font.BOLD, 14));
        panel.add(date);



        JLabel labelDeposit = new JLabel("Deposit: ");
        labelDeposit.setBounds(35, 359, 200, 25);
        labelDeposit.setFont(new Font("Open Sans", Font.BOLD, 16));
        labelDeposit.setForeground(new Color(6, 28, 83));
        panel.add(labelDeposit);


        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposit);


        b1 = new JButton("Add");
        b1.setBounds(100, 430, 120, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(6, 28, 83));
        b1.addActionListener(this);
        panel.add(b1);


        b2 = new JButton("Back");
        b2.setBounds(260, 430, 120, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(6, 28, 83));
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new new_patient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            connection c = new connection();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN = "Female";
            }else if(r2.isSelected()){
                radioBTN = "Male";
            }else if(r3.isSelected()){
                radioBTN = "Other";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldComplications.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposit.getText();

            try{
                String q = "insert into patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"', '"+s8+"')";
                String q1 = "update room set Availability = 'Occupied' where room_no = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}
