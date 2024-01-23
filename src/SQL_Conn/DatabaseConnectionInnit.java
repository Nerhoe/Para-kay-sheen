
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
    public static String table1= "inv_user_tbl";
    PreparedStatement db_ps = null;
    Connection dbconn = null;
    
    public static void dbInit(String db_name_in) throws SQLException{
        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", inv_user, inv_password);
        Statement createDB = conn1.createStatement();
        createDB.executeUpdate("create database "+ db_name_in);
        conn1.close();
        
        Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name_in, inv_user, inv_password);
        String user_tbl = "create table "+ table1 +" (`User_ID` int primary key not null auto_increment, `user_fName` varchar (255) not null, `user_lName` varchar (255) not null, `password` varchar(255) not null, `email` varchar (255) not null unique);";
        String inv_tbl = "create table inv_prod_tbl (`Transaction_ID` int primary key not null auto_increment, `product_name` varchar (255) not null unique,`product_quantity` int not null, `date` date not null);";
                
        Statement createTable = conn2.createStatement();
        createTable.executeUpdate(inv_tbl);
        createTable.executeUpdate(user_tbl);
        conn2.close();
    }
    
    public static void dbDrop() throws SQLException{
        Connection disCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name, inv_user, inv_password);
        Statement exeDB = disCon.createStatement();
        exeDB.executeUpdate("drop database "+ db_name);
        disCon.close();
        System.out.println("hehe");
    }
    
    public static void main(String[] args){

        try {
            dbInit(db_name);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void dbMake(){

        try {
            dbInit(db_name);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
        
    public void dbInsertUsers(String F_Name, String L_Name, String E_mail, String P_assword) throws SQLException{
        String runnable = "insert into " + table1 + " (user_fName, user_lName, password, email) values (?,?,?,?)";
        Connection userconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name, inv_user, inv_password);
        try{
            PreparedStatement userInsert = userconn.prepareStatement(runnable);
            userInsert.setString(1, F_Name);
            userInsert.setString(2, L_Name);
            userInsert.setString(3, E_mail);
            userInsert.setString(4, P_assword);
            int numbers = userInsert.executeUpdate();
            System.out.println(numbers);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
