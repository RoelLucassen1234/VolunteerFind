package presentation.controller;

import logic.Factory;
import model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import presentation.view.UserViewModel;


@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("")
    public ResponseEntity postUser(@RequestBody UserViewModel userViewModel) {

        if (Factory.getUserLogic().postUser(new User(userViewModel.getFirstName(),userViewModel.getLastName(),
                userViewModel.getEmail(),userViewModel.getPassword(), userViewModel.getConfirmPass(),
                userViewModel.getBirthday())))
            return ResponseEntity.status(200).body("it worked");
        return ResponseEntity.status(400).body("Something went Wrong");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable int userId) {
        if (true) {
            return ResponseEntity.ok("");
        }
        return ResponseEntity.status(400).body("user was not deleted or never existed in the first place");
    }

    @PutMapping("{userId}")
    public ResponseEntity updateUser(@RequestBody UserViewModel userViewModel) {
        if (true) {
            return ResponseEntity.ok("");
        }
        return ResponseEntity.status(400).body("chair could not be updated.");
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getUser(@PathVariable int userId) {

        if (true) {
            return ResponseEntity.ok("");
        }
        return ResponseEntity.status(400).body("chair does not exist.");
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity getAllUsersFromEvent(@PathVariable int eventId) {

        if (true) {
            return ResponseEntity.ok("");
        }
        return ResponseEntity.status(400).body("reservations do not exist.");
    }


}
