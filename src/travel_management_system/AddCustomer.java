package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel lblusername, lblid, labelusername, lblnumber, lblname, lablelname, lblgender, lblcountry, lbladdress, lblphone, lblemail;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail;
    JRadioButton rmale, rfemale;
    JButton btnadd, btnback;

    AddCustomer(String username) {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        //Username
        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        //Answer
        labelusername = new JLabel("");
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        //ID
        lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        //Identity
        comboid = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        //Identity number
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        //Identity number textfield
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        lablelname = new JLabel("Passport");
        lablelname.setBounds(220, 170, 150, 25);
        add(lablelname);

        //Gender
        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        //Male Button
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        //Female Button
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 100, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        //Grp both button
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        //Country
        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        //Country textfield
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        //Address
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        //Address textfield
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        //Phone Number
        lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);

        //Phone Number textfield
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        //E-mail
        lblemail = new JLabel("Email");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);

        //E-mail textfield
        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        //Add Button
        btnadd = new JButton("Add");
        btnadd.setBackground(Color.BLACK);
        btnadd.setForeground(Color.WHITE);
        btnadd.setBounds(70, 430, 100, 25);
        btnadd.addActionListener(this);
        add(btnadd);

        //Back Button
        btnback = new JButton("Back");
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.WHITE);
        btnback.setBounds(220, 430, 100, 25);
        btnback.addActionListener(this);
        add(btnback);

        //Add Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                lablelname.setText(rs.getString("name"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnadd){
            String username = labelusername.getText();
            String id = (String)comboid.getSelectedItem();
            String number = (String)tfnumber.getText();
            String name = lablelname.getText();
            String gender = null;
            if(rfemale.isSelected()){
                gender = "Female";
            } else{
                gender = "Male";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
            } catch(Exception ae){
                ae.printStackTrace();
            }
        }else if(e.getSource() == btnback){
            setVisible(false);
        }
    }



    public static void main(String[] args) {
        new AddCustomer("Anuj1716");
    }
}
