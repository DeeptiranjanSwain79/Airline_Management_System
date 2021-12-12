package AirlineMS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;

public class Add_Customer extends JFrame implements ActionListener {

    JTextField pnr, name, address, nationality, phone, passport;
    Choice c, code;
    JButton pay, cancel;

    public Add_Customer(){
        Font font1 = new Font("Bell MT", Font.BOLD, 20);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 21);

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setForeground(Color.BLUE);
        setTitle("ADD CUSTOMER DETAILS");
        setSize(750, 540);
        setLocation(200, 100);
        setLayout(null);

        JLabel l1 = new JLabel("Passport No.");
        l1.setFont(font1);
        l1.setBounds(60, 80, 150, 30);
        add(l1);
        passport = new JTextField();
        passport.setFont(font2);
        passport.setBounds(220, 80, 150, 30);
        add(passport);

        JLabel l2 = new JLabel("PNR No.");
        l2.setFont(font1);
        l2.setBounds(60, 120, 150, 30);
        add(l2);
        pnr = new JTextField();
        pnr.setFont(font2);
        pnr.setBounds(220, 120, 150, 30);
        add(pnr);

        JLabel l3 = new JLabel("Address");
        l3.setFont(font1);
        l3.setBounds(60, 160, 150, 30);
        add(l3);
        address = new JTextField();
        address.setFont(font2);
        address.setBounds(220, 160, 150, 30);
        add(address);

        JLabel l4 = new JLabel("Nationality");
        l4.setFont(font1);
        l4.setBounds(60, 200, 150, 30);
        add(l4);
        nationality = new JTextField();
        nationality.setFont(font2);
        nationality.setBounds(220, 200, 150, 30);
        add(nationality);

        JLabel l5 = new JLabel("Name");
        l5.setFont(font1);
        l5.setBounds(60, 240, 150, 30);
        add(l5);
        name = new JTextField();
        name.setFont(font2);
        name.setBounds(220, 240, 150, 30);
        add(name);

        JLabel l6 = new JLabel("Passport No.");
        l6.setFont(font1);
        l6.setBounds(60, 280, 150, 30);
        add(l6);
        c = new Choice();
        c.setFont(font2);
        c.setBounds(220, 280, 150, 30);
        c.add("Male");
        c.add("Female");
        c.add("Transgender");
        add(c);

        JLabel l7 = new JLabel("Phone Number");
        l7.setFont(font1);
        l7.setBounds(60, 320, 150, 30);
        add(l7);
        phone = new JTextField();
        phone.setFont(font2);
        phone.setBounds(220, 320, 150, 30);
        add(phone);
        
        JLabel title = new JLabel("ADD CUSTOMER DETAILS", JLabel.CENTER);
        title.setFont(new Font("Elephant", Font.PLAIN, 20));
        title.setBounds(10, 10, 730, 30);
        add(title);

        JLabel l8 = new JLabel("Flight Code");
        l8.setBounds(60, 360, 150, 30);
        l8.setFont(font1);
        add(l8);

        code = new Choice();
        code.setBounds(220, 360, 150, 30);
        code.setFont(font2);
        add(code);
        try{
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("Select * from flight");
            while (rs.next()){
                code.add(rs.getString("f_code"));
            }
        }catch (Exception e){e.printStackTrace();}

        pay = new JButton("Proceed to Payment");
        pay.setBounds(150, 450, 200, 40);
        pay.setForeground(Color.BLUE);
        pay.setBackground(Color.GREEN);
        pay.addActionListener( this);
        pay.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        add(pay);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 450, 100, 40);
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.RED);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/emp.png"));
        JLabel img = new JLabel(i1);
        img.setBounds(450, 80, 280, 410);
        add(img);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == cancel){
            this.setVisible(false);
//            System.out.println("Hello");
        }else if(ae.getSource() == pay){
            String pnr_ = pnr.getText();
            String passport_ = passport.getText();
            String address_ = address.getText();
            String nationality_ = nationality.getText();
            String name_ = name.getText();
            String gender_ = c.getSelectedItem();
            String phone_ = phone.getText();
            String code_ = code.getSelectedItem();
//            System.out.println(code_);

            try{
                Conn con = new Conn();
                String q = "insert into passenger (pnr_no, address, nationality, name, gender, phone, passport_no, fl_code) values " +
                        "('"+pnr_+"', '"+address_+"', '"+nationality_+"', '"+name_+"', '"+gender_+"', '"+phone_+"', '"+passport_+"', '"+code_+"')";
                System.out.println(q);
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Slot Confirmed successfully");
                new Payment(pnr_, code_);
                this.setVisible(false);
            }catch (Exception e){e.printStackTrace();}


        }
    }

    public static void main(String[] args) {
        new Add_Customer();
    }
}
