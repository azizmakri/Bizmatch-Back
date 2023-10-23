package com.example.partenairespotentiels.Services;


import com.example.partenairespotentiels.Entities.RoleDemander;
import com.example.partenairespotentiels.Entities.User;
import com.example.partenairespotentiels.Exceptions.NoPartnerRequestsException;
import com.example.partenairespotentiels.Exceptions.UserNotFoundException;
import com.example.partenairespotentiels.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
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


    public Set<User> getPartnerRequests(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException("User not found with username: " + userName);
        }
        Set<User> partnershipRequests = user.getPartnerRequests();
        if (partnershipRequests != null) {
            return partnershipRequests;
        }
        return null;
    }


    public void removePartnerRequest(String userName, String partnerToRemoveUserName) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException("User not found with username: " + userName);
        }
        User partnerToRemove = userRepository.findByUserName(partnerToRemoveUserName);
        if (partnerToRemove == null) {
            throw new UserNotFoundException("User not found with username: " + partnerToRemoveUserName);
        }
        Set<User> partnershipRequests = user.getPartnerRequests();
        if (partnershipRequests == null) {
            throw new NoPartnerRequestsException("No Partner Requests found");
        }
        partnershipRequests.remove(partnerToRemove);
        userRepository.save(user);
        userRepository.save(partnerToRemove);
    }

    public void acceptPartnershipRequest(String userName, String partnerToAcceptUserName) {
        User user = userRepository.findByUserName(userName);
        User partnerToAccept = userRepository.findByUserName(partnerToAcceptUserName);
        Set<User> partnershipRequest = user.getPartnerRequests();
        Set<User> partnership = user.getPartners();
        partnership.add(partnerToAccept);
        partnershipRequest.remove(partnerToAccept);
        userRepository.save(user);
        userRepository.save(partnerToAccept);
    }

    public void addPartnershipRequest(String userName, String desiredPartnerUserName) {
        // Find the user by their username
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException("User not found with username: " + userName);
        }

        // Find the desired partner by their username
        User desiredPartner = userRepository.findByUserName(desiredPartnerUserName);
        if (desiredPartner == null) {
            throw new UserNotFoundException("Desired partner not found with username: " + desiredPartnerUserName);
        }

        // Check if the user and desired partner are not the same user
        if (user.equals(desiredPartner)) {
            throw new IllegalArgumentException("You can't send a partnership request to yourself.");
        }
        

        // Add the user to the desired partner's partnership request list
        desiredPartner.getPartnerRequests().add(user);

        // Update the user
        userRepository.save(user);
        userRepository.save(desiredPartner);
    }




    @Override
    public Set<User> getPartners(String userName) {
        User user = userRepository.findByUserName(userName);
        Set<User> partners = user.getPartners();
        if (partners != null) {
            return partners;
        }
        return null;
    }

    @Override
    public void removePartner(String userName, String partnerToRemoveUserName) {
        User user = userRepository.findByUserName(userName);
        Set<User> partners = user.getPartners();
        if (partners != null) {

            User partnerToRemove = userRepository.findByUserName(partnerToRemoveUserName);
            if (partners.contains(partnerToRemove)) {
                partners.remove(partnerToRemove);
                userRepository.save(user);
            }
        }
    }





}
