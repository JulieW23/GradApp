package Users;

import UI.Conversation;
import java.sql.* ;

/**
 * Created by Jason Qian on 13/11/2016.
 */

public abstract class User {

    public static Connection con;
    private String username;
    private String email;

    public User(String username, String email){
        this.username = username;
        this.email = email;
        con = null; //TODO: Fix this
    }

    public void sentMessage (Conversation conversation, String contents){
        conversation.sendMessage(this, contents);
    }

    public void sentFile (Conversation conversation, byte[] file){
        conversation.sendFile(this, file);
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }
}
