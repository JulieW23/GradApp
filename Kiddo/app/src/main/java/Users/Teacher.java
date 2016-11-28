package Users;

import UI.Calendar;
import UI.Classroom;
import java.sql.* ;

/**
 * Created by Jason Qian on 12/11/2016.
 */

public class Teacher extends User{

    public Teacher (String username, String password, String email, String fName, String lName){
        super(username, email);
        PreparedStatement statement = null;
        String sqlString = "INSERT into Teachers (email, uname, pass, fName, lName) VALUES(?, ?, ?, ?, ?)";
        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, fName);
            statement.setString(5, lName);
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

    public void addParent(Classroom classroom, Parent parent){
        classroom.addParent(parent);
    }

    public void createCalendarEvent(String name, String location, String startTime, String endTime, String comments){
        //new Calendar.CalendarEvent(name, location, startTime, endTime, comments);
    }

    public void editCalendarEvent(Calendar.CalendarEvent event){

    }

    public void deleteCalendarEvent(Calendar.CalendarEvent event){

    }
}
