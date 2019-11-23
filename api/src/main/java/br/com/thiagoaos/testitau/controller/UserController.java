package br.com.thiagoaos.testitau.controller;

import br.com.thiagoaos.testitau.model.User;
import br.com.thiagoaos.testitau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/top5-followers")
    public ResponseEntity<List<User>> findTopFiveFollowers() {
        return new ResponseEntity<>(this.service.findTopFiveFollowers(), HttpStatus.OK);
    }
}