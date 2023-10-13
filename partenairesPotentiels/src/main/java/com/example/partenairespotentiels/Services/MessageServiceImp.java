package com.example.partenairespotentiels.Services;


import com.example.partenairespotentiels.Entities.Discussion;
import com.example.partenairespotentiels.Entities.Message;
import com.example.partenairespotentiels.Repositories.DiscussionRepository;
import com.example.partenairespotentiels.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService{

    @Autowired
    MessageRepository messageRepository;


    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Long id, Message message) {
        Message existingMessage = messageRepository.findById(id).orElse(null);
        if (existingMessage != null) {
            // Update properties of the existing message with the new message
            // You can add logic here to update specific properties as needed
            existingMessage.setContenuMessage(message.getContenuMessage());
            existingMessage.setDateEnvoiMessage(message.getDateEnvoiMessage());

            return messageRepository.save(existingMessage);
        }
        return null; // Message not found
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

}