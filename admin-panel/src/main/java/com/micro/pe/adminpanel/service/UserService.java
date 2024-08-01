package com.micro.pe.adminpanel.service;

import com.micro.pe.adminpanel.dto.ResponseUserDTO;
import com.micro.pe.adminpanel.dto.UserDTO;
import com.micro.pe.adminpanel.entity.User;
import com.micro.pe.adminpanel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseUserDTO createUser(UserDTO userDTO) {
        User createduser = new User();
        createduser.setEmail(userDTO.getEmail());
        createduser.setPassword(userDTO.getPassword());
        createduser.setName(userDTO.getName());
        createduser.setRole(userDTO.getRole());
        User savedUser = userRepository.save(createduser);
        return new ResponseUserDTO(savedUser.getId(), savedUser.getEmail(), savedUser.getPassword(), savedUser.getName(), savedUser.getRole());
    }

    public ResponseUserDTO findUserByID(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new ResponseUserDTO(user.getId(), user.getEmail(), user.getPassword(),user.getName(), user.getRole());
    }

    public List<ResponseUserDTO> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(
                user -> new ResponseUserDTO(user.getId(), user.getEmail(),user.getPassword(), user.getName(), user.getRole())
        ).collect(Collectors.toList());
    }

    public ResponseUserDTO updateUser(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        User savedUser = userRepository.save(user);
        return new ResponseUserDTO(savedUser.getId(), savedUser.getEmail(),savedUser.getPassword(), savedUser.getName(), savedUser.getRole());
    }

    public void deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
