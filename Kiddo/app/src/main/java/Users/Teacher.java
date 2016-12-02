package Users;

import UI.Calendar;
import UI.Classroom;
import UI.CalendarEvent;
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

    public void login(String username, String password) throws UserDoesNotExistException{
        PreparedStatement statement = null;
        String sqlString = "SELECT idTeacher FROM Teachers WHERE user = ? and pass = ?";
        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (!result.isBeforeFirst() ) {
                throw new UserDoesNotExistException();
            }
            this.setID(result.getInt("idParent"));
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
        new CalendarEvent(name, location, startTime, endTime, comments);
    }

    public void editCalendarEvent(CalendarEvent event, String name, String location, String startTime, String endTime, String comments){
        event.update(name, location, startTime, endTime, comments);
    }

    public void deleteCalendarEvent(CalendarEvent event){
        event.delete();
    }

    public ResultSet teacherInfo(){
        PreparedStatement statement = null;
        String sqlString = "SELECT * FROM Teachers WHERE idTeacher = ?";

        try {
            statement = con.prepareStatement(sqlString);
            statement.setInt(1, this.getID());
            return statement.executeQuery();
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
        return null;
    }

    public ResultSet allClasses(){
        PreparedStatement statement = null;
        String sqlString = "SELECT * FROM Classes WHERE Classes.idTeacher = ?";

        try {
            statement = con.prepareStatement(sqlString);
            statement.setInt(1, this.getID());
            return statement.executeQuery();
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
        return null;
    }

    public ResultSet allMessages(){
        PreparedStatement statement = null;
        String sqlString = "SELECT * FROM Messages WHERE Messages.idSender = ? or Messages.idRecipient = ?";

        try {
            statement = con.prepareStatement(sqlString);
            statement.setInt(1, this.getID());
            return statement.executeQuery();
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
        return null;
    }
}
