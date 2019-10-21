package logic;

import dal.UserData;
import model.User;

public class UserLogic {

   private UserData userData = new UserData();

    public boolean postUser(User user){
        if (user != null){
            if (user.getPassword().equals(user.getConfirmPass()) && user.getPassword().length() > 2){
                return userData.addUser(user);
            }
        }
        return false;
    }
}
