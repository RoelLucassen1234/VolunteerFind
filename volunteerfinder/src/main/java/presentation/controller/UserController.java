package presentation.controller;

import logic.Factory;
import model.AngularUser;
import model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import presentation.view.LoginViewModel;
import presentation.view.UserUpdateViewModel;
import presentation.view.UserViewModel;


@RestController
@RequestMapping("/users")
public class UserController {


    @PostMapping()
    public ResponseEntity postUser(@RequestBody UserViewModel userViewModel) {

        if (Factory.getUserLogic().postUser(new User(userViewModel.getFirstName(),userViewModel.getLastName(),
                userViewModel.getEmail(),userViewModel.getPassword(), userViewModel.getConfirmPass(),
                userViewModel.getBirthday())))
            return ResponseEntity.status(200).body("it worked");
        return ResponseEntity.status(400).body("Something went Wrong");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable int userId) {
        if (Factory.getUserLogic().deleteUser(userId)) {
            return ResponseEntity.ok("user was deleted");
        }
        return ResponseEntity.status(400).body("user was not deleted or never existed in the first place");
    }

    @PutMapping("/{userId}")
    public ResponseEntity updateUser(@RequestBody UserUpdateViewModel userViewModel) {
      User user = new User(userViewModel.getId(),userViewModel.getFirstName(),userViewModel.getLastName(),userViewModel.getEmail(),userViewModel.getBirthday());
        if (Factory.getUserLogic().updateUser(user)) {
            return ResponseEntity.ok("");
        }
        return ResponseEntity.status(400).body("chair could not be updated.");
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getUser(@PathVariable int userId) {

        User user = Factory.getUserLogic().getUser(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(400).body("chair does not exist.");
    }
    @PostMapping("/authentication")
    public ResponseEntity getUser(@RequestBody LoginViewModel loginViewModel) {

        User user = Factory.getUserLogic().login(loginViewModel.getUsername(), loginViewModel.getPassword());
        if (user != null) {
            Factory.getUserLogic().updateUser(user);
            AngularUser angularUser = new AngularUser(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getHash(), user.getToken());
            return ResponseEntity.ok(angularUser);
        }
        return ResponseEntity.status(400).body("chair does not exist.");
    }

    @GetMapping("/session/{sessionToken}")
    public ResponseEntity getUserFromSession(@PathVariable String sessionToken) {

        User user = Factory.getUserLogic().getUserBySession(sessionToken);
        if (user != null) {
            user.setHash(null);
            user.setConfirmPass(null);

            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(400).body("user with sessiontoken does not exist.");
    }


}
