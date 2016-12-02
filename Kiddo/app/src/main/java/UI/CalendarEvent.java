package UI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by Jason Qian on 01/12/2016.
 */

public class CalendarEvent{


    public CalendarEvent(Calendar calendar, String name, String location, String startTime, String endTime, String comments){
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
            calendar.addEvent(this);
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

    public void update(String name, String location, String startTime, String endTime, String comments){
        Connection con = null;
        PreparedStatement statement = null;
        String sqlString = "UPDATE Events SET name = ?, location = ?, pass = ?, fName = ?, comments = ?) WHERE idEvent = ? and idClass = ?";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, name);
            statement.setString(2, location);
            statement.setDateTime(3, simpleDateFormat.parse(startTime));
            statement.setDateTime(4, simpleDateFormat.parse(endTime));
            statement.setString(5, comments);
            statement.setInt(6, idEvent);
            statement.setInt(7, idClass);
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
        Connection con = null;
        PreparedStatement statement = null;
        String sqlString = "DELETE FROM Events WHERE idEvent = ? and idClass = ?";
        try {
            statement = con.prepareStatement(sqlString);
            statement.setInt(1, idEvent);
            statement.setInt(2, idClass);
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

}