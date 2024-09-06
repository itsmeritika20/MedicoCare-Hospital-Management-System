package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    // create constructor
    login() {

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20, 100, 30);
        namelabel.setFont(new Font("Roboto", Font.BOLD, 15));
        namelabel.setForeground(new Color(86, 106, 145));
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Roboto", Font.BOLD, 15));
        password.setForeground(new Color(86, 106, 145));
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Roboto", Font.PLAIN, 15));
        textField.setBackground(new Color(100, 106, 107));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Roboto", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(100, 106, 107));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // for scaled image
        ImageIcon imageIcon1 = new ImageIcon(i1); // i1 = scaled image
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320, -30, 250, 200); // set i1 inside frame
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(new Color(37, 116, 207));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(new Color(37, 116, 207));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(194, 221, 252));
        setSize(750, 300);
        setLocation(450, 270);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // call constructor
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                connection c = new connection();
                String user = textField.getText();
                String pass = jPasswordField.getText();

                String q = "select * from login where ID = '" + user + "' and password = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            System.exit(10);
        }
    }
}
