package Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import UI.Classroom;

/**
 * Created by Jason Qian on 12/11/2016.
 */

public class Admin extends User{

    public Admin (String username, String password, String email){
        super(username, email);
        PreparedStatement statement = null;
        String sqlString = "INSERT into Administrators (email, uname, pass) VALUES(?, ?, ?)";
        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);
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

    public void createTeacher (String username, String password, String email, String fName, String lName){
        new Teacher(username, password, email, fName, lName);
    }

    public void createClassroom (String className, Teacher teacher){
        Classroom classroom = new Classroom (className, teacher);
        PreparedStatement statement = null;
        String sqlString = "INSERT into Classes (idSchool, idTeacher, name) VALUES(?, ?, ?)";
        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, getIDSchool());
            statement.setString(2, getIDTeacher(teacher));
            statement.setString(3, className);
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

    public void addTeacher (Classroom classroom, Teacher teacher){
        classroom.addTeacher(teacher);
    }

    public void removeTeacher(Classroom classroom, Teacher teacher){
        try{
            classroom.removeTeacher(teacher);
        }
        catch (IllegalArgumentException e){
            //what do?
        }
    }

    public String getIDSchool(){
        PreparedStatement statement = null;
        String sqlString = "SELECT idSchool FROM Administrators where email = ?";

        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, this.getEmail());
            ResultSet result = statement.executeQuery();
            return result.getString("idSchool");
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
        //probably throw an error here
        return null;
    }

    public String getIDTeacher(Teacher teacher){
        PreparedStatement statement = null;
        String sqlString = "SELECT idTeacher FROM Teachers where email = ? and idSchool = ?";

        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, teacher.getEmail());
            statement.setString(2, getIDSchool());
            ResultSet result = statement.executeQuery();
            return result.getString("idTeacher");
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
        //probably throw an error here
        return null;
    }

    public void updateInfo(String username, String password){
        PreparedStatement statement = null;
        String sqlString = "UPDATE Administrators SET uname = ?, pass = ? WHERE idSchool = ?";

        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, getIDSchool());
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

    public ResultSet allClasses(){
        PreparedStatement statement = null;
        String sqlString = "SELECT * FROM Classes where idSchool = ?";

        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, getIDSchool());
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

    public ResultSet allTeachers(){
        PreparedStatement statement = null;
        String sqlString = "SELECT * FROM Teachers where idSchool = ?";

        try {
            statement = con.prepareStatement(sqlString);
            statement.setString(1, getIDSchool());
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
