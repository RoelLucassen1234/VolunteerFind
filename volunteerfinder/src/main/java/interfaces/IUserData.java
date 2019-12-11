package interfaces;

import model.User;

public interface IUserData {
    User getUser(int userId);
    boolean removeUser(int userId);
    boolean updateUser(User user);
    boolean addUser(User user);
    User getUserByEmail(String email);
    User getUserBySession(String sessionToken);
    User getUserById(int userId);
}
