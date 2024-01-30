//package com.daoprac.dao.controllers;
//
//import com.daoprac.dao.DAO.AuthUserRepository;
//import com.daoprac.dao.models.AuthUser;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//
//public class UserController {
//
//    private final AuthUserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserController(AuthUserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
////    @RequestMapping("/")
//    public String welcome(){
//        return "HELLO WORLD";
//    }
//    @PostMapping("/register")
//    public ResponseEntity registerUser(@RequestBody AuthUser user){
//        try {
//            if (userRepository.findByUsername(user.getUsername()).isPresent())
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken. Please try again");
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            AuthUser save = userRepository.save(user);
//            return ResponseEntity.ok(HttpStatus.CREATED);
//        } catch (Exception e){
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }
//}