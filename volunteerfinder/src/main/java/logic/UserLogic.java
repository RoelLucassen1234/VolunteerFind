package logic;

import interfaces.IUserData;
import model.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Random;

public class UserLogic {

    private IUserData userData;

    public UserLogic(IUserData userData) {
        this.userData = userData;
    }

    public boolean postUser(User user) {
        if (user != null) {
            if (userData.getUserByEmail(user.getEmail()) == null)
                if (user.getHash() != null && user.getConfirmPass() != null) {
                    if (user.getHash().equals(user.getConfirmPass()) && user.getHash().length() > 2) {
                        if (user.getEmail() != null)
                            if (user.getFirstName() != null && user.getFirstName().length() > 2)
                                if (user.getLastName() != null && user.getLastName().length() > 2) {
                                    String hashpw = BCrypt.hashpw(user.getHash(), BCrypt.gensalt(12));
                                    user.setHash(hashpw);
                                    return userData.addUser(user);
                                }

                    }
                }
        }
        return false;
    }

    public User getUser(int userId) {
        return userData.getUser(userId);
    }

    public User login(String email, String password) {
        User user = userData.getUserByEmail(email);
        String hashpw = "123";

        if (user != null) {
            if (BCrypt.checkpw(password, user.getHash())) {
                hashpw = "12313333";
                Random random = new Random();
                hashpw = Integer.toString(random.nextInt(99999999 - 1000000) + 1000000);
                System.out.println(hashpw);
                user.setToken(hashpw);
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(int userId) {
        return userData.removeUser(userId);
    }

    public boolean updateUser(User user) {
        return userData.updateUser(user);
    }

    public User getUserBySession(String session) {
        if (session != null)
            return userData.getUserBySession(session);
        return null;
    }
}
