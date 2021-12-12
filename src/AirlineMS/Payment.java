package AirlineMS;

import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.Date;

public class Payment implements ActionListener {
    JFrame f;
    JTextField amount, tid;
    JLabel pn, phone;
    JButton pay, exit;
    String pnr, code;
    Choice c;
    Date dt = new Date();

    Payment(String pnr, String code){
        this.pnr = pnr;
        this.code = code;

        Font font1 = new Font("Bell MT", Font.BOLD, 20);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 20);

        f= new JFrame("PAY");
        f.setBounds(380, 150, 500, 350);
        f.setLayout(null);

        JLabel p = new JLabel("PNR No");
        p.setBounds(30, 30, 200, 30);
        p.setFont(font1);
        f.add(p);

        pn = new JLabel();
        pn.setBounds(250, 30, 200, 30);
        pn.setFont(font2);
        f.add(pn);

        JLabel ph = new JLabel("Phone");
        ph.setFont(font1);
        ph.setBounds(30, 70, 200, 30);
        f.add(ph);

        phone = new JLabel();
        phone.setBounds(250, 70, 200, 30);
        phone.setFont(font2);
        f.add(phone);

        try {
            Conn con = new Conn();
            String q = "select * from passenger where pnr_no='"+pnr+"'";
            ResultSet rs = con.stmt.executeQuery(q);
            System.out.println(q);

            if (rs.next()){
                String pnr_ = rs.getString("pnr_no");
                String  phone_ = rs.getString("phone");
                pn.setText(pnr_);
                phone.setText(phone_);

            }

            pn.setText(pnr);
        }catch (Exception e){e.printStackTrace();}

        JLabel m = new JLabel("Mode of Payment");
        m.setBounds(30, 110, 200, 30);
        m.setFont(font1);
        f.add(m);


        c = new Choice();
        c.setFont(font2);
        c.setBounds(250, 110, 200, 30);
        c.add("Online");
        c.add("Offline");
        f.add(c);

        JLabel t = new JLabel("Transaction ID");
        t.setFont(font1);
        t.setBounds(30, 150, 200, 30);
        f.add(t);
        tid = new JTextField();
        tid.setBounds(250, 150, 200, 30);
        tid.setFont(font2);
        f.add(tid);

        JLabel a = new JLabel("Amount");
        a.setFont(font1);
        a.setBounds(30, 190, 200, 30);
        f.add(a);
        amount = new JTextField();
        amount.setBounds(250, 190, 200, 30);
        amount.setFont(font2);
        f.add(amount);

        pay = new JButton("Pay");
        pay.setBounds(50, 250, 100, 40);
        pay.setForeground(Color.BLUE);
        pay.setBackground(Color.GREEN);
        pay.addActionListener( this);
        pay.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        f.add(pay);

        exit = new JButton("Exit");
        exit.setBounds(200, 250, 100, 40);
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.RED);
        exit.addActionListener(this);
        exit.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        f.add(exit);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pay){
            String mop_ = c.getSelectedItem();
            String tid_ = tid.getText();
            String amount_ = amount.getText();

            try {
                Conn con = new Conn();
                String q = "insert into payment (pnr_no, phone, mop, transaction_id, amount, date) values" +
                        "('"+pnr+"', '"+phone.getText()+"', '"+mop_+"', '"+tid_+"', '"+amount_+"', '"+dt+"')";
//                System.out.println(q);
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                new Journey_Details(pnr, code);
                f.setVisible(false);
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == exit){
            try {
                Conn con = new Conn();
                String q = "delete from passenger where pnr_no='"+pnr+"'";
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Slot Deleted Successfully");
            }catch (Exception e){e.printStackTrace();}
        }

    }

    public static void main(String[] args) {
        new Payment("", "");
    }
}
