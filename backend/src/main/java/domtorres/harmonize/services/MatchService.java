package domtorres.harmonize.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import domtorres.harmonize.models.User;
import domtorres.harmonize.repositories.UserRepository;

@Service
public class MatchService {

    private static final Logger log = LoggerFactory.getLogger(MatchService.class);

    @Autowired
    private UserRepository userRepository;

    public boolean likeUser(String currentUsername, String likedUsername) {
        User currentUser = userRepository
            .findUserByUsername(currentUsername)
            .orElseThrow(() -> new UsernameNotFoundException(""));

        User likedUser = userRepository
            .findUserByUsername(likedUsername)
            .orElseThrow(() -> new UsernameNotFoundException(""));

        currentUser.getLikes().add(likedUser);
        userRepository.save(currentUser);

        log.info(currentUser.getUsername());
        log.info(likedUser.getUsername());

        log.info("_____");

        for (User user : currentUser.getLikes()) {
            log.info(user.getUsername());
        }

        log.info("_____");

        for (User user : likedUser.getLikes()) {
            log.info(user.getUsername());
        }

        // log.info(likedUser.getLikes().toString());

        // Check if mutual
        if (likedUser.getLikes().contains(currentUser)) {
            log.info("HERE!");
            createMatch(currentUser, likedUser);
            return true;
        }

        return false;
    }

    private void createMatch(User user1, User user2) {
        user1.getMatches().add(user2);
        userRepository.save(user1);

        user2.getMatches().add(user1);
        userRepository.save(user2);
    }

    public boolean isMatched(String username1, String username2) {
        User user1 = userRepository
            .findUserByUsername(username1)
            .orElseThrow(() -> new UsernameNotFoundException(""));

        return user1.getMatches().stream()
            .anyMatch(user -> user.getUsername().equals(username2));
    }
}
