package com.example.partenairespotentiels.Controllers;


import com.example.partenairespotentiels.Entities.Discussion;
import com.example.partenairespotentiels.Entities.Message;
import com.example.partenairespotentiels.Entities.User;
import com.example.partenairespotentiels.Services.DiscussionService;
import com.example.partenairespotentiels.Services.MessageService;
import com.example.partenairespotentiels.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partenairesPotentiels")
public class PartenairesPotentielsController {

    @Autowired
    public DiscussionService discussionService;

    @Autowired
    public MessageService messageService;

    @Autowired
    public UserService userService;

    @GetMapping("/getAllDiscussions")
    public ResponseEntity<List<Discussion>> getAllDiscussions() {
        List<Discussion> discussions = discussionService.getAllDiscussions();
        return new ResponseEntity<>(discussions, HttpStatus.OK);
    }

    // Endpoint pour obtenir une discussion par ID
    @GetMapping("/getDiscussionById/{id}")
    public ResponseEntity<Discussion> getDiscussionById(@PathVariable Long id) {
        Discussion discussion = discussionService.getDiscussionById(id);
        if (discussion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discussion, HttpStatus.OK);
    }

    // Endpoint pour créer une discussion
    @PostMapping("/createDiscussion")
    public ResponseEntity<Discussion> createDiscussion(@RequestBody Discussion discussion) {
        Discussion createdDiscussion = discussionService.createDiscussion(discussion);
        return new ResponseEntity<>(createdDiscussion, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour une discussion par ID
    @PutMapping("/updateDiscussion/{id}")
    public ResponseEntity<Discussion> updateDiscussion(@PathVariable Long id, @RequestBody Discussion discussion) {
        Discussion updatedDiscussion = discussionService.updateDiscussion(id, discussion);
        if (updatedDiscussion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedDiscussion, HttpStatus.OK);
    }

    // Endpoint pour supprimer une discussion par ID
    @DeleteMapping("/deleteDiscussion/{id}")
    public ResponseEntity<Void> deleteDiscussion(@PathVariable Long id) {
        discussionService.deleteDiscussion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint pour obtenir tous les messages
    @GetMapping("/getAllMessages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    // Endpoint pour obtenir un message par ID
    @GetMapping("/getMessageById/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Message message = messageService.getMessageById(id);
        if (message == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Endpoint pour créer un message
    @PostMapping("/createMessage")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un message par ID
    @PutMapping("/updateMessage/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {
        Message updatedMessage = messageService.updateMessage(id, message);
        if (updatedMessage == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedMessage, HttpStatus.OK);
    }

    // Endpoint pour supprimer un message par ID
    @DeleteMapping("/deleteMessage/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    };

    @PostMapping("/updateuser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    };

    @GetMapping("/retrieveuserbyid/{idUser}")
    public User retrieveUserById(@PathVariable String idUser){
        return userService.retrieveUserById(idUser);
    };

    @GetMapping("/retrieveallusers")
    public List<User> retrieveAllUsers(){
        return userService.retrieveAllUsers();
    };

    @PutMapping("/deleteuser/{idUser}")
    public Boolean deleteUser(@PathVariable String idUser){
        return userService.deleteUser(idUser);
    };

}
