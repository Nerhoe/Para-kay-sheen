
package SQL_Conn;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionInnit {
    public static final String db_name = "inv_manager_db";
    public static String db_conn = "jdbc:mysql://localhost:3306/" + db_name;
    public static final String inv_user = "root";
    public static final String inv_password = "";
    
    PreparedStatement db_ps = null;
    
    public static void dbInit(String db_name_in) throws SQLException{
        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", inv_user, inv_password);
        Statement createDB = conn1.createStatement();
        createDB.executeUpdate("create database "+ db_name_in);
        conn1.close();
        
        Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name_in, inv_user, inv_password);
        String user_tbl = "create table inv_user_tbl (`User_ID` int primary key not null auto_increment, `user_fName` varchar (255) not null, `user_lName` varchar (255) not null, `password` varchar(255) not null, `email` varchar (255) not null unique);";
        String inv_tbl = "create table inv_prod_tbl (`Transaction_ID int primary key not null auto_increment, `product_name` varchar (255) not null unique,`product_quantity` int not null, `date` date not null);";
                
        Statement createTable = conn2.createStatement();
        createTable.executeUpdate(inv_tbl);
        createTable.executeUpdate(user_tbl);
        conn2.close();
    }
    
    public static void main(String[] args){

        try {
            dbInit(db_name);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
