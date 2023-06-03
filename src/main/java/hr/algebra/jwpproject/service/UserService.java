package hr.algebra.jwpproject.service;

import hr.algebra.jwpproject.repository.UserRepository;
import hr.algebra.jwpproject.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwd = bcryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pwd);
        userRepository.save(user);
        return user;
    }
}
