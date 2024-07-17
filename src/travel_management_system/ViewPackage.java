package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {
    JButton btnback;

    ViewPackage(String username){
        setBounds(450,200,900,450);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 300, 30);
        add(text);

        //Username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        //Package Name
        JLabel lblpkg = new JLabel("Package");
        lblpkg.setBounds(30, 90, 150, 25);
        add(lblpkg);

        JLabel labelpkg = new JLabel();
        labelpkg.setBounds(220, 90, 150, 25);
        add(labelpkg);

        //Number of Person
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(30, 130, 150, 25);
        add(lblperson);

        JLabel labelperson = new JLabel();
        labelperson.setBounds(220, 130, 150, 25);
        add(labelperson);

        //id
        JLabel lblid = new JLabel("Name");
        lblid.setBounds(30, 170, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);

        //ID Number
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 210, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 210, 150, 25);
        add(labelnumber);

        //Phone Number
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(30, 250, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 250, 150, 25);
        add(labelphone);

        //Price
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30, 290, 150, 25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 25);
        add(labelprice);

        //Back Button
        btnback = new JButton("Back");
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.WHITE);
        btnback.setBounds(130, 360, 100, 25);
        btnback.addActionListener(this);
        add(btnback);

        //Adding Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

        //Connection with MySQL
        try {
            Conn c = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpkg.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelperson.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnback){
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new ViewPackage("Anuj1716");
    }
}
