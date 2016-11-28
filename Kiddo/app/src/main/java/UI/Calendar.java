package UI;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.* ;
import java.text.SimpleDateFormat;

/**
 * Created by Jason Qian on 13/11/2016.
 */

public class Calendar {
    //not sure what to do with this, might be using a framework instead
    Map<Date, CalendarEvent> events = new HashMap<Date, CalendarEvent>();

    public class CalendarEvent{

        /*
        public CalandarEvent(String name, String location, String startTime, String endTime, String comments){
            Connection con = null;
            PreparedStatement statement = null;
            String sqlString = "INSERT into Events (name, location, pass, fName, comments) VALUES(?, ?, ?, ?, ?)";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            try {
                statement = con.prepareStatement(sqlString);
                statement.setString(1, name);
                statement.setString(2, location);
                statement.setDateTime(3, simpleDateFormat.parse(startTime));
                statement.setDateTime(4, simpleDateFormat.parse(endTime));
                statement.setString(5, comments);
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
        */

    }
}
