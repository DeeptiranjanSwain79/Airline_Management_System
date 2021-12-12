package AirlineMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Mainframe implements ActionListener{
    JFrame f;
    Mainframe(){
        f = new JFrame("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        f.setForeground(Color.CYAN);
        f.setSize(1600, 820);
        f.setLocation(0, 0);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 820, Image.SCALE_DEFAULT);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 0, 1600, 820);
        f.add(img);

        JLabel title = new JLabel("AIR INDIA WELCOMES YOU", JLabel.CENTER);
        title.setBounds(10, 25, 1680, 50);
        title.setFont(new Font("Elephant", Font.BOLD, 45));
        title.setForeground(Color.RED);
        img.add(title);

        JMenuBar mb = new JMenuBar();
        f.setJMenuBar(mb);

        JMenu airlineSystem = new JMenu("AIRLINE SYSTEM");
        airlineSystem.setForeground(Color.BLUE);
        mb.add(airlineSystem);

        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        airlineSystem.add(flightDetails);

        JMenuItem reservationDetails = new JMenuItem("Add Customer");
        reservationDetails.addActionListener(this);
        airlineSystem.add(reservationDetails);

        JMenu ticket = new JMenu("Ticket");
        ticket.setForeground(Color.RED);
        mb.add(ticket);

        JMenuItem cancellation = new JMenuItem("Cancellation");
        cancellation.addActionListener(this);
       ticket.add(cancellation);

        JMenu misc = new JMenu("MISC");
        misc.setForeground(Color.BLUE);
        mb.add(misc);


        JMenuItem airline = new JMenuItem("Airline");
        airline.addActionListener(this);
        misc.add(airline);


        JMenu logout = new JMenu("Log Out");
        logout.setForeground(Color.RED);
        mb.add(logout);

        JMenuItem l = new JMenuItem("Log Out");
        l.addActionListener(this);
        logout.add(l);

        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if (msg.equalsIgnoreCase("Flight Details")){
            new Flight_Info();
        }else if (msg.equalsIgnoreCase("Add Customer")){
            new Add_Customer();
        }else if (msg.equalsIgnoreCase("Cancellation")){
            new Cancel();
        }else if (msg.equalsIgnoreCase("Log Out")){
            f.setVisible(false);
            new login();
        }else if(msg.equalsIgnoreCase("Airline")){
            new Airline();
        }
    }

    public static void main(String[] args) {
        new Mainframe();
    }
}
