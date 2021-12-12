package AirlineMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Airline extends JFrame implements ActionListener {
    JTextField tf;
    JPasswordField pf;
    JButton save, cancel;

    Airline(){
        super("New Admin");
        setLayout(null);
        setBounds(300, 200, 500, 300);

        Font font1 = new Font("Bell MT", Font.BOLD, 20);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 20);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        JLabel l1 = new JLabel("Enter Username");
        l1.setBounds(50, 50, 200, 30);
        l1.setFont(font1);
        add(l1);
        tf = new JTextField();
        tf.setBounds(300, 50, 150, 30);
        tf.setFont(font2);
        add(tf);

        JLabel l2 = new JLabel("Enter Password");
        l2.setBounds(50, 100, 200, 30);
        l2.setFont(font1);
        add(l2);
        pf = new JPasswordField();
        pf.setBounds(300, 100, 150, 30);
        pf.setFont(font2);
        add(pf);

        save = new JButton("Save");
        save.setFont(font3);
        save.setBackground(Color.BLUE);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        save.setBounds(100, 200, 100, 40);
        add(save);

        cancel = new JButton("Cancel");
        cancel.setFont(font3);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setBounds(250, 200, 100, 40);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == cancel){
            this.setVisible(false);
        }else if (ae.getSource() == save){
            String username = tf.getText();
            String password = pf.getText();

            try {
                Conn con = new Conn();
                con.stmt.executeUpdate("insert into login (username, password) values ('"+username+"', '"+password+"')");
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
            }catch (Exception e){e.printStackTrace();}

        }
    }

    public static void main(String[] args) {
        new Airline();
    }
}
