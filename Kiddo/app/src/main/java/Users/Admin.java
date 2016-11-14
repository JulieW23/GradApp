package Users;

import UI.Classroom;

/**
 * Created by Jason Qian on 12/11/2016.
 */

public class Admin extends User{

    public Admin (String username, String password){

    }

    public void createTeacher (String username, String password){

    }

    public void createClassroom (String className, Teacher teacher){
        Classroom classroom = new Classroom (className, teacher);
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

}
