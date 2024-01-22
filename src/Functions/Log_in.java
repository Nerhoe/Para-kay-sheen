package Functions;
import GUI_Forms.User_LogIn_Panel;
import javax.swing.JOptionPane;
public class Log_in 
        
{
private String User_Pname;    
private String User_Nme;
private String User_pass;

    public String getUser_Pname() {
        return User_Pname;
    }

    public void setUser_Pname(String User_Pname) {
        this.User_Pname = User_Pname;
    }

    public String getUser_Nme() {
        return User_Nme;
    }

    public void setUser_Nme(String User_Nme) {
        this.User_Nme = User_Nme;
    }

    public String getUser_pass() {
        return User_pass;
    }

    public void setUser_pass(String User_pass) {
        this.User_pass = User_pass;
    }
    
    public void User_LogIn(String email, String pass)
    {
        if(email.equals(getUser_Nme()) && pass.equals(getUser_pass()))
        {
            JOptionPane.showMessageDialog(null, "WELCOME: " + getUser_Nme());
        } 
        else
        {
            JOptionPane.showMessageDialog(null, "INVALID\n" + "Please Try Again");
        }
    }
    
            
}
