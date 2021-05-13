package com.example.demo.servicies;

import com.example.demo.model.domain.Role;
import com.example.demo.model.domain.Status;
import com.example.demo.model.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void addNewUser(User user){
        user.setRole(Role.USER);
        //user.setRole(Collections.singleton(Role.USER));
        user.setStatus(Status.ACTIVE);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(()->
              new UsernameNotFoundException("User doesn't exists"));

        return SecurityUser.fromUser(user);
    }

    public List<User> allUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User findUserById(Long id) {
       return userRepository.findById(id).orElseThrow(()->
                new UsernameNotFoundException("User doesn't exists"));

    }
}
