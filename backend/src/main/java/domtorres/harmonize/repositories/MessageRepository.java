package domtorres.harmonize.repositories;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import domtorres.harmonize.models.Message;

public interface MessageRepository extends Neo4jRepository<Message, Long> {
    List<Message> findBySenderUsernameAndRecipientUsername(String username, String recipient);
}
