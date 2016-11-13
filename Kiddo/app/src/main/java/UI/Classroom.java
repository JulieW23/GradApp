package UI;
import java.util.ArrayList;

import Users.Parent;
import Users.Teacher;

/**
 * Created by Jason Qian on 13/11/2016.
 */

public class Classroom {

    private ArrayList<Teacher> teachers;
    private ArrayList<Parent> parents;

    public Classroom (String name, Teacher teacher){
        teachers = new ArrayList<Teacher>();
        teachers.add(teacher);
        parents = new ArrayList<Parent>()
    }

    public void addTeacher (Teacher teacher){
        teachers.add(teacher);
    }

    public void removeTeacher (Teacher teacher) throws IllegalStateException{
        if (teachers.size() == 1){
            throw new IllegalStateException(); // probably should be a different exception
        }
        teachers.remove(teacher);

    }

    public void addParent (Parent parent){
        parents.add(parent);
    }

    public void removeParent(Parent parent){
        parents.remove(parent);
    }
}
