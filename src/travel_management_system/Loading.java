package travel_management_system;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;

    //Progress Bar
    @Override
    public void run() {
        try{
            for(int i = 0; i <= 100; i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue();

                if(value < max){
                    bar.setValue(value + 1);
                } else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(40);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    Loading(String username){
        this.username = username;
        t = new Thread(this);

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 30));
        add(text);

        //Progress Bar
        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        // Loading
        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(200, 140, 190, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 15));
        add(loading);

        //Welcome user
        JLabel welcome = new JLabel("Welcome " + username);
        welcome.setBounds(20, 310, 400, 40);
        welcome.setForeground(Color.RED);
        welcome.setFont(new Font("Raleway", Font.BOLD, 16));
        add(welcome);

        t.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("");
    }
}
