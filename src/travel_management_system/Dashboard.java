package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton notepad, aboutus, calculator, payments, viewbookedhotel, bookhotel, addpersonaldetails, viewpersonaldetails, updatepersonaldetails, checkpackages, bookpackages, viewpackages, viewhotels, destinations;

    String username;
    Dashboard(String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 2000, 65);
        add(p1);

        //Adding Dashboard image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 1000);
        add(p2);

        //Add Personal Detail Button
        addpersonaldetails = new JButton("Add Personal Details");
        addpersonaldetails.setBounds(0, 0, 300, 64);
        addpersonaldetails.setBackground(new Color(0, 0, 102));
        addpersonaldetails.setForeground(Color.white);
        addpersonaldetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addpersonaldetails.setMargin(new Insets(0, 0, 0, 65));
        addpersonaldetails.addActionListener(this);
        p2.add(addpersonaldetails);

        //Update Personal Detail Button
        updatepersonaldetails = new JButton("Update Personal Details");
        updatepersonaldetails.setBounds(0, 64, 300, 64);
        updatepersonaldetails.setBackground(new Color(0, 0, 102));
        updatepersonaldetails.setForeground(Color.white);
        updatepersonaldetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatepersonaldetails.setMargin(new Insets(0, 0, 0, 35));
        updatepersonaldetails.addActionListener(this);
        p2.add(updatepersonaldetails);

        //View Personal Detail Button
        viewpersonaldetails = new JButton("View Details");
        viewpersonaldetails.setBounds(0, 128, 300, 64);
        viewpersonaldetails.setBackground(new Color(0, 0, 102));
        viewpersonaldetails.setForeground(Color.white);
        viewpersonaldetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpersonaldetails.setMargin(new Insets(0, 0, 0, 140));
        viewpersonaldetails.addActionListener(this);
        p2.add(viewpersonaldetails);

        //Delete Personal Details
        JButton deletepersonaldetails = new JButton("Delete Personal Details");
        deletepersonaldetails.setBounds(0, 192, 300, 64);
        deletepersonaldetails.setBackground(new Color(0, 0, 102));
        deletepersonaldetails.setForeground(Color.white);
        deletepersonaldetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletepersonaldetails.setMargin(new Insets(0, 0, 0, 40));
        p2.add(deletepersonaldetails);

        //Check Packages
        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0, 256, 300, 64);
        checkpackages.setBackground(new Color(0, 0, 102));
        checkpackages.setForeground(Color.white);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackages.setMargin(new Insets(0, 0, 0, 110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        //Book Packages
        bookpackages = new JButton("Book Package");
        bookpackages.setBounds(0, 320, 300, 64);
        bookpackages.setBackground(new Color(0, 0, 102));
        bookpackages.setForeground(Color.white);
        bookpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackages.setMargin(new Insets(0, 0, 0, 125));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);

        //View Package
        viewpackages = new JButton("View Package");
        viewpackages.setBounds(0, 384, 300, 64);
        viewpackages.setBackground(new Color(0, 0, 102));
        viewpackages.setForeground(Color.white);
        viewpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackages.setMargin(new Insets(0, 0, 0, 125));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);

        //View Hotels
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 448, 300, 64);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 140));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        //Book Hotel
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0, 512, 300, 64);
        bookhotel.setBackground(new Color(0, 0, 102));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotel.setMargin(new Insets(0, 0, 0, 145));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);

        //View Booked Hotel
        viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0, 576, 300, 64);
        viewbookedhotel.setBackground(new Color(0, 0, 102));
        viewbookedhotel.setForeground(Color.white);
        viewbookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedhotel.setMargin(new Insets(0, 0, 0, 80));
        viewbookedhotel.addActionListener(this);
        p2.add(viewbookedhotel);

        //Destinations
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 640, 300, 64);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 140));
        destinations.addActionListener(this);
        p2.add(destinations);

        //Payments
        payments = new JButton("Payments");
        payments.setBounds(0, 704, 300, 64);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 160));
        payments.addActionListener(this);
        p2.add(payments);

        //Calculator
        calculator = new JButton("Calculator");
        calculator.setBounds(0, 768, 300, 64);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0, 0, 0, 160));
        calculator.addActionListener(this);
        p2.add(calculator);

        //Notepad
        notepad = new JButton("Notepad");
        notepad.setBounds(0, 832, 300, 64);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 170));
        notepad.addActionListener(this);
        p2.add(notepad);

        //About
        aboutus = new JButton("About us");
        aboutus.setBounds(0, 896, 300, 64);
        aboutus.setBackground(new Color(0, 0, 102));
        aboutus.setForeground(Color.white);
        aboutus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        aboutus.setMargin(new Insets(0, 0, 0, 165));
        aboutus.addActionListener(this);
        p2.add(aboutus);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(2000, 1200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 2000, 1200);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setFont(new Font("Tahoma", Font.PLAIN, 60));
        text.setForeground(Color.white);
        text.setBackground(new Color(0, 0, 102));
        text.setBounds(500, 70, 1200, 70);
        image.add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addpersonaldetails){
            new AddCustomer(username);
        } else if(ae.getSource() == viewpersonaldetails){
            new ViewCustomer(username);
        } else if(ae.getSource() == updatepersonaldetails){
            new UpdateCustomer(username);
        } else if(ae.getSource() == checkpackages){
            new CheckPackage();
        } else if(ae.getSource() == bookpackages){
            new BookPackage(username);
        } else if(ae.getSource() == viewpackages){
            new ViewPackage(username);
        } else if(ae.getSource() == viewhotels){
            new CheckHotels();
        } else if(ae.getSource() == destinations) {
            new Destinations();
        } else if(ae.getSource() == bookhotel){
            new BookHotel(username);
        } else if(ae.getSource() == viewbookedhotel){
            new ViewBookedHotel(username);
        } else if(ae.getSource() == payments) {
            new Payment();
        } else if(ae.getSource() == calculator){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == notepad){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == aboutus){
            new About();
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}
