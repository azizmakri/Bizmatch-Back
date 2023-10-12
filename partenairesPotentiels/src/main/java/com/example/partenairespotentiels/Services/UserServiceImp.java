package com.example.partenairespotentiels.Services;


import com.example.partenairespotentiels.Entities.User;
import com.example.partenairespotentiels.Repositories.MessageRepository;
import com.example.partenairespotentiels.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User retrieveUserById(String idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Boolean deleteUser(String idUser) {
        if (userRepository.existsById(idUser)) {
            userRepository.deleteById(idUser);
            return true;
        }
        else {
            return false;
        }
    }
}
