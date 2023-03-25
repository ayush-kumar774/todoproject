package com.todo.todoproject.service;

import com.todo.todoproject.entity.User;
import com.todo.todoproject.repositories.UserRepository;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ;
    public User getUser(User user) {
        System.out.println("Service GET **********");
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public boolean getUserByUsername(String username, String password) {
        boolean usernamePresent ;
        boolean passwordPresent ;
        try {
            usernamePresent = userRepository.findTopByUsername(username) != null ? true : false ;
            System.out.println("Username exists " + usernamePresent);
            passwordPresent = userRepository.findTopByPassword(password) != null ? true : false ;
            System.out.println("Password exists " + passwordPresent);
        }
        catch (NonUniqueResultException nonUniqueResultException) {
            return true ;
        }
        return usernamePresent && passwordPresent ;
    }

    public boolean findUserByUsername (String username) {
        boolean usernamePresent ;
        try {
            usernamePresent = userRepository.findTopByUsername(username) != null ? true : false ;
            System.out.println("Username exists " + usernamePresent);
        }
        catch (NonUniqueResultException nonUniqueResultException) {
            return true ;
        }
        return usernamePresent ;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
