package AirlineMS;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;

public class Flight_Info {

    JFrame f;

    public Flight_Info(){

        Font font1 = new Font("Bell MT", Font.BOLD, 20);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 21);

        f = new JFrame("Flight Information");
        f.getContentPane().setBackground(Color.WHITE);
        f.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 530);
        f.setLocation(300, 200);
        f.setLayout(null);

        JLabel l = new JLabel("Flight Information", JLabel.CENTER);
        l.setFont(new Font("Elephant", Font.PLAIN, 20));
        l.setBounds(10, 10, 780, 35);
        f.add(l);

        JLabel fcode = new JLabel("Flight Code");
        fcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        fcode.setBounds(50, 70, 200, 30);
        f.add(fcode);

        Choice c = new Choice();
        c.setBounds(300, 70, 90, 20);
        c.setFont(new Font("Tahoma", Font.PLAIN, 15));
        f.add(c);
        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("select f_code from flight");
            while(rs.next()){
                c.add(rs.getString("f_code"));
            }
        }catch (Exception e){e.printStackTrace();}

        JButton show = new JButton("Show");
        show.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        show.setBackground(Color.GREEN);
        show.setBounds(600, 70, 100, 30);
        f.add(show);

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String code = c.getSelectedItem();
//                System.out.println(code);
                JLabel l1 = new JLabel("Flight Code");
                JLabel l1_ = new JLabel();
                l1.setBounds(50, 100, 150, 30);
                l1_.setBounds(210, 100, 150, 30);
                l1.setFont(font1);
                l1_.setFont(font2);
                l1.setVisible(false);
                l1_.setVisible(false);
                f.add(l1);
                f.add(l1_);

                JLabel l2 = new JLabel("Flight Name");
                JLabel l2_ = new JLabel();
                l2.setBounds(50, 150, 150, 30);
                l2_.setBounds(210, 150, 150, 30);
                l2.setFont(font1);
                l2_.setFont(font2);
                l2.setVisible(false);
                l2_.setVisible(false);
                f.add(l2);
                f.add(l2_);

                JLabel l3 = new JLabel("Source");
                JLabel l3_ = new JLabel();
                l3.setBounds(50, 200, 150, 30);
                l3_.setBounds(210, 200, 150, 30);
                l3.setFont(font1);
                l3_.setFont(font2);
                l3.setVisible(false);
                l3_.setVisible(false);
                f.add(l3);
                f.add(l3_);

                JLabel l4 = new JLabel("Destination");
                JLabel l4_ = new JLabel();
                l4.setBounds(50, 250, 250, 30);
                l4_.setBounds(210, 250, 250, 30);
                l4.setFont(font1);
                l4_.setFont(font2);
                l4.setVisible(false);
                l3_.setVisible(false);
                f.add(l4);
                f.add(l4_);

                JLabel l5 = new JLabel("Capacity");
                JLabel l5_ = new JLabel();
                l5.setBounds(50, 300, 250, 30);
                l5_.setBounds(210, 300, 250, 30);
                l5.setFont(font1);
                l5_.setFont(font2);
                l5.setVisible(false);
                l5_.setVisible(false);
                f.add(l5);
                f.add(l5_);

                JLabel l6 = new JLabel("Class Code");
                JLabel l6_ = new JLabel();
                l6.setBounds(50, 350, 250, 30);
                l6_.setBounds(210, 350, 250, 30);
                l6.setFont(font1);
                l6_.setFont(font2);
                l6.setVisible(false);
                l6_.setVisible(false);
                f.add(l6);
                f.add(l6_);

                JLabel l7 = new JLabel("Class Name");
                JLabel l7_ = new JLabel();
                l7.setBounds(50, 400, 250, 30);
                l7_.setBounds(210, 400, 250, 30);
                l7.setFont(font1);
                l7_.setFont(font2);
                l7.setVisible(false);
                l7_.setVisible(false);
                f.add(l7);
                f.add(l7_);


                try {
                    Conn con = new Conn();
                    String sql = "select * from flight where f_code='"+code+"'";
//                    System.out.println(sql);
                    ResultSet rs = con.stmt.executeQuery(sql);
                    if (rs.next()){
                        l1_.setText(rs.getString("f_code"));
                        l1.setVisible(true);
                        l1_.setVisible(true);

                        l2_.setText(rs.getString(2));
                        l2.setVisible(true);
                        l2_.setVisible(true);

                        l3_.setText(rs.getString(3));
                        l3.setVisible(true);
                        l3_.setVisible(true);

                        l4_.setText(rs.getString(4));
                        l4.setVisible(true);
                        l4_.setVisible(true);

                        l5_.setText(rs.getString(5));
                        l5.setVisible(true);
                        l5_.setVisible(true);

                        l6_.setText(rs.getString(6));
                        l6.setVisible(true);
                        l6_.setVisible(true);

                        l7_.setText(rs.getString(7));
                        l7.setVisible(true);
                        l7_.setVisible(true);

                    }
                }catch (Exception e){e.printStackTrace();}
            }
        });
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new Flight_Info();
    }
}
