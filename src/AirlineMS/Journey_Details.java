package AirlineMS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;

public class Journey_Details implements ActionListener {
    JFrame f;
    String pnr, code, source, destination;
    JTextField ticket, jdate;
    JLabel pn, src, dst, cd;
    JButton save;

    Journey_Details(String pnr, String code){
        this.pnr = pnr;
        this.code = code;

        Font font1 = new Font("Bell MT", Font.BOLD, 25);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 21);

        f = new JFrame("Journey Details");
        f.setSize(520, 450);
        f.setLocation(400, 150);
        f.setLayout(null);


        JLabel l1 = new JLabel("PNR No");
        l1.setBounds(30, 50, 200, 30);
        l1.setFont(font1);
        f.add(l1);
        pn = new JLabel();
        pn.setText(pnr);
        pn.setBounds(250, 50, 200, 30);
        pn.setFont(font2);
        f.add(pn);

        JLabel l2 = new JLabel("Ticket No");
        l2.setBounds(30, 100, 200, 30);
        l2.setFont(font1);
        f.add(l2);
        ticket = new JTextField();
        ticket.setFont(font2);
        ticket.setBounds(250, 100, 200, 30);
        f.add(ticket);

        JLabel l3 = new JLabel("Journey Date");
        l3.setBounds(30, 150, 200, 30);
        l3.setFont(font1);
        f.add(l3);
        jdate = new JTextField();
        jdate.setFont(font2);
        jdate.setBounds(250, 150, 200, 30);
        f.add(jdate);

        JLabel l4 = new JLabel("Flight Code");
        l4.setBounds(30, 200, 200, 30);
        l4.setFont(font1);
        f.add(l4);
        cd = new JLabel();
        cd.setText(code);
        cd.setBounds(250, 200, 200, 30);
        cd.setFont(font2);
        f.add(cd);


        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("select * from flight where f_code='"+code+"'");
            if (rs.next()){
                source = rs.getString("source");
                destination =  rs.getString("destination");
                System.out.println(source);
                System.out.println(destination);
            }
        }catch (Exception e){e.printStackTrace();}

        JLabel l5 = new JLabel("Source");
        l5.setBounds(30, 250, 200, 30);
        l5.setFont(font1);
        f.add(l5);
        src = new JLabel(source);
        src.setBounds(250, 250, 200, 30);
        src.setFont(font2);
        f.add(src);

        JLabel l6 = new JLabel("Source");
        l6.setBounds(30, 300, 200, 30);
        l6.setFont(font1);
        f.add(l6);
        dst = new JLabel(destination);
        dst.setBounds(250, 300, 200, 30);
        dst.setFont(font2);
        f.add(dst);

        save = new JButton("Save");
        save.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        save.setBackground(Color.GREEN);
        save.setForeground(Color.BLACK);
        save.addActionListener(this);
        save.setBounds(150, 350, 100, 40);
        f.add(save);

        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == save){
            String pnr_ = pn.getText();
            String ticket_ = ticket.getText();
            String jdate_ = jdate.getText();
            String fcode_ = cd.getText();
            String src_ = src.getText();
            String dst_ = dst.getText();

            try {
                Conn con = new Conn();
                String q = "insert into reservation (pnr_no, ticket, jny_date, source, destination, f_code) values " +
                        "('"+pnr_+"', '"+ticket_+"', '"+jdate_+"', '"+fcode_+"', '"+src_+"', '"+dst_+"')";
//                System.out.println(q);
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                f.setVisible(false);
            }catch (Exception e){e.printStackTrace();}

        }
    }

    public static void main(String[] args){
        new Journey_Details("77777", "1007");
    }
}
