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

    public void sendFile(User user, byte[] file){
        this.messages.add(new Message(user, file, System.currentTimeMillis()));
    }

    private class Message {
        User sentBy;
        String contents;
        byte[] file;
        Long timestamp;

        public Message (User sentBy, String contents, Long timestamp){
            this.sentBy = sentBy;
            this.contents = contents;
            this.timestamp = timestamp;
        }

        public Message (User sentBy, byte[] file, Long timestamp){
            this.sentBy = sentBy;
            this.file = file;
            this.timestamp = timestamp;
        }

        public void delete(){

        }
    }
}
