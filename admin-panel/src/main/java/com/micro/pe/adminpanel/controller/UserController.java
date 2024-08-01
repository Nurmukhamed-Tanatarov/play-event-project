package com.micro.pe.adminpanel.controller;

import com.micro.pe.adminpanel.dto.ResponseUserDTO;
import com.micro.pe.adminpanel.dto.UserDTO;
import com.micro.pe.adminpanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("api/s4/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<ResponseUserDTO> createUser(@RequestBody UserDTO userDTO) {
        ResponseUserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<ResponseUserDTO> getUser(@PathVariable("id") Integer id) {
        ResponseUserDTO user = userService.findUserByID(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<ResponseUserDTO>> getAllUsers() {
        List<ResponseUserDTO> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<ResponseUserDTO> updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        ResponseUserDTO updatedUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<ResponseUserDTO> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
