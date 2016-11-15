package Users;

import UI.Calendar;
import UI.Classroom;

/**
 * Created by Jason Qian on 12/11/2016.
 */

public class Teacher extends User{

    public Teacher (String username, String password){

    }

    public void addParent(Classroom classroom, Parent parent){
        classroom.addParent(parent);
    }

    public void createCalanderEvent(){

    }

    public void editCalanderEvent(Calendar.CalenderEvent event){

    }

    public void deleteCalanderEvent(Calendar.CalenderEvent event){

    }
}
