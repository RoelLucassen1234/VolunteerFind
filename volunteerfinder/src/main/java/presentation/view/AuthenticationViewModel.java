package presentation.view;

public class AuthenticationViewModel {
    String username;
    String password;

    public AuthenticationViewModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthenticationViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
