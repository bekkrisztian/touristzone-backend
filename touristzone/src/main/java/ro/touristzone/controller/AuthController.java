package ro.touristzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.touristzone.exception.UserExistsException;
import ro.touristzone.model.User;
import ro.touristzone.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	// user service implementation
    @Autowired
    private UserService userService;

    // registration
    @PostMapping("/registration")
    public ResponseEntity<Object> registration(@Valid @RequestBody User user) {
        try {
            userService.registration(user);
        } catch (UserExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}