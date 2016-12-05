package Users;

import UI.Conversation;
import java.sql.* ;
import javax.sql.DataSource;

/**
 * Created by Jason Qian on 13/11/2016.
 */

public abstract class User {

    public static Connection con;
    private String username;
    private String email;
    private int id;

    public User(String username, String email){
        this.username = username;
        this.email = email;

        String host = "jdbc:mysql://35.160.73.118:3000";
        String user = "guest";
        String pass = "guest";

        /*DataSource dataSource = new DataSource();
        dataSource.setUser("scott");
        dataSource.setPassword("tiger");
        dataSource.setServerName("myDBHost.example.org");*/
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        try {
            con = DriverManager.getConnection(host, user, pass);
            System.out.println("pass");//TODO: Fix this
        } catch (SQLException e) {
            System.out.println("fail");
            e.printStackTrace();

        }
    }

    public void sentMessage (Conversation conversation, String contents){
        //conversation.sendMessage(this, contents);
    }

    public void sentFile (Conversation conversation, byte[] file){
        //conversation.sendFile(this, file);
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public class UserDoesNotExistException extends Exception{
        public UserDoesNotExistException(){
            super();
        }
    }
}
