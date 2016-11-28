package Users;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import UI.Classroom;

/**
 * Created by Jason Qian on 12/11/2016.
 */

public class Parent extends User{

    public Parent (String username, String password, String email, String fName, String lName){
        super(username, email);
        PreparedStatement statement = null;
        String sqlString = "INSERT into Parents (email, uname, pass, fName, lName) VALUES(?, ?, ?, ?, ?)";
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

    public Parent (String username, String password, String email, String fName, String lName, int studentID){
        super(username, email);
        PreparedStatement statement = null;
        String sqlString = "INSERT into Parents (email, uname, pass, fName, lName, idStudent) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, fName);
            statement.setString(5, lName);
            statement.setInt(6, studentID);
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

    public void joinClass (Classroom classroom){
        try{
            classroom.joinParent(this);
        }
        catch (Exception e){
            //what do??
        }
    }
}
