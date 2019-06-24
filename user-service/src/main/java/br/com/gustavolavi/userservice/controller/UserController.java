package br.com.gustavolavi.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavolavi.userservice.model.User;


/**
 * UserController
 */
@RestController
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> get(){
        
        List<User> users = new ArrayList<>();

        users.add(new User(1L,"gustav","123456"));
        users.add(new User(2L,"laviola","123456"));
        
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}