package com.example.partenairespotentiels.Controllers;


import com.example.partenairespotentiels.Entities.Discussion;
import com.example.partenairespotentiels.Entities.Message;
import com.example.partenairespotentiels.Entities.User;
import com.example.partenairespotentiels.Repositories.DiscussionRepository;
import com.example.partenairespotentiels.Repositories.MessageRepository;
import com.example.partenairespotentiels.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/partenairesPotentiels")
public class PartenairesPotentielsController {

    @Autowired
    public DiscussionService discussionService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public MessageService messageService;

    @Autowired
    public UserService userService;

    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    MessageRepository messageRepository;


    @MessageMapping("/chat/{to}") //to = nome canale
    public void sendMessage(@DestinationVariable String to , Message message) {
        System.out.println("handling send message: " + message + " to: " + to);
        Discussion discussion = discussionRepository.findById(createAndOrGetChat(to)).orElse(null);;
        message.setDiscussion(discussion);
        message.setDateEnvoiMessage(generateTimeStamp());
        message = messageRepository.save(message);
        simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
    }

    //finds the chat whose name is the parameter, if it doesn't exist it gets created, the ID gets returned either way
    private Long createAndOrGetChat(String name) {
        Discussion discussion = discussionRepository.findByName(name);

        if (discussion != null) {
            return discussion.getIdDiscussion();
        }
        else {
            Discussion newChat = new Discussion(name);
            return discussionRepository.save(newChat).getIdDiscussion();
        }
    }

    private String generateTimeStamp() {
        Instant i = Instant.now();
        String date = i.toString();
        System.out.println("Source: " + i.toString());
        int endRange = date.indexOf('T');
        date = date.substring(0, endRange);
        date = date.replace('-', '/');
        System.out.println("Date extracted: " + date);
        String time = Integer.toString(i.atZone(ZoneOffset.UTC).getHour() + 1);
        time += ":";

        int minutes = i.atZone(ZoneOffset.UTC).getMinute();
        if (minutes > 9) {
            time += Integer.toString(minutes);
        } else {
            time += "0" + Integer.toString(minutes);
        }

        System.out.println("Time extracted: " + time);
        String timeStamp = date + "-" + time;
        return timeStamp;
    }
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
  //  @GetMapping(value = "/retrieveallusers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> retrieveAllUsers(){
        return userService.retrieveAllUsers();
    };

    @PutMapping("/deleteuser/{idUser}")
    public Boolean deleteUser(@PathVariable String idUser){
        return userService.deleteUser(idUser);
    };

    @GetMapping("/partners/{userName}")
    public Set<User> getPartners(@PathVariable String userName) {
        return userService.getPartners(userName);
    }

    @DeleteMapping("/removePartner/{userName}/{partnerToRemoveUserName}")
    public void removePartner(@PathVariable String userName, @PathVariable String partnerToRemoveUserName) {
        userService.removePartner(userName, partnerToRemoveUserName);
    }

    @GetMapping("/partnerRequests/{userName}")
    public Set<User> getPartnerRequests(@PathVariable String userName) {
        return userService.getPartnerRequests(userName);
    }

    @DeleteMapping("/removePartnerRequest/{userName}/{partnerRequestToRemoveUserName}")
    public void removePartnerRequest(@PathVariable String userName, @PathVariable String partnerRequestToRemoveUserName) {
        userService.removePartnerRequest(userName, partnerRequestToRemoveUserName);
    }

    @PostMapping("/acceptPartnership/{userName}/{partnerRequestToAcceptUserName}")
    public void acceptPartnership(@PathVariable String userName, @PathVariable String partnerRequestToAcceptUserName) {
        userService.acceptPartnershipRequest(userName, partnerRequestToAcceptUserName);
    }
    @PostMapping("/addPartnershipRequest/{userName}/{desiredPartnerUserName}")
    public void addPartnershipRequest(@PathVariable String userName, @PathVariable String desiredPartnerUserName) {
        userService.addPartnershipRequest(userName, desiredPartnerUserName);
    }

}
