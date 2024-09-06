package hospital.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {

    Connection connection;
    Statement statement;

    public connection(){
        //exception handling as outsider database is used here
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "Ritika@#400500");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
