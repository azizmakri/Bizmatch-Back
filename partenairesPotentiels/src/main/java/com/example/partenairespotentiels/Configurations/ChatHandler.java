package com.example.partenairespotentiels.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatHandler extends TextWebSocketHandler {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public ChatHandler(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Gérez la réception et la diffusion des messages ici
        messagingTemplate.convertAndSend("/topic/chat", message.getPayload());
    }
}
