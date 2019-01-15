package app.controllers;

import app.models.ErrorMessage;
import app.models.LoginForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginFormRestController {
    private String USERNAME="Dimitar";
    private String PASSWORD="Earth";

    @PostMapping(value = "/form",consumes = "application/json")
    public ResponseEntity<?> validateUser(@RequestBody LoginForm formData) {
        String username = formData.getUsername();
        String password = formData.getPassword();
        boolean isValidUser = validateUsernameAndPassword(username, password);

        if (!isValidUser) {
            ErrorMessage message = new ErrorMessage("Incorrect usename or password");

            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(formData, HttpStatus.OK);
    }

    private boolean validateUsernameAndPassword(String username, String password) {
        LoginForm user = new LoginForm(USERNAME, PASSWORD);
        String usernameInDatabase = user.getUsername();
        String passwordInDatabase = user.getPassword();
        if (usernameInDatabase.equals(username) & passwordInDatabase.equals(password)) {
            return true;
        }
        return false;
    }
}
