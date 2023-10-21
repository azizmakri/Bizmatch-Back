package com.example.partenairespotentiels.Services;

import com.example.partenairespotentiels.Entities.Message;
import com.example.partenairespotentiels.Entities.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    User retrieveUserById(String idUser);
    List<User> retrieveAllUsers();
    Boolean deleteUser(String idUser);
    User getUserByUserName(String userName);

    Set<User> getPartnerRequests(String userName);
    void removePartnerRequest(String userName, String partnerToRemoveUserName);
    void acceptPartnershipRequest(String userName, String partnerToAcceptUserName);
    void addPartnershipRequest(String userName, String desiredPartnerUserName);
    Set<User> getPartners(String userName);
    void removePartner(String userName, String partnerToRemoveUserName);
}
