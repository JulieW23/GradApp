package UI;

import java.sql.Time;

import Users.User;

/**
 * Created by Jason Qian on 13/11/2016.
 */

public class Message {
    User sentBy;
    String contents;
    Long timestamp;

    public Message (User sentBy, String contents, Long timestamp){
        this.sentBy = sentBy;
        this.contents = contents;
        this.timestamp = timestamp;
    }
}
