package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    JButton btncreate, btnback;
    JTextField tfusername, tfpassword, tfname, tfanswer;
    Choice csecurity;
    Signup(){
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        //Username
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);

        //Username Textfield
        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        //Name
        JLabel lbname = new JLabel("Name");
        lbname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbname.setBounds(50, 60, 125, 25);
        p1.add(lbname);

        //Name Textfield
        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        //Password
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbpassword.setBounds(50, 100, 125, 25);
        p1.add(lbpassword);

        //Password textfield
        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        //Security
        JLabel lbsecurity = new JLabel("Security Question");
        lbsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbsecurity.setBounds(50, 140, 125, 25);
        p1.add(lbsecurity);

        //Security Question
        csecurity = new Choice();
        csecurity.add("Fav character from Marvel");
        csecurity.add("Your lucky number");
        csecurity.add("Fav tv show");
        csecurity.setBounds(190, 140, 180, 25);
        csecurity.setFont(new Font("Tahoma", Font.BOLD, 12));
        p1.add(csecurity);

        //Answer
        JLabel lbanswer = new JLabel("Answer");
        lbanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbanswer.setBounds(50, 180, 125, 25);
        p1.add(lbanswer);

        //Answer Textfield
        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        //Create Button
        btncreate = new JButton("Create");
        btncreate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btncreate.setBounds(80, 250, 100, 30);
        btncreate.addActionListener(this);
        p1.add(btncreate);

        //Back Button
        btnback = new JButton("Back");
        btnback.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnback.setBounds(250, 250, 100, 30);
        btnback.addActionListener(this);
        p1.add(btnback);

        //Adding Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btncreate){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = csecurity.getSelectedItem();
            String answer = tfanswer.getText();

            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created");
                setVisible(false);
                new Login();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if(e.getSource() == btnback){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}