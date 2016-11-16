package Users;

import UI.Classroom;

/**
 * Created by Jason Qian on 12/11/2016.
 */

public class Parent extends User{

    public Parent (String username, String password){

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
