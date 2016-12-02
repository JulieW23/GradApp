package UI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.* ;
import javax.sql.rowset.serial.SerialBlob;
import java.time.LocalDateTime;

import Users.User;

/**
 * Created by Jason Qian on 13/11/2016.
 */

public class Conversation {
    private ArrayList<Message> messages;
    private ArrayList<User> users;
    Connection con;

    public Conversation(User[] users){
        this.con = null;
        messages = new ArrayList<Message>();
        for (User user : users){
            this.users.add(user);
        }
    }

    public void sendMessage(User sentBy, User sentTo, String contents, byte[] file){
        this.messages.add(new Message(sentBy, sentTo, contents, file, System.currentTimeMillis()));
    }

    private class Message {
        User sentBy;
        String contents;
        byte[] file;
        Long timestamp;

        public Message (User sentBy, User sentTo, String contents, byte[] file, Long timestamp){
            this.sentBy = sentBy;
            this.contents = contents;
            this.timestamp = timestamp;
            this.file = file;
            PreparedStatement statement = null;
            String sqlString = "INSERT into Messages (idSender, idRecipient, creationTime, body, media) VALUES(?, ?, ?, ?, ?)";
            try {
                statement = con.prepareStatement(sqlString);
                statement.setInt(1, sentBy.getID());
                statement.setInt(2, sentTo.getID());

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
                statement.setDateTime(3, LocalDateTime.parse(timestamp, simpleDateFormat));

                statement.setString(4, contents);
                statement.setBlob(5, new SerialBlob(file));
                statement.executeUpdate();
                con.commit();
            }catch (SQLException e ) {
                if (con != null) {
                    try {
                        con.rollback();
                    } catch(SQLException ex) {
                    }
                }
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }

        public void delete(){

        }
    }
}
