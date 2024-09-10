package domtorres.harmonize.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import domtorres.harmonize.models.Message;
// import domtorres.harmonize.services.ChatService;
// import domtorres.harmonize.services.MatchService;

@Controller
public class ChatController {

    //    @Autowired
    // private MatchService matchService;

    // @Autowired
    // private ChatService chatService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message") // send to app/message
    public Message sendMessage(@Payload Message message) {
        simpMessagingTemplate.convertAndSendToUser(message.getRecipient().getUsername(), "/chat", message); // /user/USERNAME/chat
        return message;
    }

}
