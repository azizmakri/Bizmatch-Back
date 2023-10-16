package com.example.partenairespotentiels.Services;

import com.example.partenairespotentiels.Entities.Message;
import com.example.partenairespotentiels.Entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    User retrieveUserById(String idUser);
    List<User> retrieveAllUsers();
    Boolean deleteUser(String idUser);
}
