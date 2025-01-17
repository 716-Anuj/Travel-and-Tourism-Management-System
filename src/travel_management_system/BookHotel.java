package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookhotel, back;
    BookHotel(String username){
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        //Heading
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        //Username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 70, 100, 20);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblUsername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 100, 20);
        add(labelusername);

        //Package Selection
        JLabel lblpkg = new JLabel("Select Hotel");
        lblpkg.setBounds(40, 110, 120, 20);
        lblpkg.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpkg);

        chotel = new Choice();
        chotel.setBounds(250, 110, 100, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //Total Person
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(40, 150, 150, 20);
        lblperson.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblperson);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        //No.of Days
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40, 190, 150, 20);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        //AC Room
        JLabel lblac = new JLabel("AC/ Non-AC");
        lblac.setBounds(40, 230, 150, 20);
        lblac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 100, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40, 270, 150, 20);
        lblfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 100, 20);
        add(cfood);

        //ID
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40, 310, 200, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 150, 25);
        add(labelid);

        //Number
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 350, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        //Phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 390, 150, 20);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);

        //Total Price
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 430, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
        add(labelprice);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //Check Price Button
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);

        //Book Hotel Button
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(200, 490, 135, 25);
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.addActionListener(this);
        add(bookhotel);

        //Back Button
        back = new JButton("Back");
        back.setBounds(355, 490, 120, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 300);
        add(l12);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice) {
            try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "'");
            while (rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int ac = Integer.parseInt(rs.getString("acroom"));

                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());

                String acselected = cac.getSelectedItem();
                String foodselected  = cfood.getSelectedItem();

                if(persons * days > 0){
                    int total = 0;
                    total += acselected.equals("AC") ? ac : 0;
                    total += foodselected.equals("Yes") ? food : 0;
                    total += cost;
                    total += total*persons*days;
                    labelprice.setText("Rs "+total);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a person");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }} else if(ae.getSource() == bookhotel){
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"','"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        }  else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("Anuj1716");
    }
}
