package com.example.student.controller;

import com.example.student.Service.UserService;
import com.example.student.dto.LoginRQ;
import com.example.student.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getLoggedUser")
    public ResponseEntity<UserDTO> getLoggedUser(@RequestBody LoginRQ loginRQ){
        UserDTO userDTO = this.userService.getLoggedUser(loginRQ);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
