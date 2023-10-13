package com.example.partenairespotentiels.Services;

import com.example.partenairespotentiels.Entities.Discussion;
import com.example.partenairespotentiels.Entities.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();
    Message getMessageById(Long id);
    Message createMessage(Message message);
    Message updateMessage(Long id, Message message);
    void deleteMessage(Long id);
}
