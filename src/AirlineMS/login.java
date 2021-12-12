package AirlineMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class login implements ActionListener {
    JFrame f;
    JTextField tf;
    JPasswordField pf;
    JButton submit, reset, close;

    public login(){

        Font font1 = new Font("Bell MT", Font.BOLD, 25);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 21);

        f = new JFrame("Login Page");
        f.setSize(500, 300);
        f.setLocation(400, 250);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(50, 50, 150, 30);
        l1.setFont(font1);
        f.add(l1);

        tf = new JTextField();
        tf.setBounds(270, 50, 200, 30);
        tf.setFont(font2);
        f.add(tf);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(50, 120, 150, 30);
        l2.setFont(font1);
        f.add(l2);

        pf = new JPasswordField();
        pf.setBounds(270, 120, 200, 30);
        pf.setFont(font2);
        f.add(pf);

        submit = new JButton("Submit");
        submit.setBounds(200, 200, 100, 35);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setFont(font2);
        submit.addActionListener(this);
        f.add(submit);

        reset = new JButton("Reset");
        reset.setBounds(50, 200, 100, 35);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setFont(font2);
        reset.addActionListener(this);
        f.add(reset);

        close = new JButton("Close");
        close.setBounds(350, 200, 100, 35);
        close.setBackground(Color.RED);
        close.setForeground(Color.GREEN);
        close.setFont(font2);
        close.addActionListener(this);
        f.add(close);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String username_ = tf.getText();
            String password_ = pf.getText();

            try {
                Conn c = new Conn();
                ResultSet rs =c.stmt.executeQuery("select * from login where username='"+username_+"' and password='"+password_+"'");
                if (rs.next()){
                    new Mainframe();

                    f.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                    f.setVisible(false);
                }
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == reset){
            tf.setText("");
            pf.setText("");
        }else if (ae.getSource() == close){
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
