package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername, tfpassword;
    JButton login, signup, forget_password;

    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        // Username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(lblusername);

        // Username Textfield
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        //Password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 30);
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(lblpassword);

        //Password Textfield
        tfpassword = new JPasswordField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        //Login Button
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setFont(new Font("Tahoma", Font.PLAIN, 15));
        login.addActionListener(this);
        p2.add(login);

        //SignUp
        signup = new JButton("SignUp");
        signup.setBounds(230, 200, 130, 30);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.setFont(new Font("Tahoma", Font.PLAIN, 15));
        signup.addActionListener(this);
        p2.add(signup);

        //Forget Password
        forget_password = new JButton("Forget Password");
        forget_password.setBounds(150, 250, 130, 30);
        forget_password.setBorder(BorderFactory.createEmptyBorder());
        forget_password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        forget_password.addActionListener(this);
        p2.add(forget_password);

        //Trouble in Login
        JLabel text = new JLabel("Touble in login...");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            try{
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "select * from account where username= '"+username+"' AND password='"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch(Exception ae){
                ae.printStackTrace();
            }
        } else if(e.getSource() == signup){
            setVisible(false);
            new Signup();
        } else if(e.getSource() == forget_password){
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
