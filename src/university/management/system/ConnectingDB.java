
package university.management.system;

import java.sql.*;

public class ConnectingDB {

    Connection c;
    Statement s;
    
    ConnectingDB() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///universityManagementSystem","root","mysqlsac@123");
            s = c.createStatement();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    public static void main(String[] args) {
        new ConnectingDB();
    }
}
