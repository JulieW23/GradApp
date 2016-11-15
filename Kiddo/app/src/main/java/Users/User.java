package Users;

import UI.Conversation;

/**
 * Created by Jason Qian on 13/11/2016.
 */

public abstract class User {

    public void sentMessage (Conversation conversation, String contents){
        conversation.sendMessage(this, contents);
    }

    public void sentFile (Conversation conversation, byte[] file){
        conversation.sendFile(this, file);
    }
}
