package travel_management_system;
import java.sql.*;

public class Conn {

    //1.Register the Driver Class.
    //2.Creating the connection string.
    //3.Creating a statement.
    //4.Executing mysql queries.
    //5.Close the connection

    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "kiit");
            s = c.createStatement();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
