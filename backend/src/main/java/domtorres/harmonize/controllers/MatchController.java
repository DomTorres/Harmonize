package domtorres.harmonize.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domtorres.harmonize.services.MatchService;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/like/{likedUsername}")
    public ResponseEntity<?> likeUser(@PathVariable String likedUsername, Authentication authentication) {
        String currentUsername = authentication.getName();
        boolean isMatch = matchService.likeUser(currentUsername, likedUsername);

        if (isMatch) {
            return ResponseEntity.ok().body("It's a match!");
        }

        return ResponseEntity.ok().body("Like registered");
    }

    @GetMapping("/isMatched/{otherUsername}")
    public ResponseEntity<Boolean> isMatched(@PathVariable String otherUsername, Authentication authentication) {
        String currentUsername = authentication.getName();
        boolean matched = matchService.isMatched(currentUsername, otherUsername);
        return ResponseEntity.ok(matched);
    }
}
