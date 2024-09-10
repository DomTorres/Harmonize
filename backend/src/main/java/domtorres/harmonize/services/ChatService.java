// package domtorres.harmonize.services;

// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import domtorres.harmonize.models.Message;
// import domtorres.harmonize.models.User;
// import domtorres.harmonize.objects.ChatMessage;
// import domtorres.harmonize.repositories.MessageRepository;
// import domtorres.harmonize.repositories.UserRepository;

// @Service
// public class ChatService {

//     private MessageRepository messageRepository;

//     private UserRepository userRepository;

//     public Message saveMessage(ChatMessage chatMessage) {
//         User sender = userRepository
//             .findUserByUsername(chatMessage.getSender())
//             .orElseThrow(() -> new UsernameNotFoundException(""));

//         User recipient = userRepository
//             .findUserByUsername(chatMessage.getRecipient())
//             .orElseThrow(() -> new UsernameNotFoundException(""));

//         Message message = new Message();
//         message.setContent(chatMessage.getContent());
//         message.setTimestamp(LocalDateTime.now());
//         message.setSender(sender);
//         message.setRecipient(recipient);

//         return messageRepository.save(message);
//     }

//     public List<Message> getConversation(String user1, String user2) {
//         return messageRepository.findBySenderUsernameAndRecipientUsername(user1, user2);
//     }
// }
