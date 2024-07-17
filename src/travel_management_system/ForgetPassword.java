package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton btnsearch, btnretrieve, btnback;

    ForgetPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //Adding Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setBounds(30, 30, 500, 280);
        p1.setLayout(null);
        add(p1);

        //Username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblusername);

        //Username textfield
        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        //Search
        btnsearch = new JButton("Search");
        btnsearch.setBounds(380, 20, 100, 25);
        btnsearch.setBackground(Color.GRAY);
        btnsearch.setForeground(Color.WHITE);
        btnsearch.setBorder(BorderFactory.createEmptyBorder());
        btnsearch.addActionListener(this);
        p1.add(btnsearch);

        //Name
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(40, 60, 100, 25);
        p1.add(lblname);

        //Name textfield
        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        //Security Question
        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblquestion.setBounds(40, 100, 150, 25);
        p1.add(lblquestion);

        //Security Question textfield
        tfquestion = new JTextField();
        tfquestion.setBounds(220, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        //Answer
        JLabel lblanswer = new JLabel("Security Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(40, 140, 150, 25);
        p1.add(lblanswer);

        //Answer textfield
        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        //Retrieve Button
        btnretrieve = new JButton("Retrieve");
        btnretrieve.setBackground(Color.GRAY);
        btnretrieve.setForeground(Color.WHITE);
        btnretrieve.setBorder(BorderFactory.createEmptyBorder());
        btnretrieve.setBounds(380, 140, 100, 25);
        btnretrieve.addActionListener(this);
        p1.add(btnretrieve);

        //Password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(40, 180, 150, 25);
        p1.add(lblpassword);

        //Password textfield
        tfpassword =  new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        // Back button
        btnback = new JButton("Back");
        btnback.setBackground(Color.GRAY);
        btnback.setForeground(Color.WHITE);
        btnback.setBorder(BorderFactory.createEmptyBorder());
        btnback.setBounds(150, 230, 100, 25);
        btnback.addActionListener(this);
        p1.add(btnback);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnsearch){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == btnretrieve){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == btnback){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
