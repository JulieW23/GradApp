package UI;

import java.util.ArrayList;

import Users.User;

/**
 * Created by Jason Qian on 13/11/2016.
 */

public class Conversation {
    private ArrayList<Message> messages;
    private ArrayList<User> users;

    public Conversation(User[] users){
        messages = new ArrayList<Message>();
        for (User user : users){
            this.users.add(user);
        }
    }

    public void sendMessage(User user, String contents){
        this.messages.add(new Message(user, contents, System.currentTimeMillis()));
    }
}
