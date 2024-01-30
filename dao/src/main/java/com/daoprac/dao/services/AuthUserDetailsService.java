//package com.daoprac.dao.services;
//
//import com.daoprac.dao.models.AuthUser;
//import com.daoprac.dao.DAO.AuthUserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//
//public class AuthUserDetailsService implements UserDetailsService {
//    @Autowired
//    private final AuthUserRepository userRepository;
//
//    public AuthUserDetailsService(AuthUserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<AuthUser> authUser = userRepository.findByUsername(username.toLowerCase());
//        if (!authUser.isPresent()) {
//            throw new UsernameNotFoundException(username);
//        } else {
//            return User.builder()
//                    .username(authUser.get().getUsername())
//                    .password(authUser.get().getPassword())
//                    .disabled(!authUser.get().isActive())
//                    .build();
//        }
//    }
//}