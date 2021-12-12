package AirlineMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Cancel implements ActionListener{
    JFrame f;
    JTextField pnr, passport, code;
    JButton cancel, exit;
    Date dt = new Date();

    Cancel(){
        Font font1 = new Font("Bell MT", Font.BOLD, 25);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 21);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        f = new JFrame("Ticket Cancellation");
        f.setBounds(300, 150, 500, 350);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("Ticket Cancellation", JLabel.CENTER);
        title.setFont(new Font("Elephant", Font.PLAIN, 25));
        title.setBounds(10, 10, 480, 50);
        f.add(title);

        JLabel l1 = new JLabel("PNR no");
        l1.setBounds(50, 50, 200, 30);
        l1.setFont(font1);
        f.add(l1);
        pnr = new JTextField();
        pnr.setBounds(300, 50, 150, 30);
        pnr.setFont(font2);
        f.add(pnr);

        JLabel l2 = new JLabel("Card Number");
        l2.setBounds(50, 100, 200, 30);
        l2.setFont(font1);
        f.add(l2);
        passport = new JTextField();
        passport.setBounds(300, 100, 150, 30);
        passport.setFont(font2);
        f.add(passport);

        JLabel l3 = new JLabel("Flight Code");
        l3.setBounds(50, 150, 200, 30);
        l3.setFont(font1);
        f.add(l3);
        code = new JTextField();
        code.setBounds(300, 150, 150, 30);
        code.setFont(font2);
        f.add(code);

        cancel = new JButton("Cancel");
        cancel.setFont(font3);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(200, 200, 100, 40);
        f.add(cancel);

        exit = new JButton("Exit");
        exit.setFont(font3);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        exit.setBounds(200, 250, 100, 40);
        f.add(exit);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            f.setVisible(false);
        }else if (ae.getSource() == cancel){
            String pnr_ = pnr.getText();
            String passport_ = passport.getText();
            String code_ = code.getText();
            String dt_ = dt.toString();

            String q1 = "insert into cancellation (pnr_no, passport_no, cancellation_date, fli_code) values ('"+pnr_+"', '"+passport_+"'," +
                    "'"+dt_+"', '"+code_+"')";
            String q2 = "delete from passenger where passport_no='"+passport_+"'";
            try {
                Conn c = new Conn();
                c.stmt.executeUpdate(q1);
                c.stmt.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully");
            }catch (Exception e){e.printStackTrace();}

        }
    }

    public static void main(String[] args) {
        new Cancel();
    }
}
