package com.example.opportunitecollaboration.Services;

import com.example.opportunitecollaboration.Entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    User retrieveUserById(String idUser);
    List<User> retrieveAllUsers();
    Boolean deleteUser(String idUser);
}
